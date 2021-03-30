package org.apache.spark.sql.catalyst.plans.physical;
/**
 * IdentityBroadcastMode requires that rows are broadcasted in their original form.
 */
public  class IdentityBroadcastMode$ implements org.apache.spark.sql.catalyst.plans.physical.BroadcastMode, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final IdentityBroadcastMode$ MODULE$ = null;
  public   IdentityBroadcastMode$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] transform (org.apache.spark.sql.catalyst.InternalRow[] rows)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] transform (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> rows, scala.Option<java.lang.Object> sizeHint)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.BroadcastMode canonicalized ()  { throw new RuntimeException(); }
}
