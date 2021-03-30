package org.apache.spark.sql.hive;
/**
 * While being evaluated by Spark SQL, the aggregation state of a Hive UDAF may be in the following
 * three formats:
 * <p>
 *  1. An instance of some concrete <code>GenericUDAFEvaluator.AggregationBuffer</code> class
 * <p>
 *     This is the native Hive representation of an aggregation state. Hive <code>GenericUDAFEvaluator</code>
 *     methods like <code>iterate()</code>, <code>merge()</code>, <code>terminatePartial()</code>, and <code>terminate()</code> use this format.
 *     We call these methods to evaluate Hive UDAFs.
 * <p>
 *  2. A Java object that can be inspected using the <code>ObjectInspector</code> returned by the
 *     <code>GenericUDAFEvaluator.init()</code> method.
 * <p>
 *     Hive uses this format to produce a serializable aggregation state so that it can shuffle
 *     partial aggregation results. Whenever we need to convert a Hive <code>AggregationBuffer</code> instance
 *     into a Spark SQL value, we have to convert it to this format first and then do the conversion
 *     with the help of <code>ObjectInspector</code>s.
 * <p>
 *  3. A Spark SQL value
 * <p>
 *     We use this format for serializing Hive UDAF aggregation states on Spark side. To be more
 *     specific, we convert <code>AggregationBuffer</code>s into equivalent Spark SQL values, write them into
 *     <code>UnsafeRow</code>s, and then retrieve the byte array behind those <code>UnsafeRow</code>s as serialization
 *     results.
 * <p>
 * We may use the following methods to convert the aggregation state back and forth:
 * <p>
 *  - <code>wrap()</code>/<code>wrapperFor()</code>: from 3 to 1
 *  - <code>unwrap()</code>/<code>unwrapperFor()</code>: from 1 to 3
 *  - <code>GenericUDAFEvaluator.terminatePartial()</code>: from 2 to 3
 * <p>
 *  Note that, Hive UDAF is initialized with aggregate mode, and some specific Hive UDAFs can't
 *  mix UPDATE and MERGE actions during its life cycle. However, Spark may do UPDATE on a UDAF and
 *  then do MERGE, in case of hash aggregate falling back to sort aggregate. To work around this
 *  issue, we track the ability to do MERGE in the Hive UDAF aggregate buffer. If Spark does
 *  UPDATE then MERGE, we can detect it and re-create the aggregate buffer with a different
 *  aggregate mode.
 */
  class HiveUDAFFunction extends org.apache.spark.sql.catalyst.expressions.aggregate.TypedImperativeAggregate<org.apache.spark.sql.hive.HiveUDAFBuffer> implements org.apache.spark.sql.hive.HiveInspectors, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean isUDAFBridgeRequired ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveUDAFFunction (java.lang.String name, org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, boolean isUDAFBridgeRequired, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String sql (boolean isDistinct)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveUDAFBuffer createAggregationBuffer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveUDAFBuffer update (org.apache.spark.sql.hive.HiveUDAFBuffer buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveUDAFBuffer merge (org.apache.spark.sql.hive.HiveUDAFBuffer buffer, org.apache.spark.sql.hive.HiveUDAFBuffer input)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.hive.HiveUDAFBuffer buffer)  { throw new RuntimeException(); }
  public  byte[] serialize (org.apache.spark.sql.hive.HiveUDAFBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveUDAFBuffer deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
