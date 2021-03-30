package org.apache.spark.sql.execution;
/**
 * Iterates over {@link GroupedIterator}s and returns the cogrouped data, i.e. each record is a
 * grouping key with its associated values from all {@link GroupedIterator}s.
 * Note: we assume the output of each {@link GroupedIterator} is ordered by the grouping key.
 */
public  class CoGroupedIterator implements scala.collection.Iterator<scala.Tuple3<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> {
  public   CoGroupedIterator (scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> left, scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> right, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingSchema)  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  scala.Tuple3<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> next ()  { throw new RuntimeException(); }
}
