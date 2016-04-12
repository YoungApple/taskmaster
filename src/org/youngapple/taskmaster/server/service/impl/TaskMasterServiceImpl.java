package org.youngapple.taskmaster.server.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import org.apache.thrift.TException;
import org.youngapple.taskmaster.server.persistence.TaskMasterDao;
import org.youngapple.taskmaster.server.service.Query;
import org.youngapple.taskmaster.server.service.Task;
import org.youngapple.taskmaster.server.service.TaskMasterService;

import java.util.List;
import java.util.Map;

/**
 */
public class TaskMasterServiceImpl implements TaskMasterService.Iface {

  private final TaskMasterDao taskMasterDao;

  @Inject
  public TaskMasterServiceImpl(TaskMasterDao taskMasterDao) {
    this.taskMasterDao = taskMasterDao;
    System.out.println("... injected tastMasterDao:" + taskMasterDao.getClass());
  }

  @Override
  public void createTasks(List<Task> tasks) throws TException {
    System.out.println("......creat tasks......");
    // No ids
    for (Task task : tasks) {
      Preconditions.checkArgument(!task.isSetId()
          && task.isSetGroup()
          && task.getGroup().length() > 0,
          "Can't create tasks who has an ID or does not has a task group.");
    }
    taskMasterDao.create(tasks);
  }

  @Override
  public void deleteTasks(List<Task> tasks) throws TException {
    System.out.println("......delete......");
    for (Task task : tasks) {
      Preconditions.checkArgument(task.isSetId(),
          "Can't delete a task who doesn't has an ID.");
    }
    taskMasterDao.delete(tasks);
  }

  /**
   * A task could be updated iff
   *   1) its timestamp is modified to a greater value
   *   2) has the same ACL
   */
  @Override
  public List<Task> updateTasks(List<Task> tasks) throws TException {
    System.out.println("......update......");
    for (Task task : tasks) {
      Preconditions.checkArgument(task.isSetId(),
          "Can't delete a task who doesn't has an ID.");
    }
    List<Long> ids = Lists.transform(tasks, input -> input.getId());
    List<Task> originalTasks = taskMasterDao.getByIds(ids);
    Map<Long, Task> originalIdToTaskMap = Maps.uniqueIndex(originalTasks, input -> input.getId());

    List<Task> tasksToCreate = Lists.newArrayListWithCapacity(tasks.size());
    for (Task task : tasks) {
      Task originalTask = originalIdToTaskMap.get(task.getId());
      if (originalTask != null) {
        // Same ACL, newer timestamp
        Preconditions.checkArgument(originalTask.getAcl().equals(task.getAcl()));
        Preconditions.checkArgument(originalTask.getTimestamp() < task.getTimestamp());
        // copy
        Task taskToCreate = task.deepCopy();
        taskToCreate.unsetId();
        tasksToCreate.add(taskToCreate);
      }
    }

    taskMasterDao.update(originalTasks, tasksToCreate);
    return tasksToCreate;
  }

  @Override
  public List<Task> query(Query query) throws TException {
    System.out.println("......query......");
    return taskMasterDao.getByQuery(query);
  }

  @Override
  public List<Task> queryAndOwn(Query query, int seconds) throws TException {
    System.out.println("......queryAndOwn......");
    List<Task> tasksToDelete = taskMasterDao.getByQuery(query);
    List<Task> tasksToCreate = Lists.newArrayListWithCapacity(tasksToDelete.size());
    for (Task task : tasksToDelete) {
      Task newTask = task.deepCopy();
      newTask.unsetId();
      // TODO(yangshuguo): fetch client auth spec
      newTask.setAcl("");
      newTask.setTimestamp(System.currentTimeMillis() + seconds * 1000000);
    }
    taskMasterDao.update(tasksToDelete, tasksToCreate);
    return tasksToCreate;
  }
}
