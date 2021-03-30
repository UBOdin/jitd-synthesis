package org.apache.spark.sql.execution.columnar;
/**
 * An Iterator to walk through the InternalRows from a CachedBatch
 */
public abstract class ColumnarIterator implements scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> {
  public   ColumnarIterator ()  { throw new RuntimeException(); }
  public abstract  void initialize (scala.collection.Iterator<org.apache.spark.sql.execution.columnar.DefaultCachedBatch> input, org.apache.spark.sql.types.DataType[] columnTypes, int[] columnIndexes)  ;
}
