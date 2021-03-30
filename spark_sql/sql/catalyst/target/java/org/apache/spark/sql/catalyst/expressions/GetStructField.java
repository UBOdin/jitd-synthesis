package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns the value of fields in the Struct <code>child</code>.
 * <p>
 * No need to do type checking since it is handled by {@link ExtractValue}.
 * <p>
 * Note that we can pass in the field name directly to keep case preserving in <code>toString</code>.
 * For example, when get field <code>yEAr</code> from <code><year: int, month: int></code>, we should pass in <code>yEAr</code>.
 */
public  class GetStructField extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ExtractValue, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  int ordinal ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> name ()  { throw new RuntimeException(); }
  // not preceding
  public   GetStructField (org.apache.spark.sql.catalyst.expressions.Expression child, int ordinal, scala.Option<java.lang.String> name)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType childSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String extractFieldName ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
