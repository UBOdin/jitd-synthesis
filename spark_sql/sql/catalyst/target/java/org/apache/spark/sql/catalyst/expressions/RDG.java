package org.apache.spark.sql.catalyst.expressions;
/**
 * A Random distribution generating expression.
 * TODO: This can be made generic to generate any type of random distribution, or any type of
 * StructType.
 * <p>
 * Since this expression is stateful, it cannot be a case object.
 */
public abstract class RDG extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.Stateful, org.apache.spark.sql.catalyst.expressions.ExpressionWithRandomSeed {
  public   RDG ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public final  boolean deterministic ()  { throw new RuntimeException(); }
  protected  void initializeInternal (int partitionIndex)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  /**
   * Record ID within each partition. By being transient, the Random Number Generator is
   * reset every time we serialize and deserialize and initialize it.
   * @return (undocumented)
   */
  protected  org.apache.spark.util.random.XORShiftRandom rng ()  { throw new RuntimeException(); }
  // not preceding
  protected  long seed ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression seedExpression ()  { throw new RuntimeException(); }
}
