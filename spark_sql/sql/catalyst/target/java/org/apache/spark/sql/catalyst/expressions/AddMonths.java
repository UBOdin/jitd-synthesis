package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns the date that is num_months after start_date.
 */
public  class AddMonths extends org.apache.spark.sql.catalyst.expressions.AddMonthsBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression startDate ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression numMonths ()  { throw new RuntimeException(); }
  // not preceding
  public   AddMonths (org.apache.spark.sql.catalyst.expressions.Expression startDate, org.apache.spark.sql.catalyst.expressions.Expression numMonths)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
