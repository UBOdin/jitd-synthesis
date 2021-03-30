package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * API for aggregation functions that are expressed in terms of imperative initialize(), update(),
 * and merge() functions which operate on Row-based aggregation buffers.
 * <p>
 * Within these functions, code should access fields of the mutable aggregation buffer by adding the
 * bufferSchema-relative field number to <code>mutableAggBufferOffset</code> then using this new field number
 * to access the buffer Row. This is necessary because this aggregation function's buffer is
 * embedded inside of a larger shared aggregation buffer when an aggregation operator evaluates
 * multiple aggregate functions at the same time.
 * <p>
 * We need to perform similar field number arithmetic when merging multiple intermediate
 * aggregate buffers together in <code>merge()</code> (in this case, use <code>inputAggBufferOffset</code> when accessing
 * the input buffer).
 * <p>
 * Correct ImperativeAggregate evaluation depends on the correctness of <code>mutableAggBufferOffset</code> and
 * <code>inputAggBufferOffset</code>, but not on the correctness of the attribute ids in <code>aggBufferAttributes</code>
 * and <code>inputAggBufferAttributes</code>.
 */
public abstract class ImperativeAggregate extends org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction implements org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback {
  public   ImperativeAggregate ()  { throw new RuntimeException(); }
  /**
   * Initializes the mutable aggregation buffer located in <code>mutableAggBuffer</code>.
   * <p>
   * Use <code>fieldNumber + mutableAggBufferOffset</code> to access fields of <code>mutableAggBuffer</code>.
   * @param mutableAggBuffer (undocumented)
   */
  public abstract  void initialize (org.apache.spark.sql.catalyst.InternalRow mutableAggBuffer)  ;
  /**
   * The offset of this function's start buffer value in the underlying shared input aggregation
   * buffer. An input aggregation buffer is used when we merge two aggregation buffers together in
   * the <code>update()</code> function and is immutable (we merge an input aggregation buffer and a mutable
   * aggregation buffer and then store the new buffer values to the mutable aggregation buffer).
   * <p>
   * An input aggregation buffer may contain extra fields, such as grouping keys, at its start, so
   * mutableAggBufferOffset and inputAggBufferOffset are often different.
   * <p>
   * For example, say we have a grouping expression, <code>key</code>, and two aggregate functions,
   * <code>avg(x)</code> and <code>avg(y)</code>. In the shared input aggregation buffer, the position of the first
   * buffer value of <code>avg(x)</code> will be 1 and the position of the first buffer value of <code>avg(y)</code>
   * will be 3 (position 0 is used for the value of <code>key</code>):
   * <pre><code>
   *          avg(x) inputAggBufferOffset = 1
   *                   |
   *                   v
   *          +--------+--------+--------+--------+--------+
   *          |  key   |  sum1  | count1 |  sum2  | count2 |
   *          +--------+--------+--------+--------+--------+
   *                                     ^
   *                                     |
   *                       avg(y) inputAggBufferOffset = 3
   * </code></pre>
   * @return (undocumented)
   */
  protected abstract  int inputAggBufferOffset ()  ;
  /**
   * Combines new intermediate results from the <code>inputAggBuffer</code> with the existing intermediate
   * results in the <code>mutableAggBuffer.</code>
   * <p>
   * Use <code>fieldNumber + mutableAggBufferOffset</code> to access fields of <code>mutableAggBuffer</code>.
   * Use <code>fieldNumber + inputAggBufferOffset</code> to access fields of <code>inputAggBuffer</code>.
   * <p>
   * Note that, the input row may be produced by unsafe projection and it may not be safe to cache
   * some fields of the input row, as the values can be changed unexpectedly.
   * @param mutableAggBuffer (undocumented)
   * @param inputAggBuffer (undocumented)
   */
  public abstract  void merge (org.apache.spark.sql.catalyst.InternalRow mutableAggBuffer, org.apache.spark.sql.catalyst.InternalRow inputAggBuffer)  ;
  /**
   * The offset of this function's first buffer value in the underlying shared mutable aggregation
   * buffer.
   * <p>
   * For example, we have two aggregate functions <code>avg(x)</code> and <code>avg(y)</code>, which share the same
   * aggregation buffer. In this shared buffer, the position of the first buffer value of <code>avg(x)</code>
   * will be 0 and the position of the first buffer value of <code>avg(y)</code> will be 2:
   * <pre><code>
   *          avg(x) mutableAggBufferOffset = 0
   *                  |
   *                  v
   *                  +--------+--------+--------+--------+
   *                  |  sum1  | count1 |  sum2  | count2 |
   *                  +--------+--------+--------+--------+
   *                                    ^
   *                                    |
   *                     avg(y) mutableAggBufferOffset = 2
   * </code></pre>
   * @return (undocumented)
   */
  protected abstract  int mutableAggBufferOffset ()  ;
  /**
   * Updates its aggregation buffer, located in <code>mutableAggBuffer</code>, based on the given <code>inputRow</code>.
   * <p>
   * Use <code>fieldNumber + mutableAggBufferOffset</code> to access fields of <code>mutableAggBuffer</code>.
   * <p>
   * Note that, the input row may be produced by unsafe projection and it may not be safe to cache
   * some fields of the input row, as the values can be changed unexpectedly.
   * @param mutableAggBuffer (undocumented)
   * @param inputRow (undocumented)
   */
  public abstract  void update (org.apache.spark.sql.catalyst.InternalRow mutableAggBuffer, org.apache.spark.sql.catalyst.InternalRow inputRow)  ;
  /**
   * Returns a copy of this ImperativeAggregate with an updated mutableAggBufferOffset.
   * This new copy's attributes may have different ids than the original.
   * @param newInputAggBufferOffset (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  ;
  /**
   * Returns a copy of this ImperativeAggregate with an updated mutableAggBufferOffset.
   * This new copy's attributes may have different ids than the original.
   * @param newMutableAggBufferOffset (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  ;
}
