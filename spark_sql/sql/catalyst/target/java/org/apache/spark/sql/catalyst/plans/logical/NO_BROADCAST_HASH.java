package org.apache.spark.sql.catalyst.plans.logical;
/**
 * An internal hint to discourage broadcast hash join, used by adaptive query execution.
 */
public  class NO_BROADCAST_HASH {
  static public  java.lang.String displayName ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<java.lang.String> hintAliases ()  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
