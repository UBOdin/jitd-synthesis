package org.apache.spark.sql.execution.streaming.sources;
public  class ForeachBatchSink<T extends java.lang.Object> implements org.apache.spark.sql.execution.streaming.Sink {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   ForeachBatchSink (scala.Function2<org.apache.spark.sql.Dataset<T>, java.lang.Object, scala.runtime.BoxedUnit> batchWriter, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> encoder)  { throw new RuntimeException(); }
  public  void addBatch (long batchId, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
