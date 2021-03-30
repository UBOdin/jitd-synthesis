package org.apache.spark.sql.catalyst.expressions;
/**
 * For a child whose data type is an array of structs, extracts the <code>ordinal</code>-th fields of all array
 * elements, and returns them as a new array.
 * <p>
 * No need to do type checking since it is handled by {@link ExtractValue}.
 */
public  class GetArrayStructFields extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ExtractValue, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructField field ()  { throw new RuntimeException(); }
  public  int ordinal ()  { throw new RuntimeException(); }
  public  int numFields ()  { throw new RuntimeException(); }
  public  boolean containsNull ()  { throw new RuntimeException(); }
  // not preceding
  public   GetArrayStructFields (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.StructField field, int ordinal, int numFields, boolean containsNull)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
