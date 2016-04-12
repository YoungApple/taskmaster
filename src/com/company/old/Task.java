package com.company.old;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * A task.
 */
public class Task implements Serializable, Comparable<Task> {

  /**
   * The id of this task.
   * This ID is global unique and readonly.
   */
  private Long id;

  /**
   * The task group name this task belongs to.
   */
  private String group;

  /**
   * The priority of the task. The smaller the higher.
   */
  private int priority;

  /**
   * The timestamp this task will be invalid.
   */
  private long timestamp;

  /**
   * The identifier of the owner this task belongs to.
   */
  private String owner;

  /**
   * The payload of this task. It should not exceed 10K size.
   */
  private String data;

  public Task(Long id, String group, int priority, String data) {
    this(id, group, priority, data, 0, null);
  }

  private Task(Long id, String group, int priority, String data, long timestamp, String owner) {
    assert id != null;
    assert group != null;
    // data size should be smaller than 10K.
    assert data == null || data.length() < 10240;

    this.id = id;
    this.group = group;
    this.priority = priority;
    this.data = data;
    this.timestamp = timestamp;
    this.owner = owner;
  }

  public Task copyToOwn(Long newId, long newTimestamp, String owner) {
    assert newTimestamp > timestamp;
    return new Task(newId, group, priority, data, newTimestamp, owner);
  }

  public Task copyToUpdate(Long newId, long newTimestamp) {
    assert newTimestamp > timestamp;
    return new Task(newId, group, priority, data, newTimestamp, owner);
  }

  @Override
  public boolean equals(Object other) {
    if (other == null || !(other instanceof Task)) {
      return false;
    }
    Task that = (Task) other;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("group", group)
        .add("priority", priority)
        .add("data", data)
        .add("owner", owner)
        .add("timestamp", timestamp)
        .toString();
  }

  public Long getId() {
    return id;
  }

  public String getGroup() {
    return group;
  }

  public int getPriority() {
    return priority;
  }

  public String getData() {
    return data;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getOwner() {
    return owner;
  }

  @Override
  public int compareTo(Task other) {
    return id.compareTo(other.getId());
  }
}
