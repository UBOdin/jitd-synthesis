package org.apache.spark.sql.execution;
public  interface GeneratePredicateHelper extends org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  public  java.lang.String generatePredicateCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.Expression condition, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttrs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> inputExprCode)  ;
  public  java.lang.String generatePredicateCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttrs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> inputExprCode, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputAttrs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> notNullPreds, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> otherPreds, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.ExprId> nonNullAttrExprIds)  ;
}