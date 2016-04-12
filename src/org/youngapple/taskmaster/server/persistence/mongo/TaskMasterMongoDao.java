package org.youngapple.taskmaster.server.persistence.mongo;

import org.youngapple.taskmaster.server.persistence.TaskMasterDao;
import org.youngapple.taskmaster.server.service.Query;
import org.youngapple.taskmaster.server.service.Task;

import java.util.List;

/**
 */
public class TaskMasterMongoDao implements TaskMasterDao {

  @Override
  public List<Task> getByIds(List<Long> ids) {
    return null;
  }

  @Override
  public List<Task> getByQuery(Query query) {
    return null;
  }

  @Override
  public void create(List<Task> tasks) {
  }

  @Override
  public void delete(List<Task> tasks) {
  }

  @Override
  public void update(List<Task> tasksToDelete, List<Task> tasksToCreate) {
  }
}
