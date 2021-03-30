package org.apache.spark.sql.catalyst.plans.logical;
/**
 * An INSERT INTO statement, as parsed from SQL.
 * <p>
 * param:  table                the logical plan representing the table.
 * param:  userSpecifiedCols    the user specified list of columns that belong to the table.
 * param:  query                the logical plan representing data to write to.
 * param:  overwrite            overwrite existing table or partitions.
 * param:  partitionSpec        a map from the partition key to the partition value (optional).
 *                             If the value is missing, dynamic partition insert will be performed.
 *                             As an example, <code>INSERT INTO tbl PARTITION (a=1, b=2) AS</code> would have
 *                             Map('a' -> Some('1'), 'b' -> Some('2')),
 *                             and <code>INSERT INTO tbl PARTITION (a=1, b) AS ...</code>
 *                             would have Map('a' -> Some('1'), 'b' -> None).
 * param:  ifPartitionNotExists If true, only write if the partition does not exist.
 *                             Only valid for static partitions.
 */
public  class InsertIntoStatement extends org.apache.spark.sql.catalyst.plans.logical.ParsedStatement implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> partitionSpec ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> userSpecifiedCols ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  boolean overwrite ()  { throw new RuntimeException(); }
  public  boolean ifPartitionNotExists ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoStatement (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> partitionSpec, scala.collection.Seq<java.lang.String> userSpecifiedCols, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, boolean overwrite, boolean ifPartitionNotExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
