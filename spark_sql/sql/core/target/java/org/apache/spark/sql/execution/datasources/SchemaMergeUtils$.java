package org.apache.spark.sql.execution.datasources;
public  class SchemaMergeUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SchemaMergeUtils$ MODULE$ = null;
  public   SchemaMergeUtils$ ()  { throw new RuntimeException(); }
  /**
   * Figures out a merged Parquet/ORC schema with a distributed Spark job.
   * @param sparkSession (undocumented)
   * @param parameters (undocumented)
   * @param files (undocumented)
   * @param schemaReader (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.types.StructType> mergeSchemasInParallel (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files, scala.Function3<scala.collection.Seq<org.apache.hadoop.fs.FileStatus>, org.apache.hadoop.conf.Configuration, java.lang.Object, scala.collection.Seq<org.apache.spark.sql.types.StructType>> schemaReader)  { throw new RuntimeException(); }
}
