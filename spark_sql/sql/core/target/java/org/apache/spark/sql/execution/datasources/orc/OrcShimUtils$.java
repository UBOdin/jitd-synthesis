package org.apache.spark.sql.execution.datasources.orc;
/**
 * Various utilities for ORC used to upgrade the built-in Hive.
 */
public  class OrcShimUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OrcShimUtils$ MODULE$ = null;
  public   OrcShimUtils$ ()  { throw new RuntimeException(); }
  public  int getGregorianDays (Object value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal getDecimal (Object value)  { throw new RuntimeException(); }
  public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, org.apache.hadoop.hive.serde2.io.DateWritable> getDateWritable (boolean reuseObj)  { throw new RuntimeException(); }
  public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, org.apache.hadoop.hive.serde2.io.HiveDecimalWritable> getHiveDecimalWritable (int precision, int scale)  { throw new RuntimeException(); }
}
