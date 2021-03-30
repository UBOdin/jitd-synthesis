package org.apache.spark.sql.catalyst.json;
public  class JsonInferSchema$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JsonInferSchema$ MODULE$ = null;
  public   JsonInferSchema$ ()  { throw new RuntimeException(); }
  public  java.lang.Object structFieldComparator ()  { throw new RuntimeException(); }
  public  boolean isSorted (org.apache.spark.sql.types.StructField[] arr)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType withCorruptField (org.apache.spark.sql.types.StructType struct, org.apache.spark.sql.types.DataType other, java.lang.String columnNameOfCorruptRecords, org.apache.spark.sql.catalyst.util.ParseMode parseMode)  { throw new RuntimeException(); }
  /**
   * Remove top-level ArrayType wrappers and merge the remaining schemas
   * @param columnNameOfCorruptRecords (undocumented)
   * @param parseMode (undocumented)
   * @return (undocumented)
   */
  public  scala.Function2<org.apache.spark.sql.types.DataType, org.apache.spark.sql.types.DataType, org.apache.spark.sql.types.DataType> compatibleRootType (java.lang.String columnNameOfCorruptRecords, org.apache.spark.sql.catalyst.util.ParseMode parseMode)  { throw new RuntimeException(); }
  /**
   * Returns the most general data type for two given data types.
   * @param t1 (undocumented)
   * @param t2 (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType compatibleType (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
}
