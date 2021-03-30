package org.apache.spark.sql.columnar;
/**
 * Provides basic filtering for {@link CachedBatchSerializer} implementations.
 * The requirement to extend this is that all of the batches produced by your serializer are
 * instances of {@link SimpleMetricsCachedBatch}.
 * This does not calculate the metrics needed to be stored in the batches. That is up to each
 * implementation. The metrics required are really just min and max values and those are optional
 * especially for complex types. Because those metrics are simple and it is likely that compression
 * will also be done on the data we thought it best to let each implementation decide on the most
 * efficient way to calculate the metrics, possibly combining them with compression passes that
 * might also be done across the data.
 */
public abstract class SimpleMetricsCachedBatchSerializer implements org.apache.spark.sql.columnar.CachedBatchSerializer, org.apache.spark.internal.Logging {
  public   SimpleMetricsCachedBatchSerializer ()  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.Object, scala.collection.Iterator<org.apache.spark.sql.columnar.CachedBatch>, scala.collection.Iterator<org.apache.spark.sql.columnar.CachedBatch>> buildFilter (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> cachedAttributes)  { throw new RuntimeException(); }
}
