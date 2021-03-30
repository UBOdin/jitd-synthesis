package org.apache.spark.sql.execution.datasources;
/**
 * A command for writing data to a {@link HadoopFsRelation}.  Supports both overwriting and appending.
 * Writing to dynamic partitions is also supported.
 * <p>
 * param:  staticPartitions partial partitioning spec for write. This defines the scope of partition
 *                         overwrites: when the spec is empty, all partitions are overwritten.
 *                         When it covers a prefix of the partition keys, only partitions matching
 *                         the prefix are overwritten.
 * param:  ifPartitionNotExists If true, only write if the partition does not exist.
 *                             Only valid for static partitions.
 */
public  class InsertIntoHadoopFsRelationCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.DataWritingCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.hadoop.fs.Path outputPath ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> staticPartitions ()  { throw new RuntimeException(); }
  public  boolean ifPartitionNotExists ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.FileFormat fileFormat ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SaveMode mode ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTable> catalogTable ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.datasources.FileIndex> fileIndex ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoHadoopFsRelationCommand (org.apache.hadoop.fs.Path outputPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> staticPartitions, boolean ifPartitionNotExists, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, org.apache.spark.sql.execution.datasources.FileFormat fileFormat, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, org.apache.spark.sql.SaveMode mode, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTable> catalogTable, scala.Option<org.apache.spark.sql.execution.datasources.FileIndex> fileIndex, scala.collection.Seq<java.lang.String> outputColumnNames)  { throw new RuntimeException(); }
  // not preceding
    boolean dynamicPartitionOverwrite ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
}
