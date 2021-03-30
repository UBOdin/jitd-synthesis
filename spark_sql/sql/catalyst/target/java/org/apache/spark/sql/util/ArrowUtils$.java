package org.apache.spark.sql.util;
public  class ArrowUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ArrowUtils$ MODULE$ = null;
  public   ArrowUtils$ ()  { throw new RuntimeException(); }
  public  org.apache.arrow.memory.RootAllocator rootAllocator ()  { throw new RuntimeException(); }
  /** Maps data type from Spark to Arrow. NOTE: timeZoneId required for TimestampTypes */
  public  org.apache.arrow.vector.types.pojo.ArrowType toArrowType (org.apache.spark.sql.types.DataType dt, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType fromArrowType (org.apache.arrow.vector.types.pojo.ArrowType dt)  { throw new RuntimeException(); }
  /** Maps field from Spark to Arrow. NOTE: timeZoneId required for TimestampType */
  public  org.apache.arrow.vector.types.pojo.Field toArrowField (java.lang.String name, org.apache.spark.sql.types.DataType dt, boolean nullable, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType fromArrowField (org.apache.arrow.vector.types.pojo.Field field)  { throw new RuntimeException(); }
  /** Maps schema from Spark to Arrow. NOTE: timeZoneId required for TimestampType in StructType */
  public  org.apache.arrow.vector.types.pojo.Schema toArrowSchema (org.apache.spark.sql.types.StructType schema, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType fromArrowSchema (org.apache.arrow.vector.types.pojo.Schema schema)  { throw new RuntimeException(); }
  /** Return Map with conf settings to be used in ArrowPythonRunner */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getPythonRunnerConfMap (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
}
