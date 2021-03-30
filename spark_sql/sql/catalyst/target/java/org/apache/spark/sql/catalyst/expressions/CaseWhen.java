package org.apache.spark.sql.catalyst.expressions;
/**
 * Case statements of the form "CASE WHEN a THEN b [WHEN c THEN d]* [ELSE e] END".
 * When a = true, returns b; when c = true, returns d; else returns e.
 * <p>
 * param:  branches seq of (branch condition, branch value)
 * param:  elseValue optional value for the else branch
 */
public  class CaseWhen extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.ComplexTypeMergingExpression, scala.Serializable, scala.Product {
  /** Factory methods for CaseWhen. */
  static public  org.apache.spark.sql.catalyst.expressions.CaseWhen apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> branches, org.apache.spark.sql.catalyst.expressions.Expression elseValue)  { throw new RuntimeException(); }
  /**
   * A factory method to facilitate the creation of this expression when used in parsers.
   * <p>
   * @param branches Expressions at even position are the branch conditions, and expressions at odd
   *                 position are branch values.
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.CaseWhen createFromParser (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> branches)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> branches ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> elseValue ()  { throw new RuntimeException(); }
  // not preceding
  public   CaseWhen (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> branches, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> elseValue)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypesForMerging ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
