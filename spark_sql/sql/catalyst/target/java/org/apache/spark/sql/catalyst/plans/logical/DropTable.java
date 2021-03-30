package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the DROP TABLE command.
 * <p>
 * If the <code>PURGE</code> option is set, the table catalog must remove table data by skipping the trash
 * even when the catalog has configured one. The option is applicable only for managed tables.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *     DROP TABLE [IF EXISTS] table [PURGE];
 * </code></pre>
 */
public  class DropTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean purge ()  { throw new RuntimeException(); }
  // not preceding
  public   DropTable (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, boolean ifExists, boolean purge)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
