package org.apache.spark.sql.catalyst.expressions;
public  class SortOrder$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SortOrder$ MODULE$ = null;
  public   SortOrder$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SortOrder apply (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.SortDirection direction, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> sameOrderExpressions)  { throw new RuntimeException(); }
  /**
   * Returns if a sequence of SortOrder satisfies another sequence of SortOrder.
   * <p>
   * SortOrder sequence A satisfies SortOrder sequence B if and only if B is an equivalent of A
   * or of A's prefix. Here are examples of ordering A satisfying ordering B:
   * <ul>
   *   <li>ordering A is [x, y] and ordering B is [x]</li>
   *   <li>ordering A is [x(sameOrderExpressions=x1)] and ordering B is [x1]</li>
   *   <li>ordering A is [x(sameOrderExpressions=x1), y] and ordering B is [x1]</li>
   * </ul>
   * @param ordering1 (undocumented)
   * @param ordering2 (undocumented)
   * @return (undocumented)
   */
  public  boolean orderingSatisfies (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering1, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering2)  { throw new RuntimeException(); }
}
