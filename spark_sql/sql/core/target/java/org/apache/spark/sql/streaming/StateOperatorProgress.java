package org.apache.spark.sql.streaming;
/**
 * Information about updates made to stateful operators in a {@link StreamingQuery} during a trigger.
 */
public  class StateOperatorProgress implements scala.Serializable {
  public  long numRowsTotal ()  { throw new RuntimeException(); }
  public  long numRowsUpdated ()  { throw new RuntimeException(); }
  public  long memoryUsedBytes ()  { throw new RuntimeException(); }
  public  long numRowsDroppedByWatermark ()  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.Long> customMetrics ()  { throw new RuntimeException(); }
  // not preceding
     StateOperatorProgress (long numRowsTotal, long numRowsUpdated, long memoryUsedBytes, long numRowsDroppedByWatermark, java.util.Map<java.lang.String, java.lang.Long> customMetrics)  { throw new RuntimeException(); }
  /** The compact JSON representation of this progress. */
  public  java.lang.String json ()  { throw new RuntimeException(); }
  /** The pretty (i.e. indented) JSON representation of this progress. */
  public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
    org.apache.spark.sql.streaming.StateOperatorProgress copy (long newNumRowsUpdated, long newNumRowsDroppedByWatermark)  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
