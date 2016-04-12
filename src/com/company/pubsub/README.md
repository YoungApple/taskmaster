PubSub is a library to support a pub-sub systems in the real network.

Publisher
- It register itself in PubSubServer for a specific topic with a specific strategy.
- It publishes a message to a specific topic.
- Optional: with a callback. Callback will be invoked when the message is done(depends on the strategy).


PubSubServer (Don't consider consistence, central point):
It is an online service which could receive published messages and then deliver them to Subscribers.
- Register receivers for each topic (AdHoc, Persisted).
- Maintain the state of the message: New, Acked.
- It needs to maintain the state of a message: New, Received, All-Received.

- He needs to persist the messages received before subscribe.
Rely on a storage.


Subscriber
It is a client who hold a connection to the PubSubStub.
- It register itself in PubSubServer for a specific topic.
- It register a callback when a message is coming.
- It should ACK the PubSubServer.


Topic: a global unique string, with a ACL and strategy.
- This should be created in PubSubService admin.


Key responsibility: maintain a live list for all subscribers.


=====================================================
TaskDto:
  Long id;  // always increase, readonly
  String taskGroup; // readonly
  int priority; // readonly
  byte[] data; // less than 10K, readonly

TaskMasterServer:
- Result createTask(String taskGroup, int priority, byte[] data);
- List<TaskDto> query(String taskGroup, int limit); // will return all tasks matched.

- List<TaskDto> queryAndOwn(String taskGroup, int limit); // will increase task ids.
- List<TaskDto> queryAndOwn(String taskGroup, int limit, int seconds); // will increase task ids, how long to release the tasks.
- List<TaskDto> update(List<TaskDto> tasks, int seconds); // update the timer.
- Result delete(List<TaskDto> tasks); // normally finished tasks

A create several tasks t1, t2, t3, t4, t5, t6.
T0:  B queryAndOwn(limit=2, seconds=600). Get t1, t2.
T3:  C queryAndOwn(limit=5, seconds=600). Get t3, t4, t5, t6
T4:  D queryAndOwn(limit=1, seconds=600). Empty
T10: D queryAndOwn(limit=1, seconds=600), Get t1(t1's id changed to 7).
T11: B finished tasks t1, t2. delete(t1, t2). Failed. Since t1 is not exist.
T12: C finished t3, delete(t3). Success. Since t3 is still valid.
T12: C update(t4, t5, t6). Success. Get t4, t5, t6 (IDs changed to 8, 9, 10).