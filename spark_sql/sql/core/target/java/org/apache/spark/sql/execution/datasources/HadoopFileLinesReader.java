package org.apache.spark.sql.execution.datasources;
/**
 * An adaptor from a {@link PartitionedFile} to an {@link Iterator} of {@link Text}, which are all of the lines
 * in that file.
 * <p>
 * param:  file A part (i.e. "block") of a single file that should be read line by line.
 * param:  lineSeparator A line separator that should be used for each line. If the value is <code>None</code>,
 *                      it covers <code>\r</code>, <code>\r\n</code> and <code>\n</code>.
 * param:  conf Hadoop configuration
 * <p>
 * @note The behavior when <code>lineSeparator</code> is <code>None</code> (covering <code>\r</code>, <code>\r\n</code> and <code>\n</code>) is defined
 * by {@link LineRecordReader}, not within Spark.
 */
public  class HadoopFileLinesReader implements scala.collection.Iterator<org.apache.hadoop.io.Text>, java.io.Closeable {
  public   HadoopFileLinesReader (org.apache.spark.sql.execution.datasources.PartitionedFile file, scala.Option<byte[]> lineSeparator, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  public   HadoopFileLinesReader (org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.io.Text next ()  { throw new RuntimeException(); }
}
