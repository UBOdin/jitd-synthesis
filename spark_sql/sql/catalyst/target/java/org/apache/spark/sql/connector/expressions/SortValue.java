package org.apache.spark.sql.connector.expressions;
 final class SortValue implements org.apache.spark.sql.connector.expressions.SortOrder, scala.Product, scala.Serializable {
  static public  scala.Option<scala.Tuple3<org.apache.spark.sql.connector.expressions.Expression, org.apache.spark.sql.connector.expressions.SortDirection, org.apache.spark.sql.connector.expressions.NullOrdering>> unapply (org.apache.spark.sql.connector.expressions.Expression expr)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Expression expression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.SortDirection direction ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.NullOrdering nullOrdering ()  { throw new RuntimeException(); }
  // not preceding
  public   SortValue (org.apache.spark.sql.connector.expressions.Expression expression, org.apache.spark.sql.connector.expressions.SortDirection direction, org.apache.spark.sql.connector.expressions.NullOrdering nullOrdering)  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
}
