package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The hint for broadcast hash join or broadcast nested loop join, depending on the availability of
 * equi-join keys.
 */
public  class BROADCAST {
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
