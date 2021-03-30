package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Collect arbitrary (named) metrics from a dataset. As soon as the query reaches a completion
 * point (batch query completes or streaming query epoch completes) an event is emitted on the
 * driver which can be observed by attaching a listener to the spark session. The metrics are named
 * so we can collect metrics at multiple places in a single dataset.
 * <p>
 * This node behaves like a global aggregate. All the metrics collected must be aggregate functions
 * or be literals.
 */
public  class CollectMetrics extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   CollectMetrics (java.lang.String name, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> metrics, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
