package org.apache.spark.sql;
/**
 * Interface used to write a {@link org.apache.spark.sql.Dataset} to external storage using the v2 API.
 * <p>
 * @since 3.0.0
 */
public final class DataFrameWriterV2<T extends java.lang.Object> implements org.apache.spark.sql.CreateTableWriter<T> {
  // not preceding
     DataFrameWriterV2 (java.lang.String table, org.apache.spark.sql.Dataset<T> ds)  { throw new RuntimeException(); }
  /**
   * Append the contents of the data frame to the output table.
   * <p>
   * If the output table does not exist, this operation will fail with
   * {@link org.apache.spark.sql.catalyst.analysis.NoSuchTableException}. The data frame will be
   * validated to ensure it is compatible with the existing table.
   * <p>
   * @throws org.apache.spark.sql.catalyst.analysis.NoSuchTableException If the table does not exist
   */
  public  void append () throws org.apache.spark.sql.catalyst.analysis.NoSuchTableException { throw new RuntimeException(); }
  public  void create ()  { throw new RuntimeException(); }
  public  void createOrReplace ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.DataFrameWriterV2<T> option (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.DataFrameWriterV2<T> options (scala.collection.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.DataFrameWriterV2<T> options (java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Overwrite rows matching the given filter condition with the contents of the data frame in
   * the output table.
   * <p>
   * If the output table does not exist, this operation will fail with
   * {@link org.apache.spark.sql.catalyst.analysis.NoSuchTableException}.
   * The data frame will be validated to ensure it is compatible with the existing table.
   * <p>
   * @throws org.apache.spark.sql.catalyst.analysis.NoSuchTableException If the table does not exist
   * @param condition (undocumented)
   */
  public  void overwrite (org.apache.spark.sql.Column condition) throws org.apache.spark.sql.catalyst.analysis.NoSuchTableException { throw new RuntimeException(); }
  /**
   * Overwrite all partition for which the data frame contains at least one row with the contents
   * of the data frame in the output table.
   * <p>
   * This operation is equivalent to Hive's <code>INSERT OVERWRITE ... PARTITION</code>, which replaces
   * partitions dynamically depending on the contents of the data frame.
   * <p>
   * If the output table does not exist, this operation will fail with
   * {@link org.apache.spark.sql.catalyst.analysis.NoSuchTableException}. The data frame will be
   * validated to ensure it is compatible with the existing table.
   * <p>
   * @throws org.apache.spark.sql.catalyst.analysis.NoSuchTableException If the table does not exist
   */
  public  void overwritePartitions () throws org.apache.spark.sql.catalyst.analysis.NoSuchTableException { throw new RuntimeException(); }
  public  org.apache.spark.sql.CreateTableWriter<T> partitionedBy (org.apache.spark.sql.Column column, org.apache.spark.sql.Column... columns)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.CreateTableWriter<T> partitionedBy (org.apache.spark.sql.Column column, scala.collection.Seq<org.apache.spark.sql.Column> columns)  { throw new RuntimeException(); }
  public  void replace ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.CreateTableWriter<T> tableProperty (java.lang.String property, java.lang.String value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.CreateTableWriter<T> using (java.lang.String provider)  { throw new RuntimeException(); }
}
