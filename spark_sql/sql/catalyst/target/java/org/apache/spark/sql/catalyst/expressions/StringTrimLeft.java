package org.apache.spark.sql.catalyst.expressions;
public  class StringTrimLeft extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.String2TrimExpression, scala.Product, scala.Serializable {
  // not preceding
  static public  org.apache.spark.sql.catalyst.expressions.StringTrimLeft apply (org.apache.spark.sql.catalyst.expressions.Expression str, org.apache.spark.sql.catalyst.expressions.Expression trimStr)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.StringTrimLeft apply (org.apache.spark.sql.catalyst.expressions.Expression str)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression srcStr ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> trimStr ()  { throw new RuntimeException(); }
  public   StringTrimLeft (org.apache.spark.sql.catalyst.expressions.Expression srcStr, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> trimStr)  { throw new RuntimeException(); }
  public   StringTrimLeft (org.apache.spark.sql.catalyst.expressions.Expression trimStr, org.apache.spark.sql.catalyst.expressions.Expression srcStr)  { throw new RuntimeException(); }
  public   StringTrimLeft (org.apache.spark.sql.catalyst.expressions.Expression srcStr)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  java.lang.String direction ()  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.UTF8String doEval (org.apache.spark.unsafe.types.UTF8String srcString)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.UTF8String doEval (org.apache.spark.unsafe.types.UTF8String srcString, org.apache.spark.unsafe.types.UTF8String trimString)  { throw new RuntimeException(); }
  public  java.lang.String trimMethod ()  { throw new RuntimeException(); }
}
