package org.apache.spark.sql.catalyst.expressions;
public  interface TimestampFormatterHelper extends org.apache.spark.sql.catalyst.expressions.TimeZoneAwareExpression {
  public  org.apache.spark.sql.catalyst.expressions.Expression formatString ()  ;
  public  scala.Option<org.apache.spark.sql.catalyst.util.TimestampFormatter> formatterOption ()  ;
  public  org.apache.spark.sql.catalyst.util.TimestampFormatter getFormatter (java.lang.String fmt)  ;
  public  boolean isParsing ()  ;
}
