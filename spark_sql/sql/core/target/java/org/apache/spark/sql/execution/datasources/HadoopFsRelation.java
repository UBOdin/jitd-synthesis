package org.apache.spark.sql.execution.datasources;
/**
 * Acts as a container for all of the metadata required to read from a datasource. All discovery,
 * resolution and merging logic for schemas and partitions has been removed.
 * <p>
 * param:  location A {@link FileIndex} that can enumerate the locations of all the files that
 *                 comprise this relation.
 * param:  partitionSchema The schema of the columns (if any) that are used to partition the relation
 * param:  dataSchema The schema of any remaining columns.  Note that if any partition columns are
 *                   present in the actual data files as well, they are preserved.
 * param:  bucketSpec Describes the bucketing (hash-partitioning of the files by some column values).
 * param:  fileFormat A file format that can be used to read and write the data in files.
 * param:  options Configuration used when reading / writing data.
 */
public  class HadoopFsRelation extends org.apache.spark.sql.sources.BaseRelation implements org.apache.spark.sql.execution.FileRelation, scala.Product, scala.Serializable {
  public  org.apache.spark.sql.execution.datasources.FileIndex location ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.FileFormat fileFormat ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  // not preceding
  public   HadoopFsRelation (org.apache.spark.sql.execution.datasources.FileIndex location, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.types.StructType dataSchema, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, org.apache.spark.sql.execution.datasources.FileFormat fileFormat, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.types.StructField> overlappedPartCols ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> partitionSchemaOption ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long sizeInBytes ()  { throw new RuntimeException(); }
  public  java.lang.String[] inputFiles ()  { throw new RuntimeException(); }
}
