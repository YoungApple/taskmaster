package com.company.old;

import java.util.List;

/**
 */
public interface TaskMaster {

  /**
   * Creates a task.
   *
   * @param taskGroup the group this task belongs to.
   * @param priority  the priority of this task.
   * @param payload   the payload of this task.
   */
  void createTask(String taskGroup, int priority, String payload);

  /**
   * Return all matched tasks.
   */
  List<Task> query(String taskGroup, int priority, int limit); // will return all tasks matched.

  int getTotalTaskSize();

  /**
   * Return all tasks match the query and also mark these tasks owned by this client in a given period.
   *
   * @param client    the client identity
   * @param taskGroup the task group to query
   * @param limit     the max return size of the tasks
   * @param seconds   the lease length in seconds
   */
  List<Task> queryAndOwn(String client, String taskGroup, int priority, int limit, int seconds);
  // Should record the client, calculate a timestampToExpair
  // will increase task ids, how long to release the tasks.

  /**
   * Extends the lease length.
   *
   * @param client  the client identity
   * @param tasks   the tasks to copyToUpdate
   * @param seconds the extended lease length in seconds.
   */
  List<Task> update(String client, List<Task> tasks, int seconds); // copyToUpdate the timer.

  /**
   * Deletes the tasks.
   */
  boolean delete(String client, List<Task> tasks); // normally finished tasks
}
