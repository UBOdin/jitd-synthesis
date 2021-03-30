package org.apache.spark.sql.catalyst.plans.logical;
public  class MapPartitionsInR extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements org.apache.spark.sql.catalyst.plans.logical.ObjectConsumer, org.apache.spark.sql.catalyst.plans.logical.ObjectProducer, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<org.apache.spark.sql.Row> encoder, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  byte[] func ()  { throw new RuntimeException(); }
  public  byte[] packageNames ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType inputSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType outputSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   MapPartitionsInR (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType inputSchema, org.apache.spark.sql.types.StructType outputSchema, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
}
