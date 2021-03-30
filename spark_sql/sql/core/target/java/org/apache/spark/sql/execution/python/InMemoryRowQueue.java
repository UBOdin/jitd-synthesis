package org.apache.spark.sql.execution.python;
/**
 * A RowQueue that is based on in-memory page. UnsafeRows are appended into it until it's full.
 * Another thread could read from it at the same time (behind the writer).
 * <p>
 * The format of UnsafeRow in page:
 * [4 bytes to hold length of record (N)] [N bytes to hold record] [...]
 * <p>
 * -1 length means end of page.
 */
 abstract class InMemoryRowQueue implements org.apache.spark.sql.execution.python.RowQueue {
  // not preceding
  public   InMemoryRowQueue (org.apache.spark.unsafe.memory.MemoryBlock page, int numFields)  { throw new RuntimeException(); }
  public  boolean add (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.memory.MemoryBlock page ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow remove ()  { throw new RuntimeException(); }
}
