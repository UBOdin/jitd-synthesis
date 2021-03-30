package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan for no-op command handling non-existing table.
 */
public  class NoopCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String commandName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> multipartIdentifier ()  { throw new RuntimeException(); }
  // not preceding
  public   NoopCommand (java.lang.String commandName, scala.collection.Seq<java.lang.String> multipartIdentifier)  { throw new RuntimeException(); }
}
