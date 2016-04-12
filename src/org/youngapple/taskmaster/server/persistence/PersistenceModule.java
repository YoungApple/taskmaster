package org.youngapple.taskmaster.server.persistence;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.youngapple.taskmaster.server.persistence.mongo.TaskMasterMongoDao;

/**
 * Persistence binding.
 */
public class PersistenceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TaskMasterDao.class).to(TaskMasterMongoDao.class).in(Singleton.class);
  }
}
