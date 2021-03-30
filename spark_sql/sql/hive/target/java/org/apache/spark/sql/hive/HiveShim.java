package org.apache.spark.sql.hive;
public  class HiveShim {
  /**
   * This class provides the UDF creation and also the UDF instance serialization and
   * de-serialization cross process boundary.
   * <p>
   * Detail discussion can be found at https://github.com/apache/spark/pull/3640
   * <p>
   * param:  functionClassName UDF class name
   * param:  instance optional UDF instance which contains additional information (for macro)
   * param:  clazz optional class instance to create UDF instance
   */
  static   class HiveFunctionWrapper implements java.io.Externalizable, scala.Product, scala.Serializable {
    // not preceding
    public  java.lang.String functionClassName ()  { throw new RuntimeException(); }
    // not preceding
    public   HiveFunctionWrapper (java.lang.String functionClassName, java.lang.Object instance, java.lang.Class<?> clazz)  { throw new RuntimeException(); }
    public   HiveFunctionWrapper ()  { throw new RuntimeException(); }
    public  int hashCode ()  { throw new RuntimeException(); }
    public  boolean equals (Object other)  { throw new RuntimeException(); }
    public <UDFType extends java.lang.Object> UDFType deserializePlan (java.io.InputStream is, java.lang.Class<?> clazz)  { throw new RuntimeException(); }
    public  void serializePlan (java.lang.Object function, java.io.OutputStream out)  { throw new RuntimeException(); }
    public  void writeExternal (java.io.ObjectOutput out)  { throw new RuntimeException(); }
    public  void readExternal (java.io.ObjectInput in)  { throw new RuntimeException(); }
    public <UDFType extends java.lang.Object> UDFType createFunction ()  { throw new RuntimeException(); }
  }
  static public  class HiveFunctionWrapper$ extends scala.runtime.AbstractFunction3<java.lang.String, java.lang.Object, java.lang.Class<?>, org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final HiveFunctionWrapper$ MODULE$ = null;
    public   HiveFunctionWrapper$ ()  { throw new RuntimeException(); }
  }
  static   class ShimFileSinkDesc implements scala.Serializable, org.apache.spark.internal.Logging {
    // not preceding
    public   ShimFileSinkDesc (java.lang.String dir, org.apache.hadoop.hive.ql.plan.TableDesc tableInfo, boolean compressed)  { throw new RuntimeException(); }
    public  java.lang.String compressCodec ()  { throw new RuntimeException(); }
    public  java.lang.String compressType ()  { throw new RuntimeException(); }
    public  boolean compressed ()  { throw new RuntimeException(); }
    public  int destTableId ()  { throw new RuntimeException(); }
    public  java.lang.String dir ()  { throw new RuntimeException(); }
    public  java.lang.String getDirName ()  { throw new RuntimeException(); }
    public  void setCompressCodec (java.lang.String intermediateCompressorCodec)  { throw new RuntimeException(); }
    public  void setCompressType (java.lang.String intermediateCompressType)  { throw new RuntimeException(); }
    public  void setCompressed (boolean compressed)  { throw new RuntimeException(); }
    public  void setDestTableId (int destTableId)  { throw new RuntimeException(); }
    public  void setTableInfo (org.apache.hadoop.hive.ql.plan.TableDesc tableInfo)  { throw new RuntimeException(); }
    public  org.apache.hadoop.hive.ql.plan.TableDesc tableInfo ()  { throw new RuntimeException(); }
  }
  static public  int UNLIMITED_DECIMAL_PRECISION ()  { throw new RuntimeException(); }
  static public  int UNLIMITED_DECIMAL_SCALE ()  { throw new RuntimeException(); }
  static public  java.lang.String HIVE_GENERIC_UDF_MACRO_CLS ()  { throw new RuntimeException(); }
  static public  void appendReadColumns (org.apache.hadoop.conf.Configuration conf, scala.collection.Seq<java.lang.Integer> ids, scala.collection.Seq<java.lang.String> names)  { throw new RuntimeException(); }
  static public  org.apache.hadoop.io.Writable prepareWritable (org.apache.hadoop.io.Writable w, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> serDeProps)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal toCatalystDecimal (org.apache.hadoop.hive.serde2.objectinspector.primitive.HiveDecimalObjectInspector hdoi, Object data)  { throw new RuntimeException(); }
  static public  org.apache.hadoop.hive.ql.plan.FileSinkDesc wrapperToFileSinkDesc (org.apache.spark.sql.hive.HiveShim.ShimFileSinkDesc w)  { throw new RuntimeException(); }
}
