package org.apache.spark.sql.expressions;
/**
 * An aggregator that uses a single associative and commutative reduce function. This reduce
 * function can be used to go through all input values and reduces them to a single value.
 * If there is no input, a null value is returned.
 * <p>
 * This class currently assumes there is at least one input row.
 */
  class ReduceAggregator<T extends java.lang.Object> extends org.apache.spark.sql.expressions.Aggregator<T, scala.Tuple2<java.lang.Object, T>, T> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   ReduceAggregator (scala.Function2<T, T, T> func, org.apache.spark.sql.Encoder<T> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<scala.Tuple2<java.lang.Object, T>> bufferEncoder ()  { throw new RuntimeException(); }
  public  T finish (scala.Tuple2<java.lang.Object, T> reduction)  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, T> merge (scala.Tuple2<java.lang.Object, T> b1, scala.Tuple2<java.lang.Object, T> b2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<T> outputEncoder ()  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, T> reduce (scala.Tuple2<java.lang.Object, T> b, T a)  { throw new RuntimeException(); }
  public  scala.Tuple2<java.lang.Object, T> zero ()  { throw new RuntimeException(); }
}
