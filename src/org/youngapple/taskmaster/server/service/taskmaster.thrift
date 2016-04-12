namespace java org.youngapple.taskmaster.server.service

struct Task {
    1: optional i64 id;
    2: optional string group;
    3: optional string acl;
    4: optional i32 priority;
    5: optional i64 timestamp;
    6: optional string payload;
}

struct Query {
    1: optional i64 id;
    2: optional string group;
    3: optional string acl;
    4: optional i32 priority;
    5: optional i64 timestamp;
    6: optional i32 limit;
    7: optional byte orderBy;
}

service TaskMasterService {
    void createTasks(1: list<Task> tasks);
    void deleteTasks(1: list<Task> tasks);
    list<Task> updateTasks(1: list<Task> tasks);
    list<Task> query(1: Query query);
    list<Task> queryAndOwn(1: Query query, 2: i32 seconds);
}
