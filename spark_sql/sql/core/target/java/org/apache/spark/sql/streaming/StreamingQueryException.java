package org.apache.spark.sql.streaming;
/**
 * Exception that stopped a {@link StreamingQuery}. Use <code>cause</code> get the actual exception
 * that caused the failure.
 * param:  message     Message of this exception
 * param:  cause       Internal cause of this exception
 * param:  startOffset Starting offset in json of the range of data in which exception occurred
 * param:  endOffset   Ending offset in json of the range of data in exception occurred
 * @since 2.0.0
 */
public  class StreamingQueryException extends java.lang.Exception {
  // not preceding
     StreamingQueryException (java.lang.String queryDebugString, java.lang.String message, java.lang.Throwable cause, java.lang.String startOffset, java.lang.String endOffset)  { throw new RuntimeException(); }
  public  java.lang.Throwable cause ()  { throw new RuntimeException(); }
  public  java.lang.String endOffset ()  { throw new RuntimeException(); }
  public  java.lang.String message ()  { throw new RuntimeException(); }
  public  java.lang.String startOffset ()  { throw new RuntimeException(); }
  /** Time when the exception occurred */
  public  long time ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
