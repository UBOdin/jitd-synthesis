package org.apache.spark.sql.sources;
/**
 * @since 1.3.0
 */
public  interface CreatableRelationProvider {
  /**
   * Saves a DataFrame to a destination (using data source-specific parameters)
   * <p>
   * @param sqlContext SQLContext
   * @param mode specifies what happens when the destination already exists
   * @param parameters data source-specific parameters
   * @param data DataFrame to save (i.e. the rows after executing the query)
   * @return Relation with a known schema
   * <p>
   * @since 1.3.0
   */
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext sqlContext, org.apache.spark.sql.SaveMode mode, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data)  ;
}
