package org.apache.spark.sql.sources;
/**
 * A filter that evaluates to <code>true</code> iff the column evaluates to a value
 * equal to <code>value</code>.
 * <p>
 * param:  attribute of the column to be evaluated; <code>dots</code> are used as separators
 *                  for nested columns. If any part of the names contains <code>dots</code>,
 *                  it is quoted to avoid confusion.
 * @since 1.3.0
 */
public  class EqualTo extends org.apache.spark.sql.sources.Filter implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String attribute ()  { throw new RuntimeException(); }
  public  Object value ()  { throw new RuntimeException(); }
  // not preceding
  public   EqualTo (java.lang.String attribute, Object value)  { throw new RuntimeException(); }
  public  java.lang.String[] references ()  { throw new RuntimeException(); }
}
