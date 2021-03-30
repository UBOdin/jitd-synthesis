package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * Collect a list of elements.
 */
public  class CollectList extends org.apache.spark.sql.catalyst.expressions.aggregate.Collect<scala.collection.mutable.ArrayBuffer<java.lang.Object>> implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   CollectList (org.apache.spark.sql.catalyst.expressions.Expression child, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public   CollectList (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType bufferElementType ()  { throw new RuntimeException(); }
  public  Object convertToBufferElement (Object value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  scala.collection.mutable.ArrayBuffer<java.lang.Object> createAggregationBuffer ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  Object eval (scala.collection.mutable.ArrayBuffer<java.lang.Object> buffer)  { throw new RuntimeException(); }
}
