package org.apache.spark.sql.sources;
/**
 * ::Experimental::
 * Implemented by objects that can produce a streaming <code>Sink</code> for a specific format or system.
 * <p>
 * @since 2.0.0
 */
public  interface StreamSinkProvider {
  public  org.apache.spark.sql.execution.streaming.Sink createSink (org.apache.spark.sql.SQLContext sqlContext, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, scala.collection.Seq<java.lang.String> partitionColumns, org.apache.spark.sql.streaming.OutputMode outputMode)  ;
}
