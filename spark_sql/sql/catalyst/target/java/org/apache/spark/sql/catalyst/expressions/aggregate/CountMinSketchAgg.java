package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * This function returns a count-min sketch of a column with the given esp, confidence and seed.
 * A count-min sketch is a probabilistic data structure used for summarizing streams of data in
 * sub-linear space, which is useful for equality predicates and join size estimation.
 * The result returned by the function is an array of bytes, which should be deserialized to a
 * <code>CountMinSketch</code> before usage.
 * <p>
 * param:  child child expression that can produce column value with <code>child.eval(inputRow)</code>
 * param:  epsExpression relative error, must be positive
 * param:  confidenceExpression confidence, must be positive and less than 1.0
 * param:  seedExpression random seed
 */
public  class CountMinSketchAgg extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<org.apache.spark.util.sketch.CountMinSketch> implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression epsExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression confidenceExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression seedExpression ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   CountMinSketchAgg (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression epsExpression, org.apache.spark.sql.catalyst.expressions.Expression confidenceExpression, org.apache.spark.sql.catalyst.expressions.Expression seedExpression, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public   CountMinSketchAgg (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression epsExpression, org.apache.spark.sql.catalyst.expressions.Expression confidenceExpression, org.apache.spark.sql.catalyst.expressions.Expression seedExpression)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.sketch.CountMinSketch createAggregationBuffer ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.sketch.CountMinSketch update (org.apache.spark.util.sketch.CountMinSketch buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.util.sketch.CountMinSketch merge (org.apache.spark.util.sketch.CountMinSketch buffer, org.apache.spark.util.sketch.CountMinSketch input)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.util.sketch.CountMinSketch buffer)  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.spark.util.sketch.CountMinSketch buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.util.sketch.CountMinSketch deserialize (byte[] storageFormat)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.CountMinSketchAgg withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.CountMinSketchAgg withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
