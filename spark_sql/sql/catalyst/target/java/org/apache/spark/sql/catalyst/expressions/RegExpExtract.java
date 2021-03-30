package org.apache.spark.sql.catalyst.expressions;
/**
 * Extract a specific(idx) group identified by a Java regex.
 * <p>
 * NOTE: this expression is not THREAD-SAFE, as it has some internal mutable status.
 */
public  class RegExpExtract extends org.apache.spark.sql.catalyst.expressions.RegExpExtractBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression subject ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression regexp ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression idx ()  { throw new RuntimeException(); }
  // not preceding
  public   RegExpExtract (org.apache.spark.sql.catalyst.expressions.Expression subject, org.apache.spark.sql.catalyst.expressions.Expression regexp, org.apache.spark.sql.catalyst.expressions.Expression idx)  { throw new RuntimeException(); }
  public   RegExpExtract (org.apache.spark.sql.catalyst.expressions.Expression s, org.apache.spark.sql.catalyst.expressions.Expression r)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object s, Object p, Object r)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
