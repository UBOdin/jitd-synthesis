package org.apache.spark.sql.execution;
/**
 * Parent class for different types of subquery plans
 */
public abstract class BaseSubqueryExec extends org.apache.spark.sql.execution.SparkPlan {
  public   BaseSubqueryExec ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.execution.SparkPlan child ()  ;
  public  void generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, java.lang.String prefix, boolean addSuffix, int maxFields, boolean printNodeId, int indent)  { throw new RuntimeException(); }
  public abstract  java.lang.String name ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
}
