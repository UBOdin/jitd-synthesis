package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Returns the value of field at index <code>index</code> from the external row <code>child</code>.
 * This class can be viewed as {@link GetStructField} for {@link Row}s instead of {@link InternalRow}s.
 * <p>
 * Note that the input row and the field we try to get are both guaranteed to be not null, if they
 * are null, a runtime exception will be thrown.
 */
public  class GetExternalRowField extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  int index ()  { throw new RuntimeException(); }
  public  java.lang.String fieldName ()  { throw new RuntimeException(); }
  // not preceding
  public   GetExternalRowField (org.apache.spark.sql.catalyst.expressions.Expression child, int index, java.lang.String fieldName)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
