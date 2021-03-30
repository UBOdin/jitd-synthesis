package org.apache.spark.sql.execution.stat;
public  class FrequentItems$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FrequentItems$ MODULE$ = null;
  public   FrequentItems$ ()  { throw new RuntimeException(); }
  /**
   * Finding frequent items for columns, possibly with false positives. Using the
   * frequent element count algorithm described in
   * <a href="https://doi.org/10.1145/762471.762473">here</a>, proposed by Karp, Schenker,
   * and Papadimitriou.
   * The <code>support</code> should be greater than 1e-4.
   * For Internal use only.
   * <p>
   * @param df The input DataFrame
   * @param cols the names of the columns to search frequent items in
   * @param support The minimum frequency for an item to be considered <code>frequent</code>. Should be greater
   *                than 1e-4.
   * @return A Local DataFrame with the Array of frequent items for each column.
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> singlePassFreqItems (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df, scala.collection.Seq<java.lang.String> cols, double support)  { throw new RuntimeException(); }
}
