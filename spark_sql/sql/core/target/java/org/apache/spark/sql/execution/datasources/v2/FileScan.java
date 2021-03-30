package org.apache.spark.sql.execution.datasources.v2;
public  interface FileScan extends org.apache.spark.sql.connector.read.Scan, org.apache.spark.sql.connector.read.Batch, org.apache.spark.sql.connector.read.SupportsReportStatistics, org.apache.spark.sql.internal.connector.SupportsMetadata, org.apache.spark.internal.Logging {
  /**
   * Returns the data filters that can be use for file listing
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters ()  ;
  public  java.lang.String description ()  ;
  public  boolean equals (Object obj)  ;
  public  boolean equivalentFilters (org.apache.spark.sql.sources.Filter[] a, org.apache.spark.sql.sources.Filter[] b)  ;
  public  org.apache.spark.sql.connector.read.Statistics estimateStatistics ()  ;
  public  org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex fileIndex ()  ;
  /**
   * If a file with <code>path</code> is unsplittable, return the unsplittable reason,
   * otherwise return <code>None</code>.
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getFileUnSplittableReason (org.apache.hadoop.fs.Path path)  ;
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> getMetaData ()  ;
  public  int hashCode ()  ;
  /**
   * Returns whether a file with <code>path</code> could be split or not.
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  boolean isSplitable (org.apache.hadoop.fs.Path path)  ;
  public  int maxMetadataValueLength ()  ;
  public  java.lang.String normalizeName (java.lang.String name)  ;
  /**
   * Returns the filters that can be use for partition pruning
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.FilePartition> partitions ()  ;
  public  org.apache.spark.sql.connector.read.InputPartition[] planInputPartitions ()  ;
  /**
   * Returns the required data schema
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType readDataSchema ()  ;
  /**
   * Returns the required partition schema
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType readPartitionSchema ()  ;
  public  org.apache.spark.sql.types.StructType readSchema ()  ;
  public  java.lang.String seqToString (scala.collection.Seq<java.lang.Object> seq)  ;
  public  org.apache.spark.sql.SparkSession sparkSession ()  ;
  public  org.apache.spark.sql.connector.read.Batch toBatch ()  ;
  /**
   * Create a new <code>FileScan</code> instance from the current one
   * with different <code>partitionFilters</code> and <code>dataFilters</code>
   * @param partitionFilters (undocumented)
   * @param dataFilters (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.datasources.v2.FileScan withFilters (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters)  ;
}
