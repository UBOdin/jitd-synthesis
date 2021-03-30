package org.apache.spark.sql.catalyst.expressions;
public  class TimeWindow extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.Unevaluable, org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.TimeWindow apply (org.apache.spark.sql.catalyst.expressions.Expression timeColumn, java.lang.String windowDuration, java.lang.String slideDuration, java.lang.String startTime)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression timeColumn ()  { throw new RuntimeException(); }
  public  long windowDuration ()  { throw new RuntimeException(); }
  public  long slideDuration ()  { throw new RuntimeException(); }
  public  long startTime ()  { throw new RuntimeException(); }
  // not preceding
  public   TimeWindow (org.apache.spark.sql.catalyst.expressions.Expression timeColumn, long windowDuration, long slideDuration, long startTime)  { throw new RuntimeException(); }
  public   TimeWindow (org.apache.spark.sql.catalyst.expressions.Expression timeColumn, org.apache.spark.sql.catalyst.expressions.Expression windowDuration, org.apache.spark.sql.catalyst.expressions.Expression slideDuration, org.apache.spark.sql.catalyst.expressions.Expression startTime)  { throw new RuntimeException(); }
  public   TimeWindow (org.apache.spark.sql.catalyst.expressions.Expression timeColumn, org.apache.spark.sql.catalyst.expressions.Expression windowDuration, org.apache.spark.sql.catalyst.expressions.Expression slideDuration)  { throw new RuntimeException(); }
  public   TimeWindow (org.apache.spark.sql.catalyst.expressions.Expression timeColumn, org.apache.spark.sql.catalyst.expressions.Expression windowDuration)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  /**
   * Validate the inputs for the window duration, slide duration, and start time in addition to
   * the input data type.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
}
