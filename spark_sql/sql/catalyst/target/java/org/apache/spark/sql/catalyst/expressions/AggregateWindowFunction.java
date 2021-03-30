package org.apache.spark.sql.catalyst.expressions;
public abstract class AggregateWindowFunction extends org.apache.spark.sql.catalyst.expressions.aggregate.DeclarativeAggregate implements org.apache.spark.sql.catalyst.expressions.WindowFunction {
  public   AggregateWindowFunction ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.WindowFrame frame ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.runtime.Nothing$ mergeExpressions ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
}
