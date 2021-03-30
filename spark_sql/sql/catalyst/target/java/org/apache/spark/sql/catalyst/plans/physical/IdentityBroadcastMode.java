package org.apache.spark.sql.catalyst.plans.physical;
/**
 * IdentityBroadcastMode requires that rows are broadcasted in their original form.
 */
public  class IdentityBroadcastMode {
  static public  org.apache.spark.sql.catalyst.InternalRow[] transform (org.apache.spark.sql.catalyst.InternalRow[] rows)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.InternalRow[] transform (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> rows, scala.Option<java.lang.Object> sizeHint)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.physical.BroadcastMode canonicalized ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
