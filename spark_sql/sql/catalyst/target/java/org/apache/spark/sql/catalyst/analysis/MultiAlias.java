package org.apache.spark.sql.catalyst.analysis;
/**
 * Used to assign new names to Generator's output, such as hive udtf.
 * For example the SQL expression "stack(2, key, value, key, value) as (a, b)" could be represented
 * as follows:
 *  MultiAlias(stack_function, Seq(a, b))
 * <p>
 * param:  child the computation being performed
 * param:  names the names to be associated with each output of computing {@link child}.
 */
public  class MultiAlias extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NamedExpression, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> names ()  { throw new RuntimeException(); }
  // not preceding
  public   MultiAlias (org.apache.spark.sql.catalyst.expressions.Expression child, scala.collection.Seq<java.lang.String> names)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression newInstance ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
