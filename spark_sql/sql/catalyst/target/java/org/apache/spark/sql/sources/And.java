package org.apache.spark.sql.sources;
/**
 * A filter that evaluates to <code>true</code> iff both <code>left</code> or <code>right</code> evaluate to <code>true</code>.
 * <p>
 * @since 1.3.0
 */
public  class And extends org.apache.spark.sql.sources.Filter implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter right ()  { throw new RuntimeException(); }
  // not preceding
  public   And (org.apache.spark.sql.sources.Filter left, org.apache.spark.sql.sources.Filter right)  { throw new RuntimeException(); }
  public  java.lang.String[] references ()  { throw new RuntimeException(); }
}
