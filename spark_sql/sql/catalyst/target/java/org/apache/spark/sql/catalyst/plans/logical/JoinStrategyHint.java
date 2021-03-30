package org.apache.spark.sql.catalyst.plans.logical;
public abstract class JoinStrategyHint {
  static public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.plans.logical.JoinStrategyHint> strategies ()  { throw new RuntimeException(); }
  public   JoinStrategyHint ()  { throw new RuntimeException(); }
  public abstract  java.lang.String displayName ()  ;
  public abstract  scala.collection.immutable.Set<java.lang.String> hintAliases ()  ;
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
