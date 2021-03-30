package org.apache.spark.sql.execution.datasources;
/**
 * An abstract class that represents {@link FileIndex}s that are aware of partitioned tables.
 * It provides the necessary methods to parse partition data based on a set of files.
 * <p>
 * param:  parameters as set of options to control partition discovery
 * param:  userSpecifiedSchema an optional user specified schema that will be use to provide
 *                            types for the discovered partitions
 */
public abstract class PartitioningAwareFileIndex implements org.apache.spark.sql.execution.datasources.FileIndex, org.apache.spark.internal.Logging {
  static public  java.lang.String BASE_PATH_PARAM ()  { throw new RuntimeException(); }
  public   PartitioningAwareFileIndex (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.Option<org.apache.spark.sql.types.StructType> userSpecifiedSchema, org.apache.spark.sql.execution.datasources.FileStatusCache fileStatusCache)  { throw new RuntimeException(); }
  /** Returns the specification of the partitions inferred from the data. */
  public abstract  org.apache.spark.sql.execution.datasources.PartitionSpec partitionSpec ()  ;
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  protected  org.apache.hadoop.conf.Configuration hadoopConf ()  { throw new RuntimeException(); }
  protected abstract  scala.collection.mutable.LinkedHashMap<org.apache.hadoop.fs.Path, org.apache.hadoop.fs.FileStatus> leafFiles ()  ;
  protected abstract  scala.collection.immutable.Map<org.apache.hadoop.fs.Path, org.apache.hadoop.fs.FileStatus[]> leafDirToChildrenFiles ()  ;
  protected  boolean matchPathPattern (org.apache.hadoop.fs.FileStatus file)  { throw new RuntimeException(); }
  // not preceding
  protected  boolean recursiveFileLookup ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> listFiles (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters)  { throw new RuntimeException(); }
  /** Returns the list of files that will be read when scanning this relation. */
  public  java.lang.String[] inputFiles ()  { throw new RuntimeException(); }
  public  long sizeInBytes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.fs.FileStatus> allFiles ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.datasources.PartitionSpec inferPartitioning ()  { throw new RuntimeException(); }
}
