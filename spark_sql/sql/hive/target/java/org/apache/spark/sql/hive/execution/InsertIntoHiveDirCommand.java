package org.apache.spark.sql.hive.execution;
/**
 * Command for writing the results of <code>query</code> to file system.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   INSERT OVERWRITE [LOCAL] DIRECTORY
 *   path
 *   [ROW FORMAT row_format]
 *   [STORED AS file_format]
 *   SELECT ...
 * </code></pre>
 * <p>
 * param:  isLocal whether the path specified in <code>storage</code> is a local directory
 * param:  storage storage format used to describe how the query result is stored.
 * param:  query the logical plan representing data to write to
 * param:  overwrite whether overwrites existing directory
 */
public  class InsertIntoHiveDirCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.hive.execution.SaveAsHiveFile, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.hadoop.fs.Path> createdTempDir ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  boolean isLocal ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  boolean overwrite ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoHiveDirCommand (boolean isLocal, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, boolean overwrite, scala.collection.Seq<java.lang.String> outputColumnNames)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
}
