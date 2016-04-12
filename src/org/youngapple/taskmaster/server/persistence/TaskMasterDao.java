package org.youngapple.taskmaster.server.persistence;

import org.youngapple.taskmaster.server.service.Query;
import org.youngapple.taskmaster.server.service.Task;

import java.util.List;

/**
 */
public interface TaskMasterDao {

  List<Task> getByIds(List<Long> ids);

  List<Task> getByQuery(Query query);

  void create(List<Task> tasks);

  void delete(List<Task> tasks);

  // Transactional
  void update(List<Task> tasksToDelete, List<Task> tasksToCreate);
}
