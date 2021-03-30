package org.apache.spark.sql.execution.python;
/**
 * A RowQueue that has a list of RowQueues, which could be in memory or disk.
 * <p>
 * HybridRowQueue could be safely appended in one thread, and pulled in another thread in the same
 * time.
 */
  class HybridRowQueue extends org.apache.spark.memory.MemoryConsumer implements org.apache.spark.sql.execution.python.RowQueue, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.python.HybridRowQueue apply (org.apache.spark.memory.TaskMemoryManager taskMemoryMgr, java.io.File file, int fields)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.memory.TaskMemoryManager memManager ()  { throw new RuntimeException(); }
  public  java.io.File tempDir ()  { throw new RuntimeException(); }
  public  int numFields ()  { throw new RuntimeException(); }
  public  org.apache.spark.serializer.SerializerManager serMgr ()  { throw new RuntimeException(); }
  // not preceding
  public   HybridRowQueue (org.apache.spark.memory.TaskMemoryManager memManager, java.io.File tempDir, int numFields, org.apache.spark.serializer.SerializerManager serMgr)  { throw new RuntimeException(); }
    int numQueues ()  { throw new RuntimeException(); }
  public  long spill (long size, org.apache.spark.memory.MemoryConsumer trigger)  { throw new RuntimeException(); }
  public  boolean add (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow remove ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
}
