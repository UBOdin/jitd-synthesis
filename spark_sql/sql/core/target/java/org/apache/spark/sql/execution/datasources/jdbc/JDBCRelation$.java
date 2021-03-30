package org.apache.spark.sql.execution.datasources.jdbc;
public  class JDBCRelation$ implements org.apache.spark.internal.Logging, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JDBCRelation$ MODULE$ = null;
  public   JDBCRelation$ ()  { throw new RuntimeException(); }
  /**
   * Given a partitioning schematic (a column of integral type, a number of
   * partitions, and upper and lower bounds on the column's value), generate
   * WHERE clauses for each partition so that each row in the table appears
   * exactly once.  The parameters minValue and maxValue are advisory in that
   * incorrect values may cause the partitioning to be poor, but no data
   * will fail to be represented.
   * <p>
   * Null value predicate is added to the first partition where clause to include
   * the rows with null value for the partitions column.
   * <p>
   * @param schema resolved schema of a JDBC table
   * @param resolver function used to determine if two identifiers are equal
   * @param timeZoneId timezone ID to be used if a partition column type is date or timestamp
   * @param jdbcOptions JDBC options that contains url
   * @return an array of partitions with where clause for each partition
   */
  public  org.apache.spark.Partition[] columnPartition (org.apache.spark.sql.types.StructType schema, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver, java.lang.String timeZoneId, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions)  { throw new RuntimeException(); }
  /**
   * Takes a (schema, table) specification and returns the table's Catalyst schema.
   * If <code>customSchema</code> defined in the JDBC options, replaces the schema's dataType with the
   * custom schema's type.
   * <p>
   * @param resolver function used to determine if two identifiers are equal
   * @param jdbcOptions JDBC options that contains url, table and other information.
   * @return resolved Catalyst schema of a JDBC table
   */
  public  org.apache.spark.sql.types.StructType getSchema (scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions)  { throw new RuntimeException(); }
  /**
   * Resolves a Catalyst schema of a JDBC table and returns {@link JDBCRelation} with the schema.
   * @param parts (undocumented)
   * @param jdbcOptions (undocumented)
   * @param sparkSession (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.datasources.jdbc.JDBCRelation apply (org.apache.spark.Partition[] parts, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions, org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
