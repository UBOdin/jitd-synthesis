package org.apache.spark.sql.execution.datasources.v2;
public abstract class FileWriteBuilder implements org.apache.spark.sql.connector.write.WriteBuilder {
  public   FileWriteBuilder (scala.collection.Seq<java.lang.String> paths, java.lang.String formatName, scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> supportsDataType, org.apache.spark.sql.connector.write.LogicalWriteInfo info)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.BatchWrite buildForBatch ()  { throw new RuntimeException(); }
  /**
   * Prepares a write job and returns an {@link OutputWriterFactory}.  Client side job preparation can
   * be put here.  For example, user defined output committer can be configured here
   * by setting the output committer class in the conf of spark.sql.sources.outputCommitterClass.
   * @param sqlConf (undocumented)
   * @param job (undocumented)
   * @param options (undocumented)
   * @param dataSchema (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.execution.datasources.OutputWriterFactory prepareWrite (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.hadoop.mapreduce.Job job, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.types.StructType dataSchema)  ;
}
