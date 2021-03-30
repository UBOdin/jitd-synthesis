package org.apache.spark.sql.sources;
/**
 * A filter that evaluates to <code>true</code> iff the attribute evaluates to
 * a string that starts with <code>value</code>.
 * <p>
 * param:  attribute of the column to be evaluated; <code>dots</code> are used as separators
 *                  for nested columns. If any part of the names contains <code>dots</code>,
 *                  it is quoted to avoid confusion.
 * @since 1.3.1
 */
public  class StringStartsWith extends org.apache.spark.sql.sources.Filter implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String attribute ()  { throw new RuntimeException(); }
  public  java.lang.String value ()  { throw new RuntimeException(); }
  // not preceding
  public   StringStartsWith (java.lang.String attribute, java.lang.String value)  { throw new RuntimeException(); }
  public  java.lang.String[] references ()  { throw new RuntimeException(); }
}
