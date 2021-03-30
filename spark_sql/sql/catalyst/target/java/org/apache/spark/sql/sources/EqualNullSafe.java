package org.apache.spark.sql.sources;
/**
 * Performs equality comparison, similar to {@link EqualTo}. However, this differs from {@link EqualTo}
 * in that it returns <code>true</code> (rather than NULL) if both inputs are NULL, and <code>false</code>
 * (rather than NULL) if one of the input is NULL and the other is not NULL.
 * <p>
 * param:  attribute of the column to be evaluated; <code>dots</code> are used as separators
 *                  for nested columns. If any part of the names contains <code>dots</code>,
 *                  it is quoted to avoid confusion.
 * @since 1.5.0
 */
public  class EqualNullSafe extends org.apache.spark.sql.sources.Filter implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String attribute ()  { throw new RuntimeException(); }
  public  Object value ()  { throw new RuntimeException(); }
  // not preceding
  public   EqualNullSafe (java.lang.String attribute, Object value)  { throw new RuntimeException(); }
  public  java.lang.String[] references ()  { throw new RuntimeException(); }
}
