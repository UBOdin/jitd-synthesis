package org.apache.spark.sql.catalyst.expressions;
/**
 * A base class for generated/interpreted predicate
 */
public abstract class BasePredicate {
  public   BasePredicate ()  { throw new RuntimeException(); }
  public abstract  boolean eval (org.apache.spark.sql.catalyst.InternalRow r)  ;
  /**
   * Initializes internal states given the current partition index.
   * This is used by nondeterministic expressions to set initial states.
   * The default implementation does nothing.
   * @param partitionIndex (undocumented)
   */
  public  void initialize (int partitionIndex)  { throw new RuntimeException(); }
}
