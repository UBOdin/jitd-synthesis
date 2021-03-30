package org.apache.spark.sql.execution.joins;
/**
 * param:  relationTerm variable name for HashedRelation
 * param:  keyIsUnique  indicate whether keys of HashedRelation known to be unique in code-gen time
 * param:  isEmpty indicate whether it known to be EmptyHashedRelation in code-gen time
 */
  class HashedRelationInfo implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String relationTerm ()  { throw new RuntimeException(); }
  public  boolean keyIsUnique ()  { throw new RuntimeException(); }
  public  boolean isEmpty ()  { throw new RuntimeException(); }
  // not preceding
  public   HashedRelationInfo (java.lang.String relationTerm, boolean keyIsUnique, boolean isEmpty)  { throw new RuntimeException(); }
}
