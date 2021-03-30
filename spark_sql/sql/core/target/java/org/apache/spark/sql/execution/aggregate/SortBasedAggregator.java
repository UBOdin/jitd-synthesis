package org.apache.spark.sql.execution.aggregate;
/**
 * A class used to handle sort-based aggregation, used together with {@link ObjectHashAggregateExec}.
 * <p>
 * param:  initialAggBufferIterator iterator that points to sorted input aggregation buffers
 * param:  inputSchema  The schema of input row
 * param:  groupingSchema The schema of grouping key
 * param:  processRow  Function to update the aggregation buffer with input rows
 * param:  mergeAggregationBuffers Function used to merge the input aggregation buffers into existing
 *                                aggregation buffers
 * param:  makeEmptyAggregationBuffer Creates an empty aggregation buffer
 * <p>
 * @todo Try to eliminate this class by refactor and reuse code paths in {@link SortAggregateExec}.
 */
public  class SortBasedAggregator {
  public   SortBasedAggregator (org.apache.spark.unsafe.KVIterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> initialAggBufferIterator, org.apache.spark.sql.types.StructType inputSchema, org.apache.spark.sql.types.StructType groupingSchema, scala.Function2<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow, scala.runtime.BoxedUnit> processRow, scala.Function2<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow, scala.runtime.BoxedUnit> mergeAggregationBuffers, scala.Function0<org.apache.spark.sql.catalyst.InternalRow> makeEmptyAggregationBuffer)  { throw new RuntimeException(); }
  public  void addInput (org.apache.spark.sql.catalyst.expressions.UnsafeRow groupingKey, org.apache.spark.sql.catalyst.expressions.UnsafeRow inputRow)  { throw new RuntimeException(); }
  /**
   * Returns a destructive iterator of AggregationBufferEntry.
   * Notice: it is illegal to call any method after <code>destructiveIterator()</code> has been called.
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.aggregate.AggregationBufferEntry> destructiveIterator ()  { throw new RuntimeException(); }
}
