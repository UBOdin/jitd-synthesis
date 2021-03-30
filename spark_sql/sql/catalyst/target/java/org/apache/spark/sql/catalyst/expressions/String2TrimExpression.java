package org.apache.spark.sql.catalyst.expressions;
public  interface String2TrimExpression extends org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  ;
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  public  java.lang.String direction ()  ;
  public  org.apache.spark.unsafe.types.UTF8String doEval (org.apache.spark.unsafe.types.UTF8String srcString)  ;
  public  org.apache.spark.unsafe.types.UTF8String doEval (org.apache.spark.unsafe.types.UTF8String srcString, org.apache.spark.unsafe.types.UTF8String trimString)  ;
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  ;
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  public  boolean foldable ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  ;
  public  boolean nullable ()  ;
  public  java.lang.String sql ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression srcStr ()  ;
  public  java.lang.String trimMethod ()  ;
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> trimStr ()  ;
}
