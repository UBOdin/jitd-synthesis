package org.apache.spark.sql.execution;
/**
 * Physical plan node for scanning data from HadoopFsRelations.
 * <p>
 * param:  relation The file-based relation to scan.
 * param:  output Output attributes of the scan, including data attributes and partition attributes.
 * param:  requiredSchema Required schema of the underlying relation, excluding partition columns.
 * param:  partitionFilters Predicates to use for partition pruning.
 * param:  optionalBucketSet Bucket ids for bucket pruning.
 * param:  optionalNumCoalescedBuckets Number of coalesced buckets.
 * param:  dataFilters Filters on non-partition columns.
 * param:  tableIdentifier Identifier for the table in the metastore.
 * param:  disableBucketedScan Disable bucketed scan based on physical query plan, see rule
 *                            {@link DisableUnnecessaryBucketedScan} for details.
 */
public  class FileSourceScanExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.DataSourceScanExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  protected  int maxMetadataValueLength ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.HadoopFsRelation relation ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType requiredSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.util.collection.BitSet> optionalBucketSet ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> optionalNumCoalescedBuckets ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> tableIdentifier ()  { throw new RuntimeException(); }
  public  boolean disableBucketedScan ()  { throw new RuntimeException(); }
  // not preceding
  public   FileSourceScanExec (org.apache.spark.sql.execution.datasources.HadoopFsRelation relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.types.StructType requiredSchema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters, scala.Option<org.apache.spark.util.collection.BitSet> optionalBucketSet, scala.Option<java.lang.Object> optionalNumCoalescedBuckets, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters, scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> tableIdentifier, boolean disableBucketedScan)  { throw new RuntimeException(); }
  // not preceding
  public  boolean supportsColumnar ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<java.lang.String>> vectorTypes ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.datasources.PartitionDirectory[] selectedPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean bucketedScan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> metadata ()  { throw new RuntimeException(); }
  public  java.lang.String verboseStringWithOperatorId ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> doExecuteColumnar ()  { throw new RuntimeException(); }
  public  java.lang.String nodeNamePrefix ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.FileSourceScanExec doCanonicalize ()  { throw new RuntimeException(); }
}
