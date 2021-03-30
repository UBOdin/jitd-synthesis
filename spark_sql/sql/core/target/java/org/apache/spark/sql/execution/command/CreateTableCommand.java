package org.apache.spark.sql.execution.command;
/**
 * A command to create a table.
 * <p>
 * Note: This is currently used only for creating Hive tables.
 * This is not intended for temporary tables.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   CREATE [EXTERNAL] TABLE [IF NOT EXISTS] [db_name.]table_name
 *   [(col1 data_type [COMMENT col_comment], ...)]
 *   [COMMENT table_comment]
 *   [PARTITIONED BY (col3 data_type [COMMENT col_comment], ...)]
 *   [CLUSTERED BY (col1, ...) [SORTED BY (col1 [ASC|DESC], ...)] INTO num_buckets BUCKETS]
 *   [SKEWED BY (col1, col2, ...) ON ((col_value, col_value, ...), ...)
 *   [STORED AS DIRECTORIES]
 *   [ROW FORMAT row_format]
 *   [STORED AS file_format | STORED BY storage_handler_class [WITH SERDEPROPERTIES (...)}
 *   [LOCATION path]
 *   [TBLPROPERTIES (property_name=property_value, ...)]
 *   [AS select_statement];
 * </code></pre>
 */
public  class CreateTableCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable table ()  { throw new RuntimeException(); }
  public  boolean ignoreIfExists ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateTableCommand (org.apache.spark.sql.catalyst.catalog.CatalogTable table, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
