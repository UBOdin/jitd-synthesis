package org.apache.spark.sql.execution.datasources;
public  class CodecStreams {
  static public  java.io.InputStream createInputStream (org.apache.hadoop.conf.Configuration config, org.apache.hadoop.fs.Path file)  { throw new RuntimeException(); }
  /**
   * Creates an input stream from the given path and add a closure for the input stream to be
   * closed on task completion.
   * @param config (undocumented)
   * @param path (undocumented)
   * @return (undocumented)
   */
  static public  java.io.InputStream createInputStreamWithCloseResource (org.apache.hadoop.conf.Configuration config, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  /**
   * Create a new file and open it for writing.
   * If compression is enabled in the {@link JobContext} the stream will write compressed data to disk.
   * An exception will be thrown if the file already exists.
   * @param context (undocumented)
   * @param file (undocumented)
   * @return (undocumented)
   */
  static public  java.io.OutputStream createOutputStream (org.apache.hadoop.mapreduce.JobContext context, org.apache.hadoop.fs.Path file)  { throw new RuntimeException(); }
  static public  java.io.OutputStreamWriter createOutputStreamWriter (org.apache.hadoop.mapreduce.JobContext context, org.apache.hadoop.fs.Path file, java.nio.charset.Charset charset)  { throw new RuntimeException(); }
  /** Returns the compression codec extension to be used in a file name, e.g. ".gzip"). */
  static public  java.lang.String getCompressionExtension (org.apache.hadoop.mapreduce.JobContext context)  { throw new RuntimeException(); }
}
