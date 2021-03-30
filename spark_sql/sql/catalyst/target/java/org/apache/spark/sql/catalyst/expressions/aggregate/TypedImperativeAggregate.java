package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * Aggregation function which allows **arbitrary** user-defined java object to be used as internal
 * aggregation buffer.
 * <p>
 * <pre><code>
 *  aggregation buffer for normal aggregation function `avg`            aggregate buffer for `sum`
 *            |                                                                  |
 *            v                                                                  v
 *          +--------------+---------------+-----------------------------------+-------------+
 *          |  sum1 (Long) | count1 (Long) | generic user-defined java objects | sum2 (Long) |
 *          +--------------+---------------+-----------------------------------+-------------+
 *                                           ^
 *                                           |
 *            aggregation buffer object for `TypedImperativeAggregate` aggregation function
 * </code></pre>
 * <p>
 * General work flow:
 * <p>
 * Stage 1: initialize aggregate buffer object.
 * <p>
 *   1. The framework calls <code>initialize(buffer: MutableRow)</code> to set up the empty aggregate buffer.
 *   2. In <code>initialize</code>, we call <code>createAggregationBuffer(): T</code> to get the initial buffer object,
 *      and set it to the global buffer row.
 * <p>
 * Stage 2: process input rows.
 * <p>
 *   If the aggregate mode is <code>Partial</code> or <code>Complete</code>:
 *     1. The framework calls <code>update(buffer: MutableRow, input: InternalRow)</code> to process the input
 *        row.
 *     2. In <code>update</code>, we get the buffer object from the global buffer row and call
 *        <code>update(buffer: T, input: InternalRow): Unit</code>.
 * <p>
 *   If the aggregate mode is <code>PartialMerge</code> or <code>Final</code>:
 *     1. The framework call <code>merge(buffer: MutableRow, inputBuffer: InternalRow)</code> to process the
 *        input row, which are serialized buffer objects shuffled from other nodes.
 *     2. In <code>merge</code>, we get the buffer object from the global buffer row, and get the binary data
 *        from input row and deserialize it to buffer object, then we call
 *        <code>merge(buffer: T, input: T): Unit</code> to merge these 2 buffer objects.
 * <p>
 * Stage 3: output results.
 * <p>
 *   If the aggregate mode is <code>Partial</code> or <code>PartialMerge</code>:
 *     1. The framework calls <code>serializeAggregateBufferInPlace</code> to replace the buffer object in the
 *        global buffer row with binary data.
 *     2. In <code>serializeAggregateBufferInPlace</code>, we get the buffer object from the global buffer row
 *        and call <code>serialize(buffer: T): Array[Byte]</code> to serialize the buffer object to binary.
 *     3. The framework outputs buffer attributes and shuffle them to other nodes.
 * <p>
 *   If the aggregate mode is <code>Final</code> or <code>Complete</code>:
 *     1. The framework calls <code>eval(buffer: InternalRow)</code> to calculate the final result.
 *     2. In <code>eval</code>, we get the buffer object from the global buffer row and call
 *        <code>eval(buffer: T): Any</code> to get the final result.
 *     3. The framework outputs these final results.
 * <p>
 * Window function work flow:
 *   The framework calls <code>update(buffer: MutableRow, input: InternalRow)</code> several times and then
 *   call <code>eval(buffer: InternalRow)</code>, so there is no need for window operator to call
 *   <code>serializeAggregateBufferInPlace</code>.
 * <p>
 * NOTE: SQL with TypedImperativeAggregate functions is planned in sort based aggregation,
 * instead of hash based aggregation, as TypedImperativeAggregate use BinaryType as aggregation
 * buffer's storage format, which is not supported by hash based aggregation. Hash based
 * aggregation only support aggregation buffer of mutable types (like LongType, IntType that have
 * fixed length and can be mutated in place in UnsafeRow).
 * NOTE: The newly added ObjectHashAggregateExec supports TypedImperativeAggregate functions in
 * hash based aggregation under some constraints.
 */
public abstract class TypedImperativeAggregate<T extends java.lang.Object> extends org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   TypedImperativeAggregate ()  { throw new RuntimeException(); }
  // not preceding
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public final  org.apache.spark.sql.types.StructType aggBufferSchema ()  { throw new RuntimeException(); }
  /**
   * Creates an empty aggregation buffer object. This is called before processing each key group
   * (group by key).
   * <p>
   * @return an aggregation buffer object
   */
  public abstract  T createAggregationBuffer ()  ;
  /** De-serializes the serialized format Array[Byte], and produces aggregation buffer object T */
  public abstract  T deserialize (byte[] storageFormat)  ;
  /**
   * Generates the final aggregation result value for current key group with the aggregation buffer
   * object.
   * <p>
   * Developer note: the only return types accepted by Spark are:
   *   - primitive types
   *   - InternalRow and subclasses
   *   - ArrayData
   *   - MapData
   * <p>
   * @param buffer aggregation buffer object.
   * @return The aggregation result of current key group
   */
  public abstract  Object eval (T buffer)  ;
  public final  Object eval (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  public final  void initialize (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  // not preceding
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> inputAggBufferAttributes ()  { throw new RuntimeException(); }
  /**
   * Merges an input aggregation object into aggregation buffer object and returns a new buffer
   * object. For performance, the function may do in-place merge and return it instead of
   * constructing new buffer object.
   * <p>
   * This is typically called when doing PartialMerge or Final mode aggregation.
   * <p>
   * @param buffer the aggregation buffer object used to store the aggregation result.
   * @param input an input aggregation object. Input aggregation object can be produced by
   *              de-serializing the partial aggregate's output from Mapper side.
   * @return (undocumented)
   */
  public abstract  T merge (T buffer, T input)  ;
  public final  void merge (org.apache.spark.sql.catalyst.InternalRow buffer, org.apache.spark.sql.catalyst.InternalRow inputBuffer)  { throw new RuntimeException(); }
  /**
   * Merge an input buffer into the aggregation buffer, where both buffers contain the deserialized
   * java object. This function is used by aggregating accumulators.
   * <p>
   * @param buffer the aggregation buffer that is updated.
   * @param inputBuffer the buffer that is merged into the aggregation buffer.
   */
  public final  void mergeBuffersObjects (org.apache.spark.sql.catalyst.InternalRow buffer, org.apache.spark.sql.catalyst.InternalRow inputBuffer)  { throw new RuntimeException(); }
  /** Serializes the aggregation buffer object T to Array[Byte] */
  public abstract  byte[] serialize (T buffer)  ;
  /**
   * In-place replaces the aggregation buffer object stored at buffer's index
   * <code>mutableAggBufferOffset</code>, with SparkSQL internally supported underlying storage format
   * (BinaryType).
   * <p>
   * This is only called when doing Partial or PartialMerge mode aggregation, before the framework
   * shuffle out aggregate buffers.
   * @param buffer (undocumented)
   */
  public final  void serializeAggregateBufferInPlace (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  /**
   * Updates the aggregation buffer object with an input row and returns a new buffer object. For
   * performance, the function may do in-place update and return it instead of constructing new
   * buffer object.
   * <p>
   * This is typically called when doing Partial or Complete mode aggregation.
   * <p>
   * @param buffer The aggregation buffer object.
   * @param input an input row
   * @return (undocumented)
   */
  public abstract  T update (T buffer, org.apache.spark.sql.catalyst.InternalRow input)  ;
  public final  void update (org.apache.spark.sql.catalyst.InternalRow buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
}
