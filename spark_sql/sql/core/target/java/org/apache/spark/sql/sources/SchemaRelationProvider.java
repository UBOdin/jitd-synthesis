package org.apache.spark.sql.sources;
/**
 * Implemented by objects that produce relations for a specific kind of data source
 * with a given schema.  When Spark SQL is given a DDL operation with a USING clause specified (
 * to specify the implemented SchemaRelationProvider) and a user defined schema, this interface
 * is used to pass in the parameters specified by a user.
 * <p>
 * Users may specify the fully qualified class name of a given data source.  When that class is
 * not found Spark SQL will append the class name <code>DefaultSource</code> to the path, allowing for
 * less verbose invocation.  For example, 'org.apache.spark.sql.json' would resolve to the
 * data source 'org.apache.spark.sql.json.DefaultSource'
 * <p>
 * A new instance of this class will be instantiated each time a DDL call is made.
 * <p>
 * The difference between a {@link RelationProvider} and a {@link SchemaRelationProvider} is that
 * users need to provide a schema when using a {@link SchemaRelationProvider}.
 * A relation provider can inherit both {@link RelationProvider} and {@link SchemaRelationProvider}
 * if it can support both schema inference and user-specified schemas.
 * <p>
 * @since 1.3.0
 */
public  interface SchemaRelationProvider {
  /**
   * Returns a new base relation with the given parameters and user defined schema.
   * <p>
   * @note The parameters' keywords are case insensitive and this insensitivity is enforced
   * by the Map that is passed to the function.
   * @param sqlContext (undocumented)
   * @param parameters (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext sqlContext, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.types.StructType schema)  ;
}
