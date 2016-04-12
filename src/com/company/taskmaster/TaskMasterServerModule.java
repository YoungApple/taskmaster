package com.company.taskmaster;

import com.company.old.TaskMaster;
import com.google.inject.AbstractModule;

/**
 */
public class TaskMasterServerModule extends AbstractModule {

    @Override
    protected void configure() {
      bind(TaskMaster.class).to(TaskMasterInMemoryImpl.class);
    }
}
