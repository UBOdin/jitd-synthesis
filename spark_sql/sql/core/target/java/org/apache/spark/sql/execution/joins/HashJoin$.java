package org.apache.spark.sql.execution.joins;
public  class HashJoin$ implements org.apache.spark.sql.catalyst.analysis.CastSupport, org.apache.spark.sql.catalyst.SQLConfHelper, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HashJoin$ MODULE$ = null;
  public   HashJoin$ ()  { throw new RuntimeException(); }
  /**
   * Try to rewrite the key as LongType so we can use getLong(), if they key can fit with a long.
   * <p>
   * If not, returns the original expressions.
   * @param keys (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rewriteKeyExpr (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> keys)  { throw new RuntimeException(); }
  /**
   * Extract a given key which was previously packed in a long value using its index to
   * determine the number of bits to shift
   * @param keys (undocumented)
   * @param index (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression extractKeyExprAt (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> keys, int index)  { throw new RuntimeException(); }
}
