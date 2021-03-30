package org.apache.spark.sql.catalyst.trees;
/**
 * Provides a location for TreeNodes to ask about the context of their origin.  For example, which
 * line of code is currently being parsed.
 */
public  class CurrentOrigin$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CurrentOrigin$ MODULE$ = null;
  public   CurrentOrigin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.Origin get ()  { throw new RuntimeException(); }
  public  void set (org.apache.spark.sql.catalyst.trees.Origin o)  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  void setPosition (int line, int start)  { throw new RuntimeException(); }
  public <A extends java.lang.Object> A withOrigin (org.apache.spark.sql.catalyst.trees.Origin o, scala.Function0<A> f)  { throw new RuntimeException(); }
}
