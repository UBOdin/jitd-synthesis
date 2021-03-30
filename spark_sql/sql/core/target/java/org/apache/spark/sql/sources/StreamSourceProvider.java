package org.apache.spark.sql.sources;
/**
 * ::Experimental::
 * Implemented by objects that can produce a streaming <code>Source</code> for a specific format or system.
 * <p>
 * @since 2.0.0
 */
public  interface StreamSourceProvider {
  /**
   * @since 2.0.0
   * @param sqlContext (undocumented)
   * @param metadataPath (undocumented)
   * @param schema (undocumented)
   * @param providerName (undocumented)
   * @param parameters (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.Source createSource (org.apache.spark.sql.SQLContext sqlContext, java.lang.String metadataPath, scala.Option<org.apache.spark.sql.types.StructType> schema, java.lang.String providerName, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  ;
  /**
   * Returns the name and schema of the source that can be used to continually read data.
   * @since 2.0.0
   * @param sqlContext (undocumented)
   * @param schema (undocumented)
   * @param providerName (undocumented)
   * @param parameters (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<java.lang.String, org.apache.spark.sql.types.StructType> sourceSchema (org.apache.spark.sql.SQLContext sqlContext, scala.Option<org.apache.spark.sql.types.StructType> schema, java.lang.String providerName, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  ;
}
