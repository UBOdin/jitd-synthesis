package org.apache.spark.sql.execution.joins;
/** The HashedRelationBroadcastMode requires that rows are broadcasted as a HashedRelation. */
public  class HashedRelationBroadcastMode implements org.apache.spark.sql.catalyst.plans.physical.BroadcastMode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> key ()  { throw new RuntimeException(); }
  public  boolean isNullAware ()  { throw new RuntimeException(); }
  // not preceding
  public   HashedRelationBroadcastMode (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> key, boolean isNullAware)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.HashedRelation transform (org.apache.spark.sql.catalyst.InternalRow[] rows)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.HashedRelation transform (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> rows, scala.Option<java.lang.Object> sizeHint)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.joins.HashedRelationBroadcastMode canonicalized ()  { throw new RuntimeException(); }
}
