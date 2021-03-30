package org.apache.spark.sql.util;
public  class ArrowUtils {
  static public  org.apache.arrow.memory.RootAllocator rootAllocator ()  { throw new RuntimeException(); }
  /** Maps data type from Spark to Arrow. NOTE: timeZoneId required for TimestampTypes */
  static public  org.apache.arrow.vector.types.pojo.ArrowType toArrowType (org.apache.spark.sql.types.DataType dt, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DataType fromArrowType (org.apache.arrow.vector.types.pojo.ArrowType dt)  { throw new RuntimeException(); }
  /** Maps field from Spark to Arrow. NOTE: timeZoneId required for TimestampType */
  static public  org.apache.arrow.vector.types.pojo.Field toArrowField (java.lang.String name, org.apache.spark.sql.types.DataType dt, boolean nullable, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DataType fromArrowField (org.apache.arrow.vector.types.pojo.Field field)  { throw new RuntimeException(); }
  /** Maps schema from Spark to Arrow. NOTE: timeZoneId required for TimestampType in StructType */
  static public  org.apache.arrow.vector.types.pojo.Schema toArrowSchema (org.apache.spark.sql.types.StructType schema, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType fromArrowSchema (org.apache.arrow.vector.types.pojo.Schema schema)  { throw new RuntimeException(); }
  /** Return Map with conf settings to be used in ArrowPythonRunner */
  static public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getPythonRunnerConfMap (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
}
