package org.apache.spark.sql.execution.datasources.jdbc;
public  class JDBCRDD$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JDBCRDD$ MODULE$ = null;
  public   JDBCRDD$ ()  { throw new RuntimeException(); }
  /**
   * Takes a (schema, table) specification and returns the table's Catalyst
   * schema.
   * <p>
   * @param options - JDBC options that contains url, table and other information.
   * <p>
   * @return A StructType giving the table's Catalyst schema.
   * @throws java.sql.SQLException if the table specification is garbage.
   * @throws java.sql.SQLException if the table contains an unsupported type.
   */
  public  org.apache.spark.sql.types.StructType resolveTable (org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions options)  { throw new RuntimeException(); }
  /**
   * Turns a single Filter into a String representing a SQL expression.
   * Returns None for an unhandled filter.
   * @param f (undocumented)
   * @param dialect (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> compileFilter (org.apache.spark.sql.sources.Filter f, org.apache.spark.sql.jdbc.JdbcDialect dialect)  { throw new RuntimeException(); }
  /**
   * Build and return JDBCRDD from the given information.
   * <p>
   * @param sc - Your SparkContext.
   * @param schema - The Catalyst schema of the underlying database table.
   * @param requiredColumns - The names of the columns to SELECT.
   * @param filters - The filters to include in all WHERE clauses.
   * @param parts - An array of JDBCPartitions specifying partition ids and
   *    per-partition WHERE clauses.
   * @param options - JDBC options that contains url, table and other information.
   * <p>
   * @return An RDD representing "SELECT requiredColumns FROM fqTable".
   */
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> scanTable (org.apache.spark.SparkContext sc, org.apache.spark.sql.types.StructType schema, java.lang.String[] requiredColumns, org.apache.spark.sql.sources.Filter[] filters, org.apache.spark.Partition[] parts, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions options)  { throw new RuntimeException(); }
}
