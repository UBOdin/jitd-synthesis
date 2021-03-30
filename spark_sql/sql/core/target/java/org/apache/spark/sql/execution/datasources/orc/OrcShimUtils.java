package org.apache.spark.sql.execution.datasources.orc;
/**
 * Various utilities for ORC used to upgrade the built-in Hive.
 */
public  class OrcShimUtils {
  static public  class VectorizedRowBatchWrap {
    // not preceding
    public   VectorizedRowBatchWrap (org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch batch)  { throw new RuntimeException(); }
    public  org.apache.hadoop.hive.ql.exec.vector.VectorizedRowBatch batch ()  { throw new RuntimeException(); }
  }
  static public  int getGregorianDays (Object value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal getDecimal (Object value)  { throw new RuntimeException(); }
  static public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, org.apache.hadoop.hive.serde2.io.DateWritable> getDateWritable (boolean reuseObj)  { throw new RuntimeException(); }
  static public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, org.apache.hadoop.hive.serde2.io.HiveDecimalWritable> getHiveDecimalWritable (int precision, int scale)  { throw new RuntimeException(); }
}
