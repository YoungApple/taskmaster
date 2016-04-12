package com.company.taskmaster;

import com.company.old.Task;
import com.company.old.TaskMaster;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 */
public class TaskMasterInMemoryImpl implements TaskMaster {

  public static final AtomicLong ID_SEQUENCE = new AtomicLong(0L);

  /**
   * key: task group
   * value: a map from priority to task.
   */
  private final Map<String, Map<Integer, Set<Task>>> TASK_MAP = Maps.newConcurrentMap();
  private final Map<Long, Task> ID_TASK_MAP = Maps.newConcurrentMap();

  @Override
  public void createTask(String taskGroup, int priority, String payload) {
    assert taskGroup != null;
    addTask(new Task(getNextId(), taskGroup, priority, payload));
  }

  private boolean addTask(Task task) {
    String taskGroup = task.getGroup();
    if (!TASK_MAP.containsKey(taskGroup)) {
      synchronized (TASK_MAP) {
        if (!TASK_MAP.containsKey(taskGroup)) {
          TASK_MAP.put(taskGroup, Maps.newConcurrentMap());
        }
      }
    }

    int priority = task.getPriority();
    Map<Integer, Set<Task>> priorityToTasksMap = TASK_MAP.get(taskGroup);
    if (!priorityToTasksMap.containsKey(priority)) {
      synchronized (priorityToTasksMap) {
        if (!priorityToTasksMap.containsKey(priority)) {
          priorityToTasksMap.put(priority, Sets.newTreeSet());
        }
      }
    }

    // add the task to the map
    priorityToTasksMap.get(priority).add(task);
    ID_TASK_MAP.put(task.getId(), task);
    return true;
  }

  private boolean removeTask(Task task) {
    String taskGroup = task.getGroup();
    int priority = task.getPriority();
    if (TASK_MAP.containsKey(taskGroup)) {
      if (TASK_MAP.get(taskGroup).containsKey(priority)) {
        // remove the task from the map
        ID_TASK_MAP.remove(task.getId());
        return TASK_MAP.get(taskGroup).get(priority).remove(task);
      }
    }
    return false;
  }

  @Override
  public List<Task> query(String taskGroup, int priority, int limit) {
    assert limit < 1000;
    return query(taskGroup, priority, limit, false);
  }

  @Override
  public int getTotalTaskSize() {
    return ID_TASK_MAP.values().size();
  }

  private List<Task> query(String taskGroup, int priority, int limit, boolean toOwn) {
    List<Task> results = Lists.newArrayList();
    if (TASK_MAP.containsKey(taskGroup)) {
      if (TASK_MAP.get(taskGroup).containsKey(priority)) {
        Iterator<Task> it = TASK_MAP.get(taskGroup).get(priority).iterator();
        while (it.hasNext() && limit > 0) {
          Task task = it.next();
          if (!toOwn || System.currentTimeMillis() > task.getTimestamp()) {
            results.add(it.next());
            limit--;
          }
        }
      }
    }
    return results;
  }

  @Override
  public List<Task> queryAndOwn(String client, String taskGroup, int priority, int limit, int seconds) {
    assert client != null;
    assert seconds > 0;
    List<Task> tasks = query(taskGroup, priority, limit, true);
    List<Task> ownedTasks = Lists.newArrayListWithCapacity(tasks.size());
    for (Task task : tasks) {
      Task taskToAdd = task.copyToOwn(getNextId(), System.currentTimeMillis() + seconds * 1000000, client);
      removeTask(task);
      addTask(taskToAdd);
      ownedTasks.add(taskToAdd);
    }
    return ownedTasks;
  }

  private Long getNextId() {
    return ID_SEQUENCE.getAndIncrement();
  }

  /**
   * Return the persisted tasks which match the ids and the client spec.
   * @param tasks the tasks to query
   * @param client the client spec
   */
  private List<Task> getTaskByIds(List<Task> tasks, String client) {
    Set<Long> ids = Sets.newConcurrentHashSet();
    for (Task task : tasks) {
      ids.add(task.getId());
    }
    List<Task> taskDtos = Lists.newArrayListWithCapacity(ids.size());
    for (Long id : ids) {
      Task task = ID_TASK_MAP.get(id);
      if (task != null && task.getOwner().equals(client)) {
        taskDtos.add(task);
      }
    }
    return taskDtos;
  }

  @Override
  public List<Task> update(String client, List<Task> tasks, int seconds) {
    assert client != null;
    assert seconds > 0;
    // don't need to check the timestamp since only the owner can copyToUpdate the tasks. If others owned the tasks,
    // the task ID will change.
    List<Task> loadTasks = getTaskByIds(tasks, client);
    List<Task> newTasks = Lists.newArrayListWithCapacity(loadTasks.size());
    for (Task task : loadTasks) {
      Task taskToAdd = task.copyToUpdate(getNextId(), System.currentTimeMillis() + seconds * 1000000);
      removeTask(task);
      addTask(taskToAdd);
      newTasks.add(taskToAdd);
    }
    return newTasks;
  }

  @Override
  public boolean delete(String client, List<Task> tasks) {
    assert client != null;
    List<Task> loadTasks = getTaskByIds(tasks, client);
    for (Task task : loadTasks) {
      removeTask(task);
    }
    return true;
  }
}
