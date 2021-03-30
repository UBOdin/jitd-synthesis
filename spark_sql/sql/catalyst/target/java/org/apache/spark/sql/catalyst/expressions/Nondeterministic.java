package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that is nondeterministic.
 */
public  interface Nondeterministic {
  public  boolean deterministic ()  ;
  /**
   * @inheritdoc
   * Throws an exception if {@link initialize()} is not called yet.
   * Subclasses should override {@link evalInternal()}.
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  public  Object evalInternal (org.apache.spark.sql.catalyst.InternalRow input)  ;
  public  boolean foldable ()  ;
  /**
   * Initializes internal states given the current partition index and mark this as initialized.
   * Subclasses should override {@link initializeInternal()}.
   * @param partitionIndex (undocumented)
   */
  public  void initialize (int partitionIndex)  ;
  public  void initializeInternal (int partitionIndex)  ;
}
