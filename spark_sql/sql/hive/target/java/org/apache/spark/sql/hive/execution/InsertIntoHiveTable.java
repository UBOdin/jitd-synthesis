package org.apache.spark.sql.hive.execution;
/**
 * Command for writing data out to a Hive table.
 * <p>
 * This class is mostly a mess, for legacy reasons (since it evolved in organic ways and had to
 * follow Hive's internal implementations closely, which itself was a mess too). Please don't
 * blame Reynold for this! He was just moving code around!
 * <p>
 * In the future we should converge the write path for Hive with the normal data source write path,
 * as defined in <code>org.apache.spark.sql.execution.datasources.FileFormatWriter</code>.
 * <p>
 * param:  table the metadata of the table.
 * param:  partition a map from the partition key to the partition value (optional). If the partition
 *                  value is optional, dynamic partition insert will be performed.
 *                  As an example, <code>INSERT INTO tbl PARTITION (a=1, b=2) AS ...</code> would have
 * <p>
 *                  <pre><code>
 *                  Map('a' -&gt; Some('1'), 'b' -&gt; Some('2'))
 *                  </code></pre>
 * <p>
 *                  and <code>INSERT INTO tbl PARTITION (a=1, b) AS ...</code>
 *                  would have
 * <p>
 *                  <pre><code>
 *                  Map('a' -&gt; Some('1'), 'b' -&gt; None)
 *                  </code></pre>.
 * param:  query the logical plan representing data to write to.
 * param:  overwrite overwrite existing table or partitions.
 * param:  ifPartitionNotExists If true, only write if the partition does not exist.
 *                                   Only valid for static partitions.
 */
public  class InsertIntoHiveTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.hive.execution.SaveAsHiveFile, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.hadoop.fs.Path> createdTempDir ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable table ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> partition ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  boolean overwrite ()  { throw new RuntimeException(); }
  public  boolean ifPartitionNotExists ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoHiveTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> partition, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, boolean overwrite, boolean ifPartitionNotExists, scala.collection.Seq<java.lang.String> outputColumnNames)  { throw new RuntimeException(); }
  /**
   * Inserts all the rows in the table into Hive.  Row objects are properly serialized with the
   * <code>org.apache.hadoop.hive.serde2.SerDe</code> and the
   * <code>org.apache.hadoop.mapred.OutputFormat</code> provided by the table definition.
   * @param sparkSession (undocumented)
   * @param child (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
}
