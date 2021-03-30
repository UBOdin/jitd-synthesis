package org.apache.spark.sql.execution.columnar;
/**
 * The default implementation of CachedBatchSerializer.
 */
public  class DefaultCachedBatchSerializer extends org.apache.spark.sql.columnar.SimpleMetricsCachedBatchSerializer {
  public   DefaultCachedBatchSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> convertCachedBatchToColumnarBatch (org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> cacheAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> selectedAttributes, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> convertCachedBatchToInternalRow (org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> cacheAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> selectedAttributes, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> convertColumnarBatchToCachedBatch (org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> schema, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> convertForCacheInternal (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, int batchSize, boolean useCompression)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> convertInternalRowToCachedBatch (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> schema, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public  boolean supportsColumnarInput (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> schema)  { throw new RuntimeException(); }
  public  boolean supportsColumnarOutput (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<java.lang.String>> vectorTypes (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
}
