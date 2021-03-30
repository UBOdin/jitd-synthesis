package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Converts the result of evaluating <code>child</code> into an option, checking both the isNull bit and
 * (in the case of reference types) equality with null.
 * <p>
 * param:  child The expression to evaluate and wrap.
 * param:  optType The type of this option.
 */
public  class WrapOption extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType optType ()  { throw new RuntimeException(); }
  // not preceding
  public   WrapOption (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType optType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
