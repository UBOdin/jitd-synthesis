package org.apache.spark.sql.execution;
/**
 * An append-only array for {@link UnsafeRow}s that strictly keeps content in an in-memory array
 * until {@link numRowsInMemoryBufferThreshold} is reached post which it will switch to a mode which
 * would flush to disk after {@link numRowsSpillThreshold} is met (or before if there is
 * excessive memory consumption). Setting these threshold involves following trade-offs:
 * <p>
 * - If {@link numRowsInMemoryBufferThreshold} is too high, the in-memory array may occupy more memory
 *   than is available, resulting in OOM.
 * - If {@link numRowsSpillThreshold} is too low, data will be spilled frequently and lead to
 *   excessive disk writes. This may lead to a performance regression compared to the normal case
 *   of using an {@link ArrayBuffer} or {@link Array}.
 */
  class ExternalAppendOnlyUnsafeRowArray implements org.apache.spark.internal.Logging {
  static public  int DefaultInitialSizeOfInMemoryBuffer ()  { throw new RuntimeException(); }
  public   ExternalAppendOnlyUnsafeRowArray (org.apache.spark.memory.TaskMemoryManager taskMemoryManager, org.apache.spark.storage.BlockManager blockManager, org.apache.spark.serializer.SerializerManager serializerManager, org.apache.spark.TaskContext taskContext, int initialSize, long pageSizeBytes, int numRowsInMemoryBufferThreshold, int numRowsSpillThreshold)  { throw new RuntimeException(); }
  public   ExternalAppendOnlyUnsafeRowArray (int numRowsInMemoryBufferThreshold, int numRowsSpillThreshold)  { throw new RuntimeException(); }
  public  int length ()  { throw new RuntimeException(); }
  public  boolean isEmpty ()  { throw new RuntimeException(); }
  /**
   * Clears up resources (e.g. memory) held by the backing storage
   */
  public  void clear ()  { throw new RuntimeException(); }
  public  void add (org.apache.spark.sql.catalyst.expressions.UnsafeRow unsafeRow)  { throw new RuntimeException(); }
  /**
   * Creates an {@link Iterator} for the current rows in the array starting from a user provided index
   * <p>
   * If there are subsequent {@link add()} or {@link clear()} calls made on this array after creation of
   * the iterator, then the iterator is invalidated thus saving clients from thinking that they
   * have read all the data while there were new rows added to this array.
   * @param startIndex (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> generateIterator (int startIndex)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> generateIterator ()  { throw new RuntimeException(); }
}
