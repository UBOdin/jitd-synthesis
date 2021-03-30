package org.apache.spark.sql.execution.datasources;
/**
 * A {@link FileIndex} for a metastore catalog table.
 * <p>
 * param:  sparkSession a {@link SparkSession}
 * param:  table the metadata of the table
 * param:  sizeInBytes the table's data size in bytes
 */
public  class CatalogFileIndex implements org.apache.spark.sql.execution.datasources.FileIndex {
  // not preceding
  public   CatalogFileIndex (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.catalog.CatalogTable table, long sizeInBytes)  { throw new RuntimeException(); }
  public  boolean equals (Object o)  { throw new RuntimeException(); }
  /**
   * Returns a {@link InMemoryFileIndex} for this table restricted to the subset of partitions
   * specified by the given partition-pruning filters.
   * <p>
   * @param filters partition-pruning filters
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.datasources.InMemoryFileIndex filterPartitions (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> filters)  { throw new RuntimeException(); }
  protected  org.apache.hadoop.conf.Configuration hadoopConf ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  java.lang.String[] inputFiles ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionDirectory> listFiles (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionFilters, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> dataFilters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  public  void refresh ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.fs.Path> rootPaths ()  { throw new RuntimeException(); }
  public  long sizeInBytes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable table ()  { throw new RuntimeException(); }
}
