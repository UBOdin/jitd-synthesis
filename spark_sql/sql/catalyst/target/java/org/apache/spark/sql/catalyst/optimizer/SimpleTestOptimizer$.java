package org.apache.spark.sql.catalyst.optimizer;
/**
 * An optimizer used in test code.
 * <p>
 * To ensure extendability, we leave the standard rules in the abstract optimizer rules, while
 * specific rules go to the subclasses
 */
public  class SimpleTestOptimizer$ extends org.apache.spark.sql.catalyst.optimizer.SimpleTestOptimizer {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SimpleTestOptimizer$ MODULE$ = null;
  public   SimpleTestOptimizer$ ()  { throw new RuntimeException(); }
}
