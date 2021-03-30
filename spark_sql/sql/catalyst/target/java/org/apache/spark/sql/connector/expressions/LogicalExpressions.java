package org.apache.spark.sql.connector.expressions;
/**
 * Helper methods for working with the logical expressions API.
 * <p>
 * Factory methods can be used when referencing the logical expression nodes is ambiguous because
 * logical and internal expressions are used.
 */
public  class LogicalExpressions {
  static public <T extends java.lang.Object> org.apache.spark.sql.connector.expressions.LiteralValue<T> literal (T value)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.connector.expressions.LiteralValue<T> literal (T value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.NamedReference parseReference (java.lang.String name)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.NamedReference reference (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.Transform apply (java.lang.String name, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Expression> arguments)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.BucketTransform bucket (int numBuckets, org.apache.spark.sql.connector.expressions.NamedReference[] references)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.IdentityTransform identity (org.apache.spark.sql.connector.expressions.NamedReference reference)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.YearsTransform years (org.apache.spark.sql.connector.expressions.NamedReference reference)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.MonthsTransform months (org.apache.spark.sql.connector.expressions.NamedReference reference)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.DaysTransform days (org.apache.spark.sql.connector.expressions.NamedReference reference)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.HoursTransform hours (org.apache.spark.sql.connector.expressions.NamedReference reference)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.expressions.SortOrder sort (org.apache.spark.sql.connector.expressions.Expression reference, org.apache.spark.sql.connector.expressions.SortDirection direction, org.apache.spark.sql.connector.expressions.NullOrdering nullOrdering)  { throw new RuntimeException(); }
}
