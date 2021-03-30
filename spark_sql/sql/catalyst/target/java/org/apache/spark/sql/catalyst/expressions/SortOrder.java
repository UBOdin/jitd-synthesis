package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that can be used to sort a tuple.  This class extends expression primarily so that
 * transformations over expression will descend into its child.
 * <code>sameOrderExpressions</code> is a set of expressions with the same sort order as the child. It is
 * derived from equivalence relation in an operator, e.g. left/right keys of an inner sort merge
 * join.
 */
public  class SortOrder extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.SortOrder apply (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.SortDirection direction, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> sameOrderExpressions)  { throw new RuntimeException(); }
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
  static public  boolean orderingSatisfies (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering1, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SortDirection direction ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NullOrdering nullOrdering ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> sameOrderExpressions ()  { throw new RuntimeException(); }
  // not preceding
  public   SortOrder (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.SortDirection direction, org.apache.spark.sql.catalyst.expressions.NullOrdering nullOrdering, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> sameOrderExpressions)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  boolean isAscending ()  { throw new RuntimeException(); }
  public  boolean satisfies (org.apache.spark.sql.catalyst.expressions.SortOrder required)  { throw new RuntimeException(); }
}
