package org.apache.spark.sql.catalyst.expressions;
/**
 * A globally unique id for a given named expression.
 * Used to identify which attribute output by a relation is being
 * referenced in a subsequent computation.
 * <p>
 * The <code>id</code> field is unique within a given JVM, while the <code>uuid</code> is used to uniquely identify JVMs.
 */
public  class ExprId implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.ExprId apply (long id)  { throw new RuntimeException(); }
  public  long id ()  { throw new RuntimeException(); }
  public  java.util.UUID jvmId ()  { throw new RuntimeException(); }
  // not preceding
  public   ExprId (long id, java.util.UUID jvmId)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
}
