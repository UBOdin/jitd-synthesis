package org.apache.spark.sql.catalyst.expressions;
/**
 * Given an input array produces a sequence of rows for each position and value in the array.
 * <p>
 * <pre><code>
 *   SELECT posexplode(array(10,20)) -&gt;
 *   0  10
 *   1  20
 * </code></pre>
 */
public  class PosExplode extends org.apache.spark.sql.catalyst.expressions.ExplodeBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   PosExplode (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  boolean position ()  { throw new RuntimeException(); }
}
