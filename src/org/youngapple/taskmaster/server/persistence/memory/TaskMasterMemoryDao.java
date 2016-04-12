package org.youngapple.taskmaster.server.persistence.memory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.youngapple.taskmaster.server.persistence.TaskMasterDao;
import org.youngapple.taskmaster.server.service.Query;
import org.youngapple.taskmaster.server.service.Task;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/**
 */
public class TaskMasterMemoryDao implements TaskMasterDao {

  public static final AtomicLong ID_SEQUENCE = new AtomicLong(0L);

  private final Map<Long, Task> idMap = Maps.newConcurrentMap();
  private final Map<String, Map<Integer, Set<Task>>> groupToPriorityMap = Maps.newConcurrentMap();

  @Override
  public List<Task> getByIds(List<Long> ids) {
    List<Task> results = Lists.newArrayListWithCapacity(ids.size());
    for (Long id : ids) {
      results.add(idMap.get(id));
    }
    return results;
  }

  /**
   * Gets the tasks match the query. No access checking.
   */
  @Override
  public List<Task> getByQuery(Query query) {
    return postFilter(Lists.newArrayList(idMap.values()), query);
  }

  private List<Task> postFilter(List<Task> input, Query query) {
    List<Task> results = Lists.newArrayListWithCapacity(Math.min(input.size(), query.getLimit()));
    for (Task task : input) {
      boolean lastCompare = true;
      // query specified task id.
      if (query.isSetId()) {
        lastCompare &= (query.getId() == task.getId());
      }

      // query group
      if (lastCompare && query.isSetGroup()) {
        lastCompare &= query.getGroup().equals(task.getGroup());
      }
      // query priority
      if (lastCompare && query.isSetPriority()) {
        lastCompare &= (query.getPriority() == task.getPriority());
      }
      // query acl
      // TODO(yangshuguo): check runtime acl
      if (lastCompare && query.isSetAcl()) {
        lastCompare &= query.getAcl().equals(task.getAcl());
      }

      if (lastCompare) {
        results.add(task);
        if (results.size() == query.getLimit()) {
          break;
        }
      }
    }
    return results;
  }

  @Override
  public void create(List<Task> tasks) {
    // assign ids
    for (Task task : tasks) {
      task.setId(ID_SEQUENCE.getAndIncrement());
      idMap.put(task.getId(), task);

      String group = task.getGroup();
      if (!groupToPriorityMap.containsKey(group)) {
        groupToPriorityMap.put(group, Maps.newConcurrentMap());
      }
      Map<Integer, Set<Task>> priorityToTaskMap = groupToPriorityMap.get(group);
      int priority = task.getPriority();
      if (!priorityToTaskMap.containsKey(priority)) {
        priorityToTaskMap.put(priority, Sets.newConcurrentHashSet());
      }
      priorityToTaskMap.get(priority).add(task);
    }
  }

  @Override
  public void delete(List<Task> tasks) {
    for (Task task : tasks) {
      idMap.remove(task.getId());
      groupToPriorityMap.get(task.getGroup()).get(task.getPriority()).remove(task);
    }
  }

  @Override
  public void update(List<Task> tasksToDelete, List<Task> tasksToCreate) {
    delete(tasksToCreate);
    create(tasksToCreate);
  }
}
