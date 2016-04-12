package org.youngapple.taskmaster.server;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.youngapple.taskmaster.server.persistence.PersistenceModule;
import org.youngapple.taskmaster.server.service.TaskMasterService;
import org.youngapple.taskmaster.server.service.impl.TaskMasterServiceImpl;

/**
 */
public class ServerModule extends AbstractModule {

  @Override
  protected void configure() {
    install(new PersistenceModule());
    bind(TaskMasterService.Iface.class).to(TaskMasterServiceImpl.class).in(Singleton.class);
  }
}
