package org.apache.spark.sql.catalyst.plans.logical;
public abstract class MergeAction extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable {
  public   MergeAction ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public abstract  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> condition ()  ;
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
}
