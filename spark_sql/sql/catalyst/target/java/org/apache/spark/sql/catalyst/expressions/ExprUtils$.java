package org.apache.spark.sql.catalyst.expressions;
public  class ExprUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExprUtils$ MODULE$ = null;
  public   ExprUtils$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType evalTypeExpr (org.apache.spark.sql.catalyst.expressions.Expression exp)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType evalSchemaExpr (org.apache.spark.sql.catalyst.expressions.Expression exp)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> convertToMapData (org.apache.spark.sql.catalyst.expressions.Expression exp)  { throw new RuntimeException(); }
  /**
   * A convenient function for schema validation in datasources supporting
   * <code>columnNameOfCorruptRecord</code> as an option.
   * @param schema (undocumented)
   * @param columnNameOfCorruptRecord (undocumented)
   */
  public  void verifyColumnNameOfCorruptRecord (org.apache.spark.sql.types.StructType schema, java.lang.String columnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public  scala.Function1<java.lang.String, java.math.BigDecimal> getDecimalParser (java.util.Locale locale)  { throw new RuntimeException(); }
}
