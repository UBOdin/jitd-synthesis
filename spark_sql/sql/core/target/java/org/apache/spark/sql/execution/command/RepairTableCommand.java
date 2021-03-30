package org.apache.spark.sql.execution.command;
/**
 * Repair a table by recovering all the partition in the directory of the table and
 * update the catalog.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *   ALTER TABLE table RECOVER PARTITIONS;
 *   MSCK REPAIR TABLE table [{ADD|DROP|SYNC} PARTITIONS];
 * </code></pre>
 */
public  class RepairTableCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  boolean enableAddPartitions ()  { throw new RuntimeException(); }
  public  boolean enableDropPartitions ()  { throw new RuntimeException(); }
  public  java.lang.String cmd ()  { throw new RuntimeException(); }
  // not preceding
  public   RepairTableCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, boolean enableAddPartitions, boolean enableDropPartitions, java.lang.String cmd)  { throw new RuntimeException(); }
  public  java.lang.String NUM_FILES ()  { throw new RuntimeException(); }
  public  java.lang.String TOTAL_SIZE ()  { throw new RuntimeException(); }
  public  java.lang.String DDL_TIME ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession spark)  { throw new RuntimeException(); }
}
