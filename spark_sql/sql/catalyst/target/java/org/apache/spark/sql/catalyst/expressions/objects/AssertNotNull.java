package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Asserts that input values of a non-nullable child expression are not null.
 * <p>
 * Note that there are cases where <code>child.nullable == true</code>, while we still need to add this
 * assertion.  Consider a nullable column <code>s</code> whose data type is a struct containing a non-nullable
 * <code>Int</code> field named <code>i</code>.  Expression <code>s.i</code> is nullable because <code>s</code> can be null.  However, for all
 * non-null <code>s</code>, <code>s.i</code> can't be null.
 */
public  class AssertNotNull extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> walkedTypePath ()  { throw new RuntimeException(); }
  // not preceding
  public   AssertNotNull (org.apache.spark.sql.catalyst.expressions.Expression child, scala.collection.Seq<java.lang.String> walkedTypePath)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
