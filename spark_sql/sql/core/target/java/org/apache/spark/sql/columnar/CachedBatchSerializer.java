package org.apache.spark.sql.columnar;
/**
 * Provides APIs that handle transformations of SQL data associated with the cache/persist APIs.
 */
public  interface CachedBatchSerializer extends scala.Serializable {
  /**
   * Builds a function that can be used to filter batches prior to being decompressed.
   * In most cases extending {@link SimpleMetricsCachedBatchSerializer} will provide the filter logic
   * necessary. You will need to provide metrics for this to work. {@link SimpleMetricsCachedBatch}
   * provides the APIs to hold those metrics and explains the metrics used, really just min and max.
   * Note that this is intended to skip batches that are not needed, and the actual filtering of
   * individual rows is handled later.
   * @param predicates the set of expressions to use for filtering.
   * @param cachedAttributes the schema/attributes of the data that is cached. This can be helpful
   *                         if you don't store it with the data.
   * @return a function that takes the partition id and the iterator of batches in the partition.
   *         It returns an iterator of batches that should be decompressed.
   */
  public  scala.Function2<java.lang.Object, scala.collection.Iterator<org.apache.spark.sql.columnar.CachedBatch>, scala.collection.Iterator<org.apache.spark.sql.columnar.CachedBatch>> buildFilter (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> cachedAttributes)  ;
  /**
   * Convert the cached data into a ColumnarBatch. This currently is only used if
   * <code>supportsColumnarOutput()</code> returns true for the associated schema, but there are other checks
   * that can force row based output. One of the main advantages of doing columnar output over row
   * based output is that the code generation is more standard and can be combined with code
   * generation for downstream operations.
   * @param input the cached batches that should be converted.
   * @param cacheAttributes the attributes of the data in the batch.
   * @param selectedAttributes the fields that should be loaded from the data and the order they
   *                           should appear in the output batch.
   * @param conf the configuration for the job.
   * @return an RDD of the input cached batches transformed into the ColumnarBatch format.
   */
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> convertCachedBatchToColumnarBatch (org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> cacheAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> selectedAttributes, org.apache.spark.sql.internal.SQLConf conf)  ;
  /**
   * Convert the cached batch into <code>InternalRow</code>s. If you want this to be performant, code
   * generation is advised.
   * @param input the cached batches that should be converted.
   * @param cacheAttributes the attributes of the data in the batch.
   * @param selectedAttributes the field that should be loaded from the data and the order they
   *                           should appear in the output rows.
   * @param conf the configuration for the job.
   * @return RDD of the rows that were stored in the cached batches.
   */
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> convertCachedBatchToInternalRow (org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> cacheAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> selectedAttributes, org.apache.spark.sql.internal.SQLConf conf)  ;
  /**
   * Convert an <code>RDD[ColumnarBatch]</code> into an <code>RDD[CachedBatch]</code> in preparation for caching the data.
   * This will only be called if <code>supportsColumnarInput()</code> returned true for the given schema and
   * the plan up to this point would could produce columnar output without modifying it.
   * @param input the input <code>RDD</code> to be converted.
   * @param schema the schema of the data being stored.
   * @param storageLevel where the data will be stored.
   * @param conf the config for the query.
   * @return The data converted into a format more suitable for caching.
   */
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> convertColumnarBatchToCachedBatch (org.apache.spark.rdd.RDD<org.apache.spark.sql.vectorized.ColumnarBatch> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> schema, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.internal.SQLConf conf)  ;
  /**
   * Convert an <code>RDD[InternalRow]</code> into an <code>RDD[CachedBatch]</code> in preparation for caching the data.
   * @param input the input <code>RDD</code> to be converted.
   * @param schema the schema of the data being stored.
   * @param storageLevel where the data will be stored.
   * @param conf the config for the query.
   * @return The data converted into a format more suitable for caching.
   */
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> convertInternalRowToCachedBatch (org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> schema, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.internal.SQLConf conf)  ;
  /**
   * Can <code>convertColumnarBatchToCachedBatch()</code> be called instead of
   * <code>convertInternalRowToCachedBatch()</code> for this given schema? True if it can and false if it
   * cannot. Columnar input is only supported if the plan could produce columnar output. Currently
   * this is mostly supported by input formats like parquet and orc, but more operations are likely
   * to be supported soon.
   * @param schema the schema of the data being stored.
   * @return True if columnar input can be supported, else false.
   */
  public  boolean supportsColumnarInput (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> schema)  ;
  /**
   * Can <code>convertCachedBatchToColumnarBatch()</code> be called instead of
   * <code>convertCachedBatchToInternalRow()</code> for this given schema? True if it can and false if it
   * cannot. Columnar output is typically preferred because it is more efficient. Note that
   * <code>convertCachedBatchToInternalRow()</code> must always be supported as there are other checks that
   * can force row based output.
   * @param schema the schema of the data being checked.
   * @return true if columnar output should be used for this schema, else false.
   */
  public  boolean supportsColumnarOutput (org.apache.spark.sql.types.StructType schema)  ;
  /**
   * The exact java types of the columns that are output in columnar processing mode. This
   * is a performance optimization for code generation and is optional.
   * @param attributes the attributes to be output.
   * @param conf the config for the query that will read the data.
   * @return (undocumented)
   */
  public  scala.Option<scala.collection.Seq<java.lang.String>> vectorTypes (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attributes, org.apache.spark.sql.internal.SQLConf conf)  ;
}
