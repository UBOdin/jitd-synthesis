package org.apache.spark.sql.execution.streaming;
/**
 * This class is used to log offsets to persistent files in HDFS.
 * Each file corresponds to a specific batch of offsets. The file
 * format contains a version string in the first line, followed
 * by a the JSON string representation of the offsets separated
 * by a newline character. If a source offset is missing, then
 * that line will contain a string value defined in the
 * SERIALIZED_VOID_OFFSET variable in {@link OffsetSeqLog} companion object.
 * For instance, when dealing with {@link LongOffset} types:
 *   v1        // version 1
 *   metadata
 *   {0}       // LongOffset 0
 *   {3}       // LongOffset 3
 *   -         // No offset for this source i.e., an invalid JSON string
 *   {2}       // LongOffset 2
 *   ...
 */
public  class OffsetSeqLog extends org.apache.spark.sql.execution.streaming.HDFSMetadataLog<org.apache.spark.sql.execution.streaming.OffsetSeq> {
  static   int VERSION ()  { throw new RuntimeException(); }
  public   OffsetSeqLog (org.apache.spark.sql.SparkSession sparkSession, java.lang.String path)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.OffsetSeq deserialize (java.io.InputStream in)  { throw new RuntimeException(); }
  protected  void serialize (org.apache.spark.sql.execution.streaming.OffsetSeq offsetSeq, java.io.OutputStream out)  { throw new RuntimeException(); }
}
