package org.apache.spark.sql.catalyst.planning;
public  class ExtractSingleColumnNullAwareAntiJoin$ implements org.apache.spark.sql.catalyst.optimizer.JoinSelectionHelper, org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExtractSingleColumnNullAwareAntiJoin$ MODULE$ = null;
  public   ExtractSingleColumnNullAwareAntiJoin$ ()  { throw new RuntimeException(); }
  /**
   * See. [SPARK-32290]
   * LeftAnti(condition: Or(EqualTo(a=b), IsNull(EqualTo(a=b)))
   * will almost certainly be planned as a Broadcast Nested Loop join,
   * which is very time consuming because it's an O(M*N) calculation.
   * But if it's a single column case O(M*N) calculation could be optimized into O(M)
   * using hash lookup instead of loop lookup.
   * @param join (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<scala.Tuple2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>>> unapply (org.apache.spark.sql.catalyst.plans.logical.Join join)  { throw new RuntimeException(); }
}
