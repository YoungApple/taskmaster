package com.company.old;

import java.util.List;

/**
 *
 */
public interface TaskMasterService {

  void create(List<Task> tasks);

  void delete(List<Task> tasks);

  List<Task> update(List<Task> tasks);

  List<Task> query(QueryInfo queryInfo, boolean own);
}
