package org.apache.spark.sql.jdbc;
/**
 * :: DeveloperApi ::
 * A database type definition coupled with the jdbc type needed to send null
 * values to the database.
 * param:  databaseTypeDefinition The database type definition
 * param:  jdbcNullType The jdbc type (as defined in java.sql.Types) used to
 *                     send a null value to the database.
 */
public  class JdbcType implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String databaseTypeDefinition ()  { throw new RuntimeException(); }
  public  int jdbcNullType ()  { throw new RuntimeException(); }
  // not preceding
  public   JdbcType (java.lang.String databaseTypeDefinition, int jdbcNullType)  { throw new RuntimeException(); }
}
