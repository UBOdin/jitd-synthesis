package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Similar with <code>MapPartitionsInR</code> but serializes and deserializes input/output in
 * Arrow format.
 * <p>
 * This is somewhat similar with <code>org.apache.spark.sql.execution.python.ArrowEvalPython</code>
 */
public  class MapPartitionsInRWithArrow extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  byte[] func ()  { throw new RuntimeException(); }
  public  byte[] packageNames ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType inputSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   MapPartitionsInRWithArrow (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType inputSchema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
}
