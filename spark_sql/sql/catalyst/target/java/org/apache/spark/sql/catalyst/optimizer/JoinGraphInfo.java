package org.apache.spark.sql.catalyst.optimizer;
/**
 * Helper class that keeps information about the join graph as sets of item/plan ids.
 * It currently stores the star/non-star plans. It can be
 * extended with the set of connected/unconnected plans.
 */
public  class JoinGraphInfo implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.Object> starJoins ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.Object> nonStarJoins ()  { throw new RuntimeException(); }
  // not preceding
  public   JoinGraphInfo (scala.collection.immutable.Set<java.lang.Object> starJoins, scala.collection.immutable.Set<java.lang.Object> nonStarJoins)  { throw new RuntimeException(); }
}
