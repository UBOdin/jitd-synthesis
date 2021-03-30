package org.apache.spark.sql.execution;
/**
 * Iterates over a presorted set of rows, chunking it up by the grouping expression.  Each call to
 * next will return a pair containing the current group and an iterator that will return all the
 * elements of that group.  Iterators for each group are lazily constructed by extracting rows
 * from the input iterator.  As such, full groups are never materialized by this class.
 * <p>
 * Example input:
 * <pre><code>
 *   Input: [a, 1], [b, 2], [b, 3]
 *   Grouping: x#1
 *   InputSchema: x#1, y#2
 * </code></pre>
 * <p>
 * Result:
 * <pre><code>
 *   First call to next():  ([a], Iterator([a, 1])
 *   Second call to next(): ([b], Iterator([b, 2], [b, 3])
 * </code></pre>
 * <p>
 * Note, the class does not handle the case of an empty input for simplicity of implementation.
 * Use the factory to construct a new instance.
 * <p>
 * param:  input An iterator of rows.  This iterator must be ordered by the groupingExpressions or
 *              it is possible for the same group to appear more than once.
 * param:  groupingExpressions The set of expressions used to do grouping.  The result of evaluating
 *                            these expressions will be returned as the first part of each call
 *                            to <code>next()</code>.
 * param:  inputSchema The schema of the rows in the <code>input</code> iterator.
 */
public  class GroupedIterator implements scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> {
  static public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> apply (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> keyExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  /** Compares two input rows and returns 0 if they are in the same group. */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> sortOrder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.BaseOrdering keyOrdering ()  { throw new RuntimeException(); }
  /** Creates a row containing only the key for a given input row. */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeProjection keyProjection ()  { throw new RuntimeException(); }
  /**
   * Holds null or the row that will be returned on next call to <code>next()</code> in the inner iterator.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow currentRow ()  { throw new RuntimeException(); }
  /** Holds a copy of an input row that is in the current group. */
  public  org.apache.spark.sql.catalyst.InternalRow currentGroup ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> currentIterator ()  { throw new RuntimeException(); }
  /**
   * Return true if we already have the next iterator or fetching a new iterator is successful.
   * <p>
   * Note that, if we get the iterator by <code>next</code>, we should consume it before call <code>hasNext</code>,
   * because we will consume the input data to skip to next group while fetching a new iterator,
   * thus make the previous iterator empty.
   * @return (undocumented)
   */
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  scala.Tuple2<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>> next ()  { throw new RuntimeException(); }
}
