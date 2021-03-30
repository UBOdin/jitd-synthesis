package org.apache.spark.sql.catalyst.plans.logical;
public  interface BaseEvalPython {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resultAttrs ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.PythonUDF> udfs ()  ;
}
