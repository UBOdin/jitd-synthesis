package org.apache.spark.sql.execution.datasources;
/**
 * An adaptor from a {@link PartitionedFile} to an {@link Iterator} of {@link Text}, which is all of the lines
 * in that file.
 */
public  class HadoopFileWholeTextReader implements scala.collection.Iterator<org.apache.hadoop.io.Text>, java.io.Closeable {
  public   HadoopFileWholeTextReader (org.apache.spark.sql.execution.datasources.PartitionedFile file, org.apache.hadoop.conf.Configuration conf)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.io.Text next ()  { throw new RuntimeException(); }
}
