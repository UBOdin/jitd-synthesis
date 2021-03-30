package org.apache.spark.sql.execution.window;
/**
 * This class manages the processing of a number of aggregate functions. See the documentation of
 * the object for more information.
 */
 final class AggregateProcessor {
  static public  org.apache.spark.sql.execution.window.AggregateProcessor apply (org.apache.spark.sql.catalyst.expressions.Expression[] functions, int ordinal, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection)  { throw new RuntimeException(); }
  public   AggregateProcessor (org.apache.spark.sql.catalyst.expressions.AttributeReference[] bufferSchema, org.apache.spark.sql.catalyst.expressions.MutableProjection initialProjection, org.apache.spark.sql.catalyst.expressions.MutableProjection updateProjection, org.apache.spark.sql.catalyst.expressions.MutableProjection evaluateProjection, org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate[] imperatives, boolean trackPartitionSize)  { throw new RuntimeException(); }
  /** Create the initial state. */
  public  void initialize (int size)  { throw new RuntimeException(); }
  /** Update the buffer. */
  public  void update (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /** Evaluate buffer. */
  public  void evaluate (org.apache.spark.sql.catalyst.InternalRow target)  { throw new RuntimeException(); }
}
