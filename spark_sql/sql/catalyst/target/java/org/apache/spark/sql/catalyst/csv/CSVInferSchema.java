package org.apache.spark.sql.catalyst.csv;
public  class CSVInferSchema implements scala.Serializable {
  // not preceding
  public   CSVInferSchema (org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Similar to the JSON schema inference
   *     1. Infer type of each row
   *     2. Merge row types to find common type
   *     3. Replace any null types with string type
   * @param tokenRDD (undocumented)
   * @param header (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType infer (org.apache.spark.rdd.RDD<java.lang.String[]> tokenRDD, java.lang.String[] header)  { throw new RuntimeException(); }
  /**
   * Infer type of string field. Given known type Double, and a string "1", there is no
   * point checking if it is an Int, as the final type must be Double or higher.
   * @param typeSoFar (undocumented)
   * @param field (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType inferField (org.apache.spark.sql.types.DataType typeSoFar, java.lang.String field)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType[] inferRowType (org.apache.spark.sql.types.DataType[] rowSoFar, java.lang.String[] next)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType[] mergeRowTypes (org.apache.spark.sql.types.DataType[] first, org.apache.spark.sql.types.DataType[] second)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.csv.CSVOptions options ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructField[] toStructFields (org.apache.spark.sql.types.DataType[] fieldTypes, java.lang.String[] header)  { throw new RuntimeException(); }
}
