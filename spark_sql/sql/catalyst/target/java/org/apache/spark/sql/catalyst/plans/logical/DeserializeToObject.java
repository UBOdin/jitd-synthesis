package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Takes the input row from child and turns it into object using the given deserializer expression.
 */
public  class DeserializeToObject extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements org.apache.spark.sql.catalyst.plans.logical.ObjectProducer, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   DeserializeToObject (org.apache.spark.sql.catalyst.expressions.Expression deserializer, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
}
