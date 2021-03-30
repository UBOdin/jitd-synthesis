package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that returns the <code>n</code>-th input in given inputs.
 * If all inputs are binary, <code>elt</code> returns an output as binary. Otherwise, it returns as string.
 * If any input is null, <code>elt</code> returns null.
 */
public  class Elt extends org.apache.spark.sql.catalyst.expressions.Expression implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean failOnError ()  { throw new RuntimeException(); }
  // not preceding
  public   Elt (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, boolean failOnError)  { throw new RuntimeException(); }
  public   Elt (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  /** This expression is always nullable because it returns null if index is out of range. */
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
