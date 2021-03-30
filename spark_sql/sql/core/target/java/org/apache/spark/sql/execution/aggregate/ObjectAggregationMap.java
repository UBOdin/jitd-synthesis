package org.apache.spark.sql.execution.aggregate;
/**
 * An aggregation map that supports using safe <code>SpecificInternalRow</code>s aggregation buffers, so that
 * we can support storing arbitrary Java objects as aggregate function states in the aggregation
 * buffers. This class is only used together with {@link ObjectHashAggregateExec}.
 */
public  class ObjectAggregationMap {
  public   ObjectAggregationMap ()  { throw new RuntimeException(); }
  public  void clear ()  { throw new RuntimeException(); }
  /**
   * Dumps all entries into a newly created external sorter, clears the hash map, and returns the
   * external sorter.
   * @param groupingAttributes (undocumented)
   * @param aggregateFunctions (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.UnsafeKVExternalSorter dumpToExternalSorter (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction> aggregateFunctions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getAggregationBuffer (org.apache.spark.sql.catalyst.expressions.UnsafeRow groupingKey)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.execution.aggregate.AggregationBufferEntry> iterator ()  { throw new RuntimeException(); }
  public  void putAggregationBuffer (org.apache.spark.sql.catalyst.expressions.UnsafeRow groupingKey, org.apache.spark.sql.catalyst.InternalRow aggBuffer)  { throw new RuntimeException(); }
  public  int size ()  { throw new RuntimeException(); }
}
