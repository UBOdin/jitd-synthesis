package org.apache.spark.sql.streaming;
/**
 * Information about progress made for a source in the execution of a {@link StreamingQuery}
 * during a trigger. See {@link StreamingQueryProgress} for more information.
 * <p>
 * param:  description            Description of the source.
 * param:  startOffset            The starting offset for data being read.
 * param:  endOffset              The ending offset for data being read.
 * param:  latestOffset           The latest offset from this source.
 * param:  numInputRows           The number of records read from this source.
 * param:  inputRowsPerSecond     The rate at which data is arriving from this source.
 * param:  processedRowsPerSecond The rate at which data from this source is being processed by
 *                               Spark.
 * @since 2.1.0
 */
public  class SourceProgress implements scala.Serializable {
  // not preceding
  protected   SourceProgress (java.lang.String description, java.lang.String startOffset, java.lang.String endOffset, java.lang.String latestOffset, long numInputRows, double inputRowsPerSecond, double processedRowsPerSecond)  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  java.lang.String endOffset ()  { throw new RuntimeException(); }
  public  double inputRowsPerSecond ()  { throw new RuntimeException(); }
  /** The compact JSON representation of this progress. */
  public  java.lang.String json ()  { throw new RuntimeException(); }
    org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  public  java.lang.String latestOffset ()  { throw new RuntimeException(); }
  public  long numInputRows ()  { throw new RuntimeException(); }
  /** The pretty (i.e. indented) JSON representation of this progress. */
  public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  public  double processedRowsPerSecond ()  { throw new RuntimeException(); }
  public  java.lang.String startOffset ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
