package org.apache.spark.sql.execution.aggregate;
public  class TypedAverage<IN extends java.lang.Object> extends org.apache.spark.sql.expressions.Aggregator<IN, scala.Tuple2<java.lang.Object, java.lang.Object>, java.lang.Object> {
  // not preceding
  public   TypedAverage (scala.Function1<IN, java.lang.Object> f)  { throw new RuntimeException(); }
  public   TypedAverage (org.apache.spark.api.java.function.MapFunction<IN, java.lang.Double> f)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<scala.Tuple2<java.lang.Object, java.lang.Object>> bufferEncoder ()  { throw new RuntimeException(); }
  public  scala.Function1<IN, java.lang.Object> f ()  { throw new RuntimeException(); }
  public  double finish (scala.Tuple2<java.lang.Object, java.lang.Object> reduction)  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, java.lang.Object> merge (scala.Tuple2<java.lang.Object, java.lang.Object> b1, scala.Tuple2<java.lang.Object, java.lang.Object> b2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<java.lang.Object> outputEncoder ()  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, java.lang.Object> reduce (scala.Tuple2<java.lang.Object, java.lang.Object> b, IN a)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.TypedColumn<IN, java.lang.Double> toColumnJava ()  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, java.lang.Object> zero ()  { throw new RuntimeException(); }
}
