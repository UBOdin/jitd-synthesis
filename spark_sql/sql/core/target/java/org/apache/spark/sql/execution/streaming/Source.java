package org.apache.spark.sql.execution.streaming;
/**
 * A source of continually arriving data for a streaming query. A {@link Source} must have a
 * monotonically increasing notion of progress that can be represented as an {@link Offset}. Spark
 * will regularly query each {@link Source} to see if any more data is available.
 * <p>
 * Note that, we extends <code>SparkDataStream</code> here, to make the v1 streaming source API be compatible
 * with data source v2.
 */
public  interface Source extends org.apache.spark.sql.connector.read.streaming.SparkDataStream {
  /**
   * Informs the source that Spark has completed processing all data for offsets less than or
   * equal to <code>end</code> and will only request offsets greater than <code>end</code> in the future.
   * @param end (undocumented)
   */
  public  void commit (org.apache.spark.sql.execution.streaming.Offset end)  ;
  public  void commit (org.apache.spark.sql.connector.read.streaming.Offset end)  ;
  public  org.apache.spark.sql.connector.read.streaming.Offset deserializeOffset (java.lang.String json)  ;
  /**
   * Returns the data that is between the offsets (<code>start</code>, <code>end</code>]. When <code>start</code> is <code>None</code>,
   * then the batch should begin with the first record. This method must always return the
   * same data for a particular <code>start</code> and <code>end</code> pair; even after the Source has been restarted
   * on a different node.
   * <p>
   * Higher layers will always call this method with a value of <code>start</code> greater than or equal
   * to the last value passed to <code>commit</code> and a value of <code>end</code> less than or equal to the
   * last value returned by <code>getOffset</code>
   * <p>
   * It is possible for the {@link Offset} type to be a {@link SerializedOffset} when it was
   * obtained from the log. Moreover, {@link StreamExecution} only compares the {@link Offset}
   * JSON representation to determine if the two objects are equal. This could have
   * ramifications when upgrading {@link Offset} JSON formats i.e., two equivalent {@link Offset}
   * objects could differ between version. Consequently, {@link StreamExecution} may call
   * this method with two such equivalent {@link Offset} objects. In which case, the {@link Source}
   * should return an empty {@link DataFrame}
   * @param start (undocumented)
   * @param end (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> getBatch (scala.Option<org.apache.spark.sql.execution.streaming.Offset> start, org.apache.spark.sql.execution.streaming.Offset end)  ;
  /**
   * Returns the maximum available offset for this source.
   * Returns <code>None</code> if this source has never received any data.
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.execution.streaming.Offset> getOffset ()  ;
  public  org.apache.spark.sql.connector.read.streaming.Offset initialOffset ()  ;
  /** Returns the schema of the data from this source */
  public  org.apache.spark.sql.types.StructType schema ()  ;
}
