package org.apache.spark.sql.streaming;
/**
 * Reports information about the instantaneous status of a streaming query.
 * <p>
 * param:  message A human readable description of what the stream is currently doing.
 * param:  isDataAvailable True when there is new data to be processed. Doesn't apply
 *                        to ContinuousExecution where it is always false.
 * param:  isTriggerActive True when the trigger is actively firing, false when waiting for the
 *                        next trigger time. Doesn't apply to ContinuousExecution where it is
 *                        always false.
 * <p>
 * @since 2.1.0
 */
public  class StreamingQueryStatus implements scala.Serializable {
  // not preceding
  protected   StreamingQueryStatus (java.lang.String message, boolean isDataAvailable, boolean isTriggerActive)  { throw new RuntimeException(); }
    org.apache.spark.sql.streaming.StreamingQueryStatus copy (java.lang.String message, boolean isDataAvailable, boolean isTriggerActive)  { throw new RuntimeException(); }
  public  boolean isDataAvailable ()  { throw new RuntimeException(); }
  public  boolean isTriggerActive ()  { throw new RuntimeException(); }
  /** The compact JSON representation of this status. */
  public  java.lang.String json ()  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  public  java.lang.String message ()  { throw new RuntimeException(); }
  /** The pretty (i.e. indented) JSON representation of this status. */
  public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
