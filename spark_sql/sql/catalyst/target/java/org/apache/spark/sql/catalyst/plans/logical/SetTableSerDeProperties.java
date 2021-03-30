package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ALTER TABLE ... SET [SERDE|SERDEPROPERTIES] command.
 */
public  class SetTableSerDeProperties extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> serdeClassName ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> serdeProperties ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partitionSpec ()  { throw new RuntimeException(); }
  // not preceding
  public   SetTableSerDeProperties (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, scala.Option<java.lang.String> serdeClassName, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> serdeProperties, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partitionSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
