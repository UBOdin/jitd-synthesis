package org.apache.spark.sql.catalyst.expressions;
/**
 * The factory object for <code>BasePredicate</code>.
 */
public  class Predicate$ extends org.apache.spark.sql.catalyst.expressions.CodeGeneratorWithInterpretedFallback<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.BasePredicate> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Predicate$ MODULE$ = null;
  public   Predicate$ ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BasePredicate createCodeGeneratedObject (org.apache.spark.sql.catalyst.expressions.Expression in)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BasePredicate createInterpretedObject (org.apache.spark.sql.catalyst.expressions.Expression in)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.InterpretedPredicate createInterpreted (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns a BasePredicate for an Expression, which will be bound to <code>inputSchema</code>.
   * @param e (undocumented)
   * @param inputSchema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.BasePredicate create (org.apache.spark.sql.catalyst.expressions.Expression e, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  /**
   * Returns a BasePredicate for a given bound Expression.
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.BasePredicate create (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
}
