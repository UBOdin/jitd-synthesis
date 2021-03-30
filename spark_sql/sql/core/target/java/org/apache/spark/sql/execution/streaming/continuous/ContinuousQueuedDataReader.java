package org.apache.spark.sql.execution.streaming.continuous;
/**
 * A wrapper for a continuous processing data reader, including a reading queue and epoch markers.
 * <p>
 * This will be instantiated once per partition - successive calls to compute() in the
 * {@link ContinuousDataSourceRDD} will reuse the same reader. This is required to get continuity of
 * offsets across epochs. Each compute() should call the next() method here until null is returned.
 */
public  class ContinuousQueuedDataReader implements java.io.Closeable {
  public  class EpochMarker {
    static public abstract  boolean canEqual (Object that)  ;
    static public abstract  boolean equals (Object that)  ;
    static public abstract  Object productElement (int n)  ;
    static public abstract  int productArity ()  ;
    static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
    static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  }
  public  class EpochMarker$ implements org.apache.spark.sql.execution.streaming.continuous.ContinuousQueuedDataReader.ContinuousRecord, scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final EpochMarker$ MODULE$ = null;
    public   EpochMarker$ ()  { throw new RuntimeException(); }
  }
  public  class ContinuousRow implements org.apache.spark.sql.execution.streaming.continuous.ContinuousQueuedDataReader.ContinuousRecord, scala.Product, scala.Serializable {
    static public abstract  R apply (T1 v1, T2 v2)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.InternalRow row ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.read.streaming.PartitionOffset offset ()  { throw new RuntimeException(); }
    // not preceding
    public   ContinuousRow (org.apache.spark.sql.catalyst.InternalRow row, org.apache.spark.sql.connector.read.streaming.PartitionOffset offset)  { throw new RuntimeException(); }
  }
  public  class ContinuousRow$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.connector.read.streaming.PartitionOffset, org.apache.spark.sql.execution.streaming.continuous.ContinuousQueuedDataReader.ContinuousRow> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ContinuousRow$ MODULE$ = null;
    public   ContinuousRow$ ()  { throw new RuntimeException(); }
  }
  /**
   * The record types in the read buffer.
   */
  public  interface ContinuousRecord {
  }
  /**
   * The data component of {@link ContinuousQueuedDataReader}. Pushes (row, offset) to the queue when
   * a new row arrives to the {@link ContinuousPartitionReader}.
   */
  public  class DataReaderThread extends java.lang.Thread implements org.apache.spark.internal.Logging {
    public   DataReaderThread (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
      java.lang.Throwable failureReason ()  { throw new RuntimeException(); }
    public  void run ()  { throw new RuntimeException(); }
  }
  /**
   * The epoch marker component of {@link ContinuousQueuedDataReader}. Populates the queue with
   * EpochMarker when a new epoch marker arrives.
   */
  public  class EpochMarkerGenerator implements java.lang.Runnable, org.apache.spark.internal.Logging {
    public   EpochMarkerGenerator ()  { throw new RuntimeException(); }
      java.lang.Throwable failureReason ()  { throw new RuntimeException(); }
    public  void run ()  { throw new RuntimeException(); }
  }
  public   ContinuousQueuedDataReader (int partitionIndex, org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReader<org.apache.spark.sql.catalyst.InternalRow> reader, org.apache.spark.sql.types.StructType schema, org.apache.spark.TaskContext context, int dataQueueSize, long epochPollIntervalMs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.continuous.ContinuousQueuedDataReader.EpochMarker$ EpochMarker ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  /**
   * Return the next row to be read in the current epoch, or null if the epoch is done.
   * <p>
   * After returning null, the {@link ContinuousDataSourceRDD} compute() for the following epoch
   * will call next() again to start getting rows.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow next ()  { throw new RuntimeException(); }
}
