package org.apache.spark.sql.expressions;
/**
 * The base class for implementing user-defined aggregate functions (UDAF).
 * <p>
 * @since 1.5.0
 * @deprecated UserDefinedAggregateFunction is deprecated.
 * Aggregator[IN, BUF, OUT] should now be registered as a UDF via the functions.udaf(agg) method.
 *
 * @deprecated Aggregator[IN, BUF, OUT] should now be registered as a UDF via the functions.udaf(agg) method. Since 3.0.0. 
 */
public abstract class UserDefinedAggregateFunction implements scala.Serializable {
  // not preceding
  public   UserDefinedAggregateFunction ()  { throw new RuntimeException(); }
  /**
   * Creates a <code>Column</code> for this UDAF using given <code>Column</code>s as input arguments.
   * <p>
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column apply (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Creates a <code>Column</code> for this UDAF using given <code>Column</code>s as input arguments.
   * <p>
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column apply (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * A <code>StructType</code> represents data types of values in the aggregation buffer.
   * For example, if a {@link UserDefinedAggregateFunction}'s buffer has two values
   * (i.e. two intermediate values) with type of <code>DoubleType</code> and <code>LongType</code>,
   * the returned <code>StructType</code> will look like
   * <p>
   * <code></code><code>
   *   new StructType()
   *    .add("doubleInput", DoubleType)
   *    .add("longInput", LongType)
   * </code><code></code>
   * <p>
   * The name of a field of this <code>StructType</code> is only used to identify the corresponding
   * buffer value. Users can choose names to identify the input arguments.
   * <p>
   * @since 1.5.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.types.StructType bufferSchema ()  ;
  /**
   * The <code>DataType</code> of the returned value of this {@link UserDefinedAggregateFunction}.
   * <p>
   * @since 1.5.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.types.DataType dataType ()  ;
  /**
   * Returns true iff this function is deterministic, i.e. given the same input,
   * always return the same output.
   * <p>
   * @since 1.5.0
   * @return (undocumented)
   */
  public abstract  boolean deterministic ()  ;
  /**
   * Creates a <code>Column</code> for this UDAF using the distinct values of the given
   * <code>Column</code>s as input arguments.
   * <p>
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column distinct (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Creates a <code>Column</code> for this UDAF using the distinct values of the given
   * <code>Column</code>s as input arguments.
   * <p>
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column distinct (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Calculates the final result of this {@link UserDefinedAggregateFunction} based on the given
   * aggregation buffer.
   * <p>
   * @since 1.5.0
   * @param buffer (undocumented)
   * @return (undocumented)
   */
  public abstract  Object evaluate (org.apache.spark.sql.Row buffer)  ;
  /**
   * Initializes the given aggregation buffer, i.e. the zero value of the aggregation buffer.
   * <p>
   * The contract should be that applying the merge function on two initial buffers should just
   * return the initial buffer itself, i.e.
   * <code>merge(initialBuffer, initialBuffer)</code> should equal <code>initialBuffer</code>.
   * <p>
   * @since 1.5.0
   * @param buffer (undocumented)
   */
  public abstract  void initialize (org.apache.spark.sql.expressions.MutableAggregationBuffer buffer)  ;
  /**
   * A <code>StructType</code> represents data types of input arguments of this aggregate function.
   * For example, if a {@link UserDefinedAggregateFunction} expects two input arguments
   * with type of <code>DoubleType</code> and <code>LongType</code>, the returned <code>StructType</code> will look like
   * <p>
   * <code></code><code>
   *   new StructType()
   *    .add("doubleInput", DoubleType)
   *    .add("longInput", LongType)
   * </code><code></code>
   * <p>
   * The name of a field of this <code>StructType</code> is only used to identify the corresponding
   * input argument. Users can choose names to identify the input arguments.
   * <p>
   * @since 1.5.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.types.StructType inputSchema ()  ;
  /**
   * Merges two aggregation buffers and stores the updated buffer values back to <code>buffer1</code>.
   * <p>
   * This is called when we merge two partially aggregated data together.
   * <p>
   * @since 1.5.0
   * @param buffer1 (undocumented)
   * @param buffer2 (undocumented)
   */
  public abstract  void merge (org.apache.spark.sql.expressions.MutableAggregationBuffer buffer1, org.apache.spark.sql.Row buffer2)  ;
  /**
   * Updates the given aggregation buffer <code>buffer</code> with new input data from <code>input</code>.
   * <p>
   * This is called once per input row.
   * <p>
   * @since 1.5.0
   * @param buffer (undocumented)
   * @param input (undocumented)
   */
  public abstract  void update (org.apache.spark.sql.expressions.MutableAggregationBuffer buffer, org.apache.spark.sql.Row input)  ;
}
