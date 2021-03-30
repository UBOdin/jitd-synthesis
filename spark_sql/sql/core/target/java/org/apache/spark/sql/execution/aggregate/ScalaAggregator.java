package org.apache.spark.sql.execution.aggregate;
public  class ScalaAggregator<IN extends java.lang.Object, BUF extends java.lang.Object, OUT extends java.lang.Object> extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<BUF> implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.Aggregator<IN, BUF, OUT> agg ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<IN> inputEncoder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<BUF> bufferEncoder ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  boolean isDeterministic ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> aggregatorName ()  { throw new RuntimeException(); }
  // not preceding
  public   ScalaAggregator (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, org.apache.spark.sql.expressions.Aggregator<IN, BUF, OUT> agg, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<IN> inputEncoder, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<BUF> bufferEncoder, boolean nullable, boolean isDeterministic, int mutableAggBufferOffset, int inputAggBufferOffset, scala.Option<java.lang.String> aggregatorName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.aggregate.ScalaAggregator<IN, BUF, OUT> withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.aggregate.ScalaAggregator<IN, BUF, OUT> withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  BUF createAggregationBuffer ()  { throw new RuntimeException(); }
  public  BUF update (BUF buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  BUF merge (BUF buffer, BUF input)  { throw new RuntimeException(); }
  public  Object eval (BUF buffer)  { throw new RuntimeException(); }
  public  byte[] serialize (BUF agg)  { throw new RuntimeException(); }
  public  BUF deserialize (byte[] storageFormat)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
}
