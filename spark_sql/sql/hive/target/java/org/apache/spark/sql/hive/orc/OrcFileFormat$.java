package org.apache.spark.sql.hive.orc;
public  class OrcFileFormat$ implements org.apache.spark.sql.hive.HiveInspectors, org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OrcFileFormat$ MODULE$ = null;
  public   OrcFileFormat$ ()  { throw new RuntimeException(); }
    java.lang.String SARG_PUSHDOWN ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> extensionsForCompressionCodecNames ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> unwrapOrcStructs (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType requiredSchema, scala.Option<org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector> maybeStructOI, scala.collection.Iterator<org.apache.hadoop.io.Writable> iterator)  { throw new RuntimeException(); }
  public  void setRequiredColumns (org.apache.hadoop.conf.Configuration conf, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType requestedSchema)  { throw new RuntimeException(); }
  /**
   * Add a metadata specifying Spark version.
   * @param recordWriter (undocumented)
   */
  public  void addSparkVersionMetadata (org.apache.hadoop.mapred.RecordWriter<org.apache.hadoop.io.NullWritable, org.apache.hadoop.io.Writable> recordWriter)  { throw new RuntimeException(); }
}
