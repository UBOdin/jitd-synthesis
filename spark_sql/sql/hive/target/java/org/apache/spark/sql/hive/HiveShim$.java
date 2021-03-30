package org.apache.spark.sql.hive;
public  class HiveShim$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveShim$ MODULE$ = null;
  public   HiveShim$ ()  { throw new RuntimeException(); }
  public  int UNLIMITED_DECIMAL_PRECISION ()  { throw new RuntimeException(); }
  public  int UNLIMITED_DECIMAL_SCALE ()  { throw new RuntimeException(); }
  public  java.lang.String HIVE_GENERIC_UDF_MACRO_CLS ()  { throw new RuntimeException(); }
  public  void appendReadColumns (org.apache.hadoop.conf.Configuration conf, scala.collection.Seq<java.lang.Integer> ids, scala.collection.Seq<java.lang.String> names)  { throw new RuntimeException(); }
  public  org.apache.hadoop.io.Writable prepareWritable (org.apache.hadoop.io.Writable w, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> serDeProps)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal toCatalystDecimal (org.apache.hadoop.hive.serde2.objectinspector.primitive.HiveDecimalObjectInspector hdoi, Object data)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.plan.FileSinkDesc wrapperToFileSinkDesc (org.apache.spark.sql.hive.HiveShim.ShimFileSinkDesc w)  { throw new RuntimeException(); }
}
