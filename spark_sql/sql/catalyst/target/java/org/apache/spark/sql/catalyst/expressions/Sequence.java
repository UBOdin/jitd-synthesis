package org.apache.spark.sql.catalyst.expressions;
public  class Sequence extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression, scala.Product, scala.Serializable {
  static public  interface SequenceImpl {
    public  org.apache.spark.sql.catalyst.expressions.Sequence.DefaultStep defaultStep ()  ;
    public  Object eval (Object start, Object stop, Object step)  ;
    public  java.lang.String genCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String start, java.lang.String stop, java.lang.String step, java.lang.String arr, java.lang.String elemType)  ;
  }
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.time.ZoneId zoneId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression start ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression stop ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> stepOpt ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> timeZoneId ()  { throw new RuntimeException(); }
  // not preceding
  public   Sequence (org.apache.spark.sql.catalyst.expressions.Expression start, org.apache.spark.sql.catalyst.expressions.Expression stop, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> stepOpt, scala.Option<java.lang.String> timeZoneId)  { throw new RuntimeException(); }
  public   Sequence (org.apache.spark.sql.catalyst.expressions.Expression start, org.apache.spark.sql.catalyst.expressions.Expression stop)  { throw new RuntimeException(); }
  public   Sequence (org.apache.spark.sql.catalyst.expressions.Expression start, org.apache.spark.sql.catalyst.expressions.Expression stop, org.apache.spark.sql.catalyst.expressions.Expression step)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression withTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.ArrayType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> coercibleChildren ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression castChildrenTo (org.apache.spark.sql.types.DataType widerType)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
