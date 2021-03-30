package org.apache.spark.sql.execution.datasources;
/**
 * An interface for objects capable of enumerating the root paths of a relation as well as the
 * partitions of a relation subject to some pruning expressions.
 */
public  interface FileIndex {
  /**
   * Returns the list of files that will be read when scanning this relation. This call may be
   * very expensive for large tables.
   * @return (undocumented)
   */
  public  java.lang.String[] inputFiles ()  ;
  /**
   * Returns all valid files grouped into partitions when the data is partitioned. If the data is
   * unpartitioned, this will return a single partition with no partition values.
   * <p>
   * @param partitionFilters The filters used to prune which partitions are returned. These filters
   *                         must only refer to partition columns and this method will only return
   *                         files where these predicates are guaranteed to evaluate to <code>true</code>.
   *                         Thus, these filters will not need to be evaluated again on the
   *                         returned data.
   * @param dataFilters Filters that can be applied on non-partitioned columns. The implementation
   *                    does not need to guarantee these filters are applied, i.e. the execution
   *                    engine will ensure these filters are still applied on the returned files.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> listFiles (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters)  ;
  /**
   * Returns an optional metadata operation time, in nanoseconds, for listing files.
   * <p>
   * We do file listing in query optimization (in order to get the proper statistics) and we want
   * to account for file listing time in physical execution (as metrics). To do that, we save the
   * file listing time in some implementations and physical execution calls it in this method
   * to update the metrics.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.Object> metadataOpsTimeNs ()  ;
  /** Schema of the partitioning columns, or the empty schema if the table is not partitioned. */
  public  org.apache.spark.sql.types.StructType partitionSchema ()  ;
  /** Refresh any cached file listings */
  public  void refresh ()  ;
  /**
   * Returns the list of root input paths from which the catalog will get files. There may be a
   * single root path from which partitions are discovered, or individual partitions may be
   * specified by each path.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.hadoop.fs.Path> rootPaths ()  ;
  /** Sum of table file sizes, in bytes */
  public  long sizeInBytes ()  ;
}
