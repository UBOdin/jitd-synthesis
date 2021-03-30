package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A base interface for {@link RepartitionByExpression} and {@link Repartition}
 */
public abstract class RepartitionOperation extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode {
  public   RepartitionOperation ()  { throw new RuntimeException(); }
  public final  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  public abstract  int numPartitions ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public abstract  boolean shuffle ()  ;
}
