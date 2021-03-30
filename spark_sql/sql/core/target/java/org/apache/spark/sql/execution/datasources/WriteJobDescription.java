package org.apache.spark.sql.execution.datasources;
/** A shared job description for all the write tasks. */
public  class WriteJobDescription implements scala.Serializable {
  // not preceding
  public   WriteJobDescription (java.lang.String uuid, org.apache.spark.util.SerializableConfiguration serializableHadoopConf, org.apache.spark.sql.execution.datasources.OutputWriterFactory outputWriterFactory, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> allColumns, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataColumns, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> bucketIdExpression, java.lang.String path, scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String> customPartitionLocations, long maxRecordsPerFile, java.lang.String timeZoneId, scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteJobStatsTracker> statsTrackers)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> allColumns ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> bucketIdExpression ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<scala.collection.immutable.Map<java.lang.String, java.lang.String>, java.lang.String> customPartitionLocations ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataColumns ()  { throw new RuntimeException(); }
  public  long maxRecordsPerFile ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.OutputWriterFactory outputWriterFactory ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns ()  { throw new RuntimeException(); }
  public  java.lang.String path ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.SerializableConfiguration serializableHadoopConf ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteJobStatsTracker> statsTrackers ()  { throw new RuntimeException(); }
  public  java.lang.String timeZoneId ()  { throw new RuntimeException(); }
  public  java.lang.String uuid ()  { throw new RuntimeException(); }
}
