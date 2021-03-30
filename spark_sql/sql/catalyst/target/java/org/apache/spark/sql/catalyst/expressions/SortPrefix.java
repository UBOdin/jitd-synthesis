package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression to generate a 64-bit long prefix used in sorting. If the sort must operate over
 * null keys as well, this.nullValue can be used in place of emitted null prefixes in the sort.
 */
public  class SortPrefix extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SortOrder child ()  { throw new RuntimeException(); }
  // not preceding
  public   SortPrefix (org.apache.spark.sql.catalyst.expressions.SortOrder child)  { throw new RuntimeException(); }
  public  long nullValue ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
}
