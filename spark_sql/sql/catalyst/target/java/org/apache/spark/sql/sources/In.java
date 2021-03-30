package org.apache.spark.sql.sources;
/**
 * A filter that evaluates to <code>true</code> iff the attribute evaluates to one of the values in the array.
 * <p>
 * param:  attribute of the column to be evaluated; <code>dots</code> are used as separators
 *                  for nested columns. If any part of the names contains <code>dots</code>,
 *                  it is quoted to avoid confusion.
 * @since 1.3.0
 */
public  class In extends org.apache.spark.sql.sources.Filter implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  java.lang.String attribute ()  { throw new RuntimeException(); }
  public  java.lang.Object[] values ()  { throw new RuntimeException(); }
  // not preceding
  public   In (java.lang.String attribute, java.lang.Object[] values)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object o)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String[] references ()  { throw new RuntimeException(); }
}
