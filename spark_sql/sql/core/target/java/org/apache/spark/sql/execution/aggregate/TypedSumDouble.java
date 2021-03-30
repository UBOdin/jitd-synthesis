package org.apache.spark.sql.execution.aggregate;
public  class TypedSumDouble<IN extends java.lang.Object> extends org.apache.spark.sql.expressions.Aggregator<IN, java.lang.Object, java.lang.Object> {
  // not preceding
  public   TypedSumDouble (scala.Function1<IN, java.lang.Object> f)  { throw new RuntimeException(); }
  public   TypedSumDouble (org.apache.spark.api.java.function.MapFunction<IN, java.lang.Double> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<java.lang.Object> bufferEncoder ()  { throw new RuntimeException(); }
  public  scala.Function1<IN, java.lang.Object> f ()  { throw new RuntimeException(); }
  public  double finish (double reduction)  { throw new RuntimeException(); }
  public  double merge (double b1, double b2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<java.lang.Object> outputEncoder ()  { throw new RuntimeException(); }
  public  double reduce (double b, IN a)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.TypedColumn<IN, java.lang.Double> toColumnJava ()  { throw new RuntimeException(); }
  public  double zero ()  { throw new RuntimeException(); }
}
