package org.apache.spark.sql.catalyst.expressions;
public  class PythonUDF extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, org.apache.spark.sql.catalyst.expressions.NonSQLExpression, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, scala.Product, scala.Serializable {
  // not preceding
  static public  boolean isScalarPythonUDF (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static public  boolean isGroupedAggPandasUDF (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static public  boolean isWindowPandasUDF (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.python.PythonFunction func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  int evalType ()  { throw new RuntimeException(); }
  public  boolean udfDeterministic ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId resultId ()  { throw new RuntimeException(); }
  public   PythonUDF (java.lang.String name, org.apache.spark.api.python.PythonFunction func, org.apache.spark.sql.types.DataType dataType, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, int evalType, boolean udfDeterministic, org.apache.spark.sql.catalyst.expressions.ExprId resultId)  { throw new RuntimeException(); }
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Attribute resultAttribute ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
}
