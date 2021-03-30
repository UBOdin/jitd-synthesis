package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Marker trait to identify the shape in which tuples are broadcasted. Typical examples of this are
 * identity (tuples remain unchanged) or hashed (tuples are converted into some hash index).
 */
public  interface BroadcastMode {
  public  org.apache.spark.sql.catalyst.plans.physical.BroadcastMode canonicalized ()  ;
  public  Object transform (org.apache.spark.sql.catalyst.InternalRow[] rows)  ;
  public  Object transform (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> rows, scala.Option<java.lang.Object> sizeHint)  ;
}
