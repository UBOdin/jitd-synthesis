package org.apache.spark.sql.execution.datasources;
/**
 * A factory that produces {@link OutputWriter}s.  A new {@link OutputWriterFactory} is created on driver
 * side for each write job issued when writing to a {@link HadoopFsRelation}, and then gets serialized
 * to executor side to create actual {@link OutputWriter}s on the fly.
 */
public abstract class OutputWriterFactory implements scala.Serializable {
  public   OutputWriterFactory ()  { throw new RuntimeException(); }
  /** Returns the file extension to be used when writing files out. */
  public abstract  java.lang.String getFileExtension (org.apache.hadoop.mapreduce.TaskAttemptContext context)  ;
  /**
   * When writing to a {@link HadoopFsRelation}, this method gets called by each task on executor side
   * to instantiate new {@link OutputWriter}s.
   * <p>
   * @param path Path to write the file.
   * @param dataSchema Schema of the rows to be written. Partition columns are not included in the
   *        schema if the relation being written is partitioned.
   * @param context The Hadoop MapReduce task context.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.execution.datasources.OutputWriter newInstance (java.lang.String path, org.apache.spark.sql.types.StructType dataSchema, org.apache.hadoop.mapreduce.TaskAttemptContext context)  ;
}
