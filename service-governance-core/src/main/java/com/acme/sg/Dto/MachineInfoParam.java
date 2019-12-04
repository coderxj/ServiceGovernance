/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.acme.sg.Dto;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-12-01")
public class MachineInfoParam implements org.apache.thrift.TBase<MachineInfoParam, MachineInfoParam._Fields>, java.io.Serializable, Cloneable, Comparable<MachineInfoParam> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MachineInfoParam");

  private static final org.apache.thrift.protocol.TField APP_KEY_FIELD_DESC = new org.apache.thrift.protocol.TField("appKey", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField IP_FIELD_DESC = new org.apache.thrift.protocol.TField("ip", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("port", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MachineInfoParamStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MachineInfoParamTupleSchemeFactory();

  public java.lang.String appKey; // required
  public java.lang.String ip; // required
  public int port; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    APP_KEY((short)1, "appKey"),
    IP((short)2, "ip"),
    PORT((short)3, "port");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // APP_KEY
          return APP_KEY;
        case 2: // IP
          return IP;
        case 3: // PORT
          return PORT;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __PORT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.APP_KEY, new org.apache.thrift.meta_data.FieldMetaData("appKey", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IP, new org.apache.thrift.meta_data.FieldMetaData("ip", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PORT, new org.apache.thrift.meta_data.FieldMetaData("port", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MachineInfoParam.class, metaDataMap);
  }

  public MachineInfoParam() {
  }

  public MachineInfoParam(
    java.lang.String appKey,
    java.lang.String ip,
    int port)
  {
    this();
    this.appKey = appKey;
    this.ip = ip;
    this.port = port;
    setPortIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MachineInfoParam(MachineInfoParam other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetAppKey()) {
      this.appKey = other.appKey;
    }
    if (other.isSetIp()) {
      this.ip = other.ip;
    }
    this.port = other.port;
  }

  public MachineInfoParam deepCopy() {
    return new MachineInfoParam(this);
  }

  @Override
  public void clear() {
    this.appKey = null;
    this.ip = null;
    setPortIsSet(false);
    this.port = 0;
  }

  public java.lang.String getAppKey() {
    return this.appKey;
  }

  public MachineInfoParam setAppKey(java.lang.String appKey) {
    this.appKey = appKey;
    return this;
  }

  public void unsetAppKey() {
    this.appKey = null;
  }

  /** Returns true if field appKey is set (has been assigned a value) and false otherwise */
  public boolean isSetAppKey() {
    return this.appKey != null;
  }

  public void setAppKeyIsSet(boolean value) {
    if (!value) {
      this.appKey = null;
    }
  }

  public java.lang.String getIp() {
    return this.ip;
  }

  public MachineInfoParam setIp(java.lang.String ip) {
    this.ip = ip;
    return this;
  }

  public void unsetIp() {
    this.ip = null;
  }

  /** Returns true if field ip is set (has been assigned a value) and false otherwise */
  public boolean isSetIp() {
    return this.ip != null;
  }

  public void setIpIsSet(boolean value) {
    if (!value) {
      this.ip = null;
    }
  }

  public int getPort() {
    return this.port;
  }

  public MachineInfoParam setPort(int port) {
    this.port = port;
    setPortIsSet(true);
    return this;
  }

  public void unsetPort() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  /** Returns true if field port is set (has been assigned a value) and false otherwise */
  public boolean isSetPort() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __PORT_ISSET_ID);
  }

  public void setPortIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __PORT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case APP_KEY:
      if (value == null) {
        unsetAppKey();
      } else {
        setAppKey((java.lang.String)value);
      }
      break;

    case IP:
      if (value == null) {
        unsetIp();
      } else {
        setIp((java.lang.String)value);
      }
      break;

    case PORT:
      if (value == null) {
        unsetPort();
      } else {
        setPort((java.lang.Integer)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case APP_KEY:
      return getAppKey();

    case IP:
      return getIp();

    case PORT:
      return getPort();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case APP_KEY:
      return isSetAppKey();
    case IP:
      return isSetIp();
    case PORT:
      return isSetPort();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof MachineInfoParam)
      return this.equals((MachineInfoParam)that);
    return false;
  }

  public boolean equals(MachineInfoParam that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_appKey = true && this.isSetAppKey();
    boolean that_present_appKey = true && that.isSetAppKey();
    if (this_present_appKey || that_present_appKey) {
      if (!(this_present_appKey && that_present_appKey))
        return false;
      if (!this.appKey.equals(that.appKey))
        return false;
    }

    boolean this_present_ip = true && this.isSetIp();
    boolean that_present_ip = true && that.isSetIp();
    if (this_present_ip || that_present_ip) {
      if (!(this_present_ip && that_present_ip))
        return false;
      if (!this.ip.equals(that.ip))
        return false;
    }

    boolean this_present_port = true;
    boolean that_present_port = true;
    if (this_present_port || that_present_port) {
      if (!(this_present_port && that_present_port))
        return false;
      if (this.port != that.port)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetAppKey()) ? 131071 : 524287);
    if (isSetAppKey())
      hashCode = hashCode * 8191 + appKey.hashCode();

    hashCode = hashCode * 8191 + ((isSetIp()) ? 131071 : 524287);
    if (isSetIp())
      hashCode = hashCode * 8191 + ip.hashCode();

    hashCode = hashCode * 8191 + port;

    return hashCode;
  }

  @Override
  public int compareTo(MachineInfoParam other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetAppKey()).compareTo(other.isSetAppKey());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppKey()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appKey, other.appKey);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIp()).compareTo(other.isSetIp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ip, other.ip);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPort()).compareTo(other.isSetPort());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPort()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.port, other.port);
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
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("MachineInfoParam(");
    boolean first = true;

    sb.append("appKey:");
    if (this.appKey == null) {
      sb.append("null");
    } else {
      sb.append(this.appKey);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ip:");
    if (this.ip == null) {
      sb.append("null");
    } else {
      sb.append(this.ip);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("port:");
    sb.append(this.port);
    first = false;
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MachineInfoParamStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MachineInfoParamStandardScheme getScheme() {
      return new MachineInfoParamStandardScheme();
    }
  }

  private static class MachineInfoParamStandardScheme extends org.apache.thrift.scheme.StandardScheme<MachineInfoParam> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MachineInfoParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // APP_KEY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appKey = iprot.readString();
              struct.setAppKeyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // IP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ip = iprot.readString();
              struct.setIpIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.port = iprot.readI32();
              struct.setPortIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, MachineInfoParam struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.appKey != null) {
        oprot.writeFieldBegin(APP_KEY_FIELD_DESC);
        oprot.writeString(struct.appKey);
        oprot.writeFieldEnd();
      }
      if (struct.ip != null) {
        oprot.writeFieldBegin(IP_FIELD_DESC);
        oprot.writeString(struct.ip);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(PORT_FIELD_DESC);
      oprot.writeI32(struct.port);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MachineInfoParamTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MachineInfoParamTupleScheme getScheme() {
      return new MachineInfoParamTupleScheme();
    }
  }

  private static class MachineInfoParamTupleScheme extends org.apache.thrift.scheme.TupleScheme<MachineInfoParam> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MachineInfoParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetAppKey()) {
        optionals.set(0);
      }
      if (struct.isSetIp()) {
        optionals.set(1);
      }
      if (struct.isSetPort()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetAppKey()) {
        oprot.writeString(struct.appKey);
      }
      if (struct.isSetIp()) {
        oprot.writeString(struct.ip);
      }
      if (struct.isSetPort()) {
        oprot.writeI32(struct.port);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MachineInfoParam struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.appKey = iprot.readString();
        struct.setAppKeyIsSet(true);
      }
      if (incoming.get(1)) {
        struct.ip = iprot.readString();
        struct.setIpIsSet(true);
      }
      if (incoming.get(2)) {
        struct.port = iprot.readI32();
        struct.setPortIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

