package org.apache.spark.sql.catalyst.expressions;
/** Factory methods for CaseWhen. */
public  class CaseWhen$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CaseWhen$ MODULE$ = null;
  public   CaseWhen$ ()  { throw new RuntimeException(); }
  /** Factory methods for CaseWhen. */
  public  org.apache.spark.sql.catalyst.expressions.CaseWhen apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression>> branches, org.apache.spark.sql.catalyst.expressions.Expression elseValue)  { throw new RuntimeException(); }
  /**
   * A factory method to facilitate the creation of this expression when used in parsers.
   * <p>
   * @param branches Expressions at even position are the branch conditions, and expressions at odd
   *                 position are branch values.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.CaseWhen createFromParser (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> branches)  { throw new RuntimeException(); }
}
