package org.apache.spark.sql.execution.command;
/**
 * A command to create a table with the same definition of the given existing table.
 * In the target table definition, the table comment is always empty but the column comments
 * are identical to the ones defined in the source table.
 * <p>
 * The CatalogTable attributes copied from the source table are storage(inputFormat, outputFormat,
 * serde, compressed, properties), schema, provider, partitionColumnNames, bucketSpec by default.
 * <p>
 * Use "CREATE TABLE t1 LIKE t2 USING file_format" to specify new provider for t1.
 * For Hive compatibility, use "CREATE TABLE t1 LIKE t2 STORED AS hiveFormat"
 * to specify new file storage format (inputFormat, outputFormat, serde) for t1.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   CREATE TABLE [IF NOT EXISTS] [db_name.]table_name
 *   LIKE [other_db_name.]existing_table_name
 *   [USING provider |
 *    [
 *     [ROW FORMAT row_format]
 *     [STORED AS file_format] [WITH SERDEPROPERTIES (...)]
 *    ]
 *   ]
 *   [locationSpec]
 *   [TBLPROPERTIES (property_name=property_value, ...)]
 * </code></pre>
 */
public  class CreateTableLikeCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier targetTable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier sourceTable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat fileFormat ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> provider ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  boolean ifNotExists ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateTableLikeCommand (org.apache.spark.sql.catalyst.TableIdentifier targetTable, org.apache.spark.sql.catalyst.TableIdentifier sourceTable, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat fileFormat, scala.Option<java.lang.String> provider, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, boolean ifNotExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
