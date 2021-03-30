package org.apache.spark.sql;
/**
 * Trait to restrict calls to create and replace operations.
 * <p>
 * @since 3.0.0
 */
public  interface CreateTableWriter<T extends java.lang.Object> extends org.apache.spark.sql.WriteConfigMethods<org.apache.spark.sql.CreateTableWriter<T>> {
  /**
   * Create a new table from the contents of the data frame.
   * <p>
   * The new table's schema, partition layout, properties, and other configuration will be
   * based on the configuration set on this writer.
   * <p>
   * If the output table exists, this operation will fail with
   * {@link org.apache.spark.sql.catalyst.analysis.TableAlreadyExistsException}.
   * <p>
   * @throws org.apache.spark.sql.catalyst.analysis.TableAlreadyExistsException
   *         If the table already exists
   */
  public  void create () throws org.apache.spark.sql.catalyst.analysis.TableAlreadyExistsException ;
  /**
   * Create a new table or replace an existing table with the contents of the data frame.
   * <p>
   * The output table's schema, partition layout, properties, and other configuration will be based
   * on the contents of the data frame and the configuration set on this writer. If the table
   * exists, its configuration and data will be replaced.
   */
  public  void createOrReplace ()  ;
  /**
   * Partition the output table created by <code>create</code>, <code>createOrReplace</code>, or <code>replace</code> using
   * the given columns or transforms.
   * <p>
   * When specified, the table data will be stored by these values for efficient reads.
   * <p>
   * For example, when a table is partitioned by day, it may be stored in a directory layout like:
   * <ul>
   * <li><code>table/day=2019-06-01/</code></li>
   * <li><code>table/day=2019-06-02/</code></li>
   * </ul>
   * <p>
   * Partitioning is one of the most widely used techniques to optimize physical data layout.
   * It provides a coarse-grained index for skipping unnecessary data reads when queries have
   * predicates on the partitioned columns. In order for partitioning to work well, the number
   * of distinct values in each column should typically be less than tens of thousands.
   * <p>
   * @since 3.0.0
   * @param column (undocumented)
   * @param columns (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.CreateTableWriter<T> partitionedBy (org.apache.spark.sql.Column column, scala.collection.Seq<org.apache.spark.sql.Column> columns)  ;
  /**
   * Replace an existing table with the contents of the data frame.
   * <p>
   * The existing table's schema, partition layout, properties, and other configuration will be
   * replaced with the contents of the data frame and the configuration set on this writer.
   * <p>
   * If the output table does not exist, this operation will fail with
   * {@link org.apache.spark.sql.catalyst.analysis.CannotReplaceMissingTableException}.
   * <p>
   * @throws org.apache.spark.sql.catalyst.analysis.CannotReplaceMissingTableException
   *         If the table does not exist
   */
  public  void replace () throws org.apache.spark.sql.catalyst.analysis.CannotReplaceMissingTableException ;
  /**
   * Add a table property.
   * @param property (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.CreateTableWriter<T> tableProperty (java.lang.String property, java.lang.String value)  ;
  /**
   * Specifies a provider for the underlying output data source. Spark's default catalog supports
   * "parquet", "json", etc.
   * <p>
   * @since 3.0.0
   * @param provider (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.CreateTableWriter<T> using (java.lang.String provider)  ;
}
