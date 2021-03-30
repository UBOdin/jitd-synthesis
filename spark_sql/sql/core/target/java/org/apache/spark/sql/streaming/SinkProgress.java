package org.apache.spark.sql.streaming;
/**
 * Information about progress made for a sink in the execution of a {@link StreamingQuery}
 * during a trigger. See {@link StreamingQueryProgress} for more information.
 * <p>
 * param:  description Description of the source corresponding to this status.
 * param:  numOutputRows Number of rows written to the sink or -1 for Continuous Mode (temporarily)
 * or Sink V1 (until decommissioned).
 * @since 2.1.0
 */
public  class SinkProgress implements scala.Serializable {
  static public  long DEFAULT_NUM_OUTPUT_ROWS ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.streaming.SinkProgress apply (java.lang.String description, scala.Option<java.lang.Object> numOutputRows)  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  long numOutputRows ()  { throw new RuntimeException(); }
  // not preceding
  protected   SinkProgress (java.lang.String description, long numOutputRows)  { throw new RuntimeException(); }
  /** SinkProgress without custom metrics. */
  protected   SinkProgress (java.lang.String description)  { throw new RuntimeException(); }
  /** The compact JSON representation of this progress. */
  public  java.lang.String json ()  { throw new RuntimeException(); }
  /** The pretty (i.e. indented) JSON representation of this progress. */
  public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
}
