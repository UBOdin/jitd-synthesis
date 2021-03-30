package org.apache.spark.sql.execution.datasources.v2;
public abstract class FileScanBuilder implements org.apache.spark.sql.connector.read.ScanBuilder, org.apache.spark.sql.connector.read.SupportsPushDownRequiredColumns {
  public   FileScanBuilder (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex fileIndex, org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  public  void pruneColumns (org.apache.spark.sql.types.StructType requiredSchema)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.types.StructType readDataSchema ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.types.StructType readPartitionSchema ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.types.StructType requiredSchema ()  { throw new RuntimeException(); }
  protected  boolean supportsNestedSchemaPruning ()  { throw new RuntimeException(); }
}
