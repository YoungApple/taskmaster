/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.youngapple.taskmaster.server.service;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2016-02-06")
public class Query implements org.apache.thrift.TBase<Query, Query._Fields>, java.io.Serializable, Cloneable, Comparable<Query> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Query");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("id", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField GROUP_FIELD_DESC = new org.apache.thrift.protocol.TField("group", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField ACL_FIELD_DESC = new org.apache.thrift.protocol.TField("acl", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField PRIORITY_FIELD_DESC = new org.apache.thrift.protocol.TField("priority", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField LIMIT_FIELD_DESC = new org.apache.thrift.protocol.TField("limit", org.apache.thrift.protocol.TType.I32, (short)6);
  private static final org.apache.thrift.protocol.TField ORDER_BY_FIELD_DESC = new org.apache.thrift.protocol.TField("orderBy", org.apache.thrift.protocol.TType.BYTE, (short)7);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new QueryStandardSchemeFactory());
    schemes.put(TupleScheme.class, new QueryTupleSchemeFactory());
  }

  public long id; // optional
  public String group; // optional
  public String acl; // optional
  public int priority; // optional
  public long timestamp; // optional
  public int limit; // optional
  public byte orderBy; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "id"),
    GROUP((short)2, "group"),
    ACL((short)3, "acl"),
    PRIORITY((short)4, "priority"),
    TIMESTAMP((short)5, "timestamp"),
    LIMIT((short)6, "limit"),
    ORDER_BY((short)7, "orderBy");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // GROUP
          return GROUP;
        case 3: // ACL
          return ACL;
        case 4: // PRIORITY
          return PRIORITY;
        case 5: // TIMESTAMP
          return TIMESTAMP;
        case 6: // LIMIT
          return LIMIT;
        case 7: // ORDER_BY
          return ORDER_BY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __ID_ISSET_ID = 0;
  private static final int __PRIORITY_ISSET_ID = 1;
  private static final int __TIMESTAMP_ISSET_ID = 2;
  private static final int __LIMIT_ISSET_ID = 3;
  private static final int __ORDERBY_ISSET_ID = 4;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.ID,_Fields.GROUP,_Fields.ACL,_Fields.PRIORITY,_Fields.TIMESTAMP,_Fields.LIMIT,_Fields.ORDER_BY};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.GROUP, new org.apache.thrift.meta_data.FieldMetaData("group", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.ACL, new org.apache.thrift.meta_data.FieldMetaData("acl", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRIORITY, new org.apache.thrift.meta_data.FieldMetaData("priority", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.LIMIT, new org.apache.thrift.meta_data.FieldMetaData("limit", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.ORDER_BY, new org.apache.thrift.meta_data.FieldMetaData("orderBy", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Query.class, metaDataMap);
  }

  public Query() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Query(Query other) {
    __isset_bitfield = other.__isset_bitfield;
    this.id = other.id;
    if (other.isSetGroup()) {
      this.group = other.group;
    }
    if (other.isSetAcl()) {
      this.acl = other.acl;
    }
    this.priority = other.priority;
    this.timestamp = other.timestamp;
    this.limit = other.limit;
    this.orderBy = other.orderBy;
  }

  public Query deepCopy() {
    return new Query(this);
  }

  @Override
  public void clear() {
    setIdIsSet(false);
    this.id = 0;
    this.group = null;
    this.acl = null;
    setPriorityIsSet(false);
    this.priority = 0;
    setTimestampIsSet(false);
    this.timestamp = 0;
    setLimitIsSet(false);
    this.limit = 0;
    setOrderByIsSet(false);
    this.orderBy = 0;
  }

  public long getId() {
    return this.id;
  }

  public Query setId(long id) {
    this.id = id;
    setIdIsSet(true);
    return this;
  }

  public void unsetId() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
  }

  /** Returns true if field id is set (has been assigned a value) and false otherwise */
  public boolean isSetId() {
    return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
  }

  public void setIdIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
  }

  public String getGroup() {
    return this.group;
  }

  public Query setGroup(String group) {
    this.group = group;
    return this;
  }

  public void unsetGroup() {
    this.group = null;
  }

  /** Returns true if field group is set (has been assigned a value) and false otherwise */
  public boolean isSetGroup() {
    return this.group != null;
  }

  public void setGroupIsSet(boolean value) {
    if (!value) {
      this.group = null;
    }
  }

  public String getAcl() {
    return this.acl;
  }

  public Query setAcl(String acl) {
    this.acl = acl;
    return this;
  }

  public void unsetAcl() {
    this.acl = null;
  }

  /** Returns true if field acl is set (has been assigned a value) and false otherwise */
  public boolean isSetAcl() {
    return this.acl != null;
  }

  public void setAclIsSet(boolean value) {
    if (!value) {
      this.acl = null;
    }
  }

  public int getPriority() {
    return this.priority;
  }

  public Query setPriority(int priority) {
    this.priority = priority;
    setPriorityIsSet(true);
    return this;
  }

  public void unsetPriority() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PRIORITY_ISSET_ID);
  }

  /** Returns true if field priority is set (has been assigned a value) and false otherwise */
  public boolean isSetPriority() {
    return EncodingUtils.testBit(__isset_bitfield, __PRIORITY_ISSET_ID);
  }

  public void setPriorityIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PRIORITY_ISSET_ID, value);
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public Query setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  public int getLimit() {
    return this.limit;
  }

  public Query setLimit(int limit) {
    this.limit = limit;
    setLimitIsSet(true);
    return this;
  }

  public void unsetLimit() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LIMIT_ISSET_ID);
  }

  /** Returns true if field limit is set (has been assigned a value) and false otherwise */
  public boolean isSetLimit() {
    return EncodingUtils.testBit(__isset_bitfield, __LIMIT_ISSET_ID);
  }

  public void setLimitIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LIMIT_ISSET_ID, value);
  }

  public byte getOrderBy() {
    return this.orderBy;
  }

  public Query setOrderBy(byte orderBy) {
    this.orderBy = orderBy;
    setOrderByIsSet(true);
    return this;
  }

  public void unsetOrderBy() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ORDERBY_ISSET_ID);
  }

  /** Returns true if field orderBy is set (has been assigned a value) and false otherwise */
  public boolean isSetOrderBy() {
    return EncodingUtils.testBit(__isset_bitfield, __ORDERBY_ISSET_ID);
  }

  public void setOrderByIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ORDERBY_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetId();
      } else {
        setId((Long)value);
      }
      break;

    case GROUP:
      if (value == null) {
        unsetGroup();
      } else {
        setGroup((String)value);
      }
      break;

    case ACL:
      if (value == null) {
        unsetAcl();
      } else {
        setAcl((String)value);
      }
      break;

    case PRIORITY:
      if (value == null) {
        unsetPriority();
      } else {
        setPriority((Integer)value);
      }
      break;

    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((Long)value);
      }
      break;

    case LIMIT:
      if (value == null) {
        unsetLimit();
      } else {
        setLimit((Integer)value);
      }
      break;

    case ORDER_BY:
      if (value == null) {
        unsetOrderBy();
      } else {
        setOrderBy((Byte)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getId();

    case GROUP:
      return getGroup();

    case ACL:
      return getAcl();

    case PRIORITY:
      return getPriority();

    case TIMESTAMP:
      return getTimestamp();

    case LIMIT:
      return getLimit();

    case ORDER_BY:
      return getOrderBy();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetId();
    case GROUP:
      return isSetGroup();
    case ACL:
      return isSetAcl();
    case PRIORITY:
      return isSetPriority();
    case TIMESTAMP:
      return isSetTimestamp();
    case LIMIT:
      return isSetLimit();
    case ORDER_BY:
      return isSetOrderBy();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Query)
      return this.equals((Query)that);
    return false;
  }

  public boolean equals(Query that) {
    if (that == null)
      return false;

    boolean this_present_id = true && this.isSetId();
    boolean that_present_id = true && that.isSetId();
    if (this_present_id || that_present_id) {
      if (!(this_present_id && that_present_id))
        return false;
      if (this.id != that.id)
        return false;
    }

    boolean this_present_group = true && this.isSetGroup();
    boolean that_present_group = true && that.isSetGroup();
    if (this_present_group || that_present_group) {
      if (!(this_present_group && that_present_group))
        return false;
      if (!this.group.equals(that.group))
        return false;
    }

    boolean this_present_acl = true && this.isSetAcl();
    boolean that_present_acl = true && that.isSetAcl();
    if (this_present_acl || that_present_acl) {
      if (!(this_present_acl && that_present_acl))
        return false;
      if (!this.acl.equals(that.acl))
        return false;
    }

    boolean this_present_priority = true && this.isSetPriority();
    boolean that_present_priority = true && that.isSetPriority();
    if (this_present_priority || that_present_priority) {
      if (!(this_present_priority && that_present_priority))
        return false;
      if (this.priority != that.priority)
        return false;
    }

    boolean this_present_timestamp = true && this.isSetTimestamp();
    boolean that_present_timestamp = true && that.isSetTimestamp();
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_limit = true && this.isSetLimit();
    boolean that_present_limit = true && that.isSetLimit();
    if (this_present_limit || that_present_limit) {
      if (!(this_present_limit && that_present_limit))
        return false;
      if (this.limit != that.limit)
        return false;
    }

    boolean this_present_orderBy = true && this.isSetOrderBy();
    boolean that_present_orderBy = true && that.isSetOrderBy();
    if (this_present_orderBy || that_present_orderBy) {
      if (!(this_present_orderBy && that_present_orderBy))
        return false;
      if (this.orderBy != that.orderBy)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_id = true && (isSetId());
    list.add(present_id);
    if (present_id)
      list.add(id);

    boolean present_group = true && (isSetGroup());
    list.add(present_group);
    if (present_group)
      list.add(group);

    boolean present_acl = true && (isSetAcl());
    list.add(present_acl);
    if (present_acl)
      list.add(acl);

    boolean present_priority = true && (isSetPriority());
    list.add(present_priority);
    if (present_priority)
      list.add(priority);

    boolean present_timestamp = true && (isSetTimestamp());
    list.add(present_timestamp);
    if (present_timestamp)
      list.add(timestamp);

    boolean present_limit = true && (isSetLimit());
    list.add(present_limit);
    if (present_limit)
      list.add(limit);

    boolean present_orderBy = true && (isSetOrderBy());
    list.add(present_orderBy);
    if (present_orderBy)
      list.add(orderBy);

    return list.hashCode();
  }

  @Override
  public int compareTo(Query other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetId()).compareTo(other.isSetId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, other.id);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGroup()).compareTo(other.isSetGroup());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGroup()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.group, other.group);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAcl()).compareTo(other.isSetAcl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAcl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.acl, other.acl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPriority()).compareTo(other.isSetPriority());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPriority()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.priority, other.priority);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTimestamp()).compareTo(other.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, other.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLimit()).compareTo(other.isSetLimit());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLimit()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.limit, other.limit);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetOrderBy()).compareTo(other.isSetOrderBy());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetOrderBy()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.orderBy, other.orderBy);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Query(");
    boolean first = true;

    if (isSetId()) {
      sb.append("id:");
      sb.append(this.id);
      first = false;
    }
    if (isSetGroup()) {
      if (!first) sb.append(", ");
      sb.append("group:");
      if (this.group == null) {
        sb.append("null");
      } else {
        sb.append(this.group);
      }
      first = false;
    }
    if (isSetAcl()) {
      if (!first) sb.append(", ");
      sb.append("acl:");
      if (this.acl == null) {
        sb.append("null");
      } else {
        sb.append(this.acl);
      }
      first = false;
    }
    if (isSetPriority()) {
      if (!first) sb.append(", ");
      sb.append("priority:");
      sb.append(this.priority);
      first = false;
    }
    if (isSetTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("timestamp:");
      sb.append(this.timestamp);
      first = false;
    }
    if (isSetLimit()) {
      if (!first) sb.append(", ");
      sb.append("limit:");
      sb.append(this.limit);
      first = false;
    }
    if (isSetOrderBy()) {
      if (!first) sb.append(", ");
      sb.append("orderBy:");
      sb.append(this.orderBy);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class QueryStandardSchemeFactory implements SchemeFactory {
    public QueryStandardScheme getScheme() {
      return new QueryStandardScheme();
    }
  }

  private static class QueryStandardScheme extends StandardScheme<Query> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Query struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.id = iprot.readI64();
              struct.setIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // GROUP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.group = iprot.readString();
              struct.setGroupIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // ACL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.acl = iprot.readString();
              struct.setAclIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PRIORITY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.priority = iprot.readI32();
              struct.setPriorityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestamp = iprot.readI64();
              struct.setTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // LIMIT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.limit = iprot.readI32();
              struct.setLimitIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // ORDER_BY
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.orderBy = iprot.readByte();
              struct.setOrderByIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Query struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetId()) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeI64(struct.id);
        oprot.writeFieldEnd();
      }
      if (struct.group != null) {
        if (struct.isSetGroup()) {
          oprot.writeFieldBegin(GROUP_FIELD_DESC);
          oprot.writeString(struct.group);
          oprot.writeFieldEnd();
        }
      }
      if (struct.acl != null) {
        if (struct.isSetAcl()) {
          oprot.writeFieldBegin(ACL_FIELD_DESC);
          oprot.writeString(struct.acl);
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetPriority()) {
        oprot.writeFieldBegin(PRIORITY_FIELD_DESC);
        oprot.writeI32(struct.priority);
        oprot.writeFieldEnd();
      }
      if (struct.isSetTimestamp()) {
        oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
        oprot.writeI64(struct.timestamp);
        oprot.writeFieldEnd();
      }
      if (struct.isSetLimit()) {
        oprot.writeFieldBegin(LIMIT_FIELD_DESC);
        oprot.writeI32(struct.limit);
        oprot.writeFieldEnd();
      }
      if (struct.isSetOrderBy()) {
        oprot.writeFieldBegin(ORDER_BY_FIELD_DESC);
        oprot.writeByte(struct.orderBy);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class QueryTupleSchemeFactory implements SchemeFactory {
    public QueryTupleScheme getScheme() {
      return new QueryTupleScheme();
    }
  }

  private static class QueryTupleScheme extends TupleScheme<Query> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Query struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetId()) {
        optionals.set(0);
      }
      if (struct.isSetGroup()) {
        optionals.set(1);
      }
      if (struct.isSetAcl()) {
        optionals.set(2);
      }
      if (struct.isSetPriority()) {
        optionals.set(3);
      }
      if (struct.isSetTimestamp()) {
        optionals.set(4);
      }
      if (struct.isSetLimit()) {
        optionals.set(5);
      }
      if (struct.isSetOrderBy()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetId()) {
        oprot.writeI64(struct.id);
      }
      if (struct.isSetGroup()) {
        oprot.writeString(struct.group);
      }
      if (struct.isSetAcl()) {
        oprot.writeString(struct.acl);
      }
      if (struct.isSetPriority()) {
        oprot.writeI32(struct.priority);
      }
      if (struct.isSetTimestamp()) {
        oprot.writeI64(struct.timestamp);
      }
      if (struct.isSetLimit()) {
        oprot.writeI32(struct.limit);
      }
      if (struct.isSetOrderBy()) {
        oprot.writeByte(struct.orderBy);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Query struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.id = iprot.readI64();
        struct.setIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.group = iprot.readString();
        struct.setGroupIsSet(true);
      }
      if (incoming.get(2)) {
        struct.acl = iprot.readString();
        struct.setAclIsSet(true);
      }
      if (incoming.get(3)) {
        struct.priority = iprot.readI32();
        struct.setPriorityIsSet(true);
      }
      if (incoming.get(4)) {
        struct.timestamp = iprot.readI64();
        struct.setTimestampIsSet(true);
      }
      if (incoming.get(5)) {
        struct.limit = iprot.readI32();
        struct.setLimitIsSet(true);
      }
      if (incoming.get(6)) {
        struct.orderBy = iprot.readByte();
        struct.setOrderByIsSet(true);
      }
    }
  }

}
