package com.company.taskmaster;

import com.company.old.Task;
import com.company.old.TaskMaster;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 *
 */
public class TaskMasterInMemoryImplTest {

  TaskMaster taskMaster = null;

  @Before
  public void setUp() throws Exception {
    taskMaster = new TaskMasterInMemoryImpl();
    for (int i = 0; i < 100; i++) {
      taskMaster.createTask("Test", 10, "" + i);
    }
    for (int i = 0; i < 100; i++) {
      taskMaster.createTask("Test", 20, "" + i);
    }
  }

  @Test
  public void testQuery() throws Exception {
    System.out.println(taskMaster.query("Test", 10, 20));
    assertEquals(taskMaster.getTotalTaskSize(), 200);
  }

  @Test
  public void testQueryAndOwn() throws Exception {
    System.out.println(taskMaster.queryAndOwn("YSG", "Test", 10, 20, 20));
    assertEquals(taskMaster.getTotalTaskSize(), 200);
  }

  @Test
  public void testUpdate() throws Exception {
  }

  @Test
  public void testDelete() throws Exception {
    // 'YSG' owned 50 tasks for 3s.
    List<Task> taskList = taskMaster.queryAndOwn("YSG", "Test", 10, 50, 3 /* 3s */);
    // can't delete the tasks that you not own.
    taskMaster.delete("AHAHA", taskList);
    assertEquals(taskMaster.getTotalTaskSize(), 200);
    taskMaster.delete("YSG", taskList);
  }
}