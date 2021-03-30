package org.apache.spark.sql.execution.aggregate;
/**
 * The internal wrapper used to hook a {@link UserDefinedAggregateFunction} <code>udaf</code> in the
 * internal aggregation code path.
 */
public  class ScalaUDAF extends org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, org.apache.spark.internal.Logging, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.UserDefinedAggregateFunction udaf ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> udafName ()  { throw new RuntimeException(); }
  // not preceding
  public   ScalaUDAF (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, org.apache.spark.sql.expressions.UserDefinedAggregateFunction udaf, int mutableAggBufferOffset, int inputAggBufferOffset, scala.Option<java.lang.String> udafName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType aggBufferSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> inputAggBufferAttributes ()  { throw new RuntimeException(); }
  public  void initialize (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  public  void update (org.apache.spark.sql.catalyst.InternalRow buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  void merge (org.apache.spark.sql.catalyst.InternalRow buffer1, org.apache.spark.sql.catalyst.InternalRow buffer2)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
}
