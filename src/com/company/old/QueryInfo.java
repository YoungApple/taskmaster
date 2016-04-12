package com.company.old;

/**
 */
public class QueryInfo {

  private final String group;
  private final int priority;
  private final long timestamp;
  private final int limit;


  public String getGroup() {
    return group;
  }

  public int getPriority() {
    return priority;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public int getLimit() {
    return limit;
  }

  private QueryInfo(String group, int priority, long timestamp, int limit) {
    assert group != null;
    this.group = group;
    this.priority = priority;
    this.timestamp = timestamp;
    this.limit = limit;
  }

  public class QueryInfoBuilder {
    private String group;
    private int priority = 0;
    private long timestamp = 0;
    private int limit = 100;

    public void setGroup(String group) {
      this.group = group;
    }

    public void setPriority(int priority) {
      this.priority = priority;
    }

    public void setTimestamp(long timestamp) {
      this.timestamp = timestamp;
    }

    public void setLimit(int limit) {
      this.limit = limit;
    }

    public QueryInfo build() {
      return new QueryInfo(group, priority, timestamp, limit);
    }
  }
}
