package org.apache.spark.sql.util;
/**
 * Utils for handling schemas.
 * <p>
 * TODO: Merge this file with {@link org.apache.spark.ml.util.SchemaUtils}.
 */
public  class SchemaUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SchemaUtils$ MODULE$ = null;
  public   SchemaUtils$ ()  { throw new RuntimeException(); }
  /**
   * Checks if an input schema has duplicate column names. This throws an exception if the
   * duplication exists.
   * <p>
   * @param schema schema to check
   * @param colType column type name, used in an exception message
   * @param caseSensitiveAnalysis whether duplication checks should be case sensitive or not
   */
  public  void checkSchemaColumnNameDuplication (org.apache.spark.sql.types.DataType schema, java.lang.String colType, boolean caseSensitiveAnalysis)  { throw new RuntimeException(); }
  /**
   * Checks if an input schema has duplicate column names. This throws an exception if the
   * duplication exists.
   * <p>
   * @param schema schema to check
   * @param colType column type name, used in an exception message
   * @param resolver resolver used to determine if two identifiers are equal
   */
  public  void checkSchemaColumnNameDuplication (org.apache.spark.sql.types.StructType schema, java.lang.String colType, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Checks if input column names have duplicate identifiers. This throws an exception if
   * the duplication exists.
   * <p>
   * @param columnNames column names to check
   * @param colType column type name, used in an exception message
   * @param resolver resolver used to determine if two identifiers are equal
   */
  public  void checkColumnNameDuplication (scala.collection.Seq<java.lang.String> columnNames, java.lang.String colType, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Checks if input column names have duplicate identifiers. This throws an exception if
   * the duplication exists.
   * <p>
   * @param columnNames column names to check
   * @param colType column type name, used in an exception message
   * @param caseSensitiveAnalysis whether duplication checks should be case sensitive or not
   */
  public  void checkColumnNameDuplication (scala.collection.Seq<java.lang.String> columnNames, java.lang.String colType, boolean caseSensitiveAnalysis)  { throw new RuntimeException(); }
  /**
   * Returns all column names in this schema as a flat list. For example, a schema like:
   *   | - a
   *   | | - 1
   *   | | - 2
   *   | - b
   *   | - c
   *   | | - nest
   *   |   | - 3
   *   will get flattened to: "a", "a.1", "a.2", "b", "c", "c.nest", "c.nest.3"
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> explodeNestedFieldNames (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Checks if the partitioning transforms are being duplicated or not. Throws an exception if
   * duplication exists.
   * <p>
   * @param transforms the schema to check for duplicates
   * @param checkType contextual information around the check, used in an exception message
   * @param isCaseSensitive Whether to be case sensitive when comparing column names
   */
  public  void checkTransformDuplication (scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> transforms, java.lang.String checkType, boolean isCaseSensitive)  { throw new RuntimeException(); }
  /**
   * Returns the given column's ordinal within the given <code>schema</code>. The length of the returned
   * position will be as long as how nested the column is.
   * <p>
   * @param column The column to search for in the given struct. If the length of <code>column</code> is
   *               greater than 1, we expect to enter a nested field.
   * @param schema The current struct we are looking at.
   * @param resolver The resolver to find the column.
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.Object> findColumnPosition (scala.collection.Seq<java.lang.String> column, org.apache.spark.sql.types.StructType schema, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  /**
   * Gets the name of the column in the given position.
   * @param position (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> getColumnName (scala.collection.Seq<java.lang.Object> position, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * @param str The string to be escaped.
   * @return The escaped string.
   */
  public  java.lang.String escapeMetaCharacters (java.lang.String str)  { throw new RuntimeException(); }
}
