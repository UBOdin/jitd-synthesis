package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * HyperLogLog++ (HLL++) is a state of the art cardinality estimation algorithm. This class
 * implements the dense version of the HLL++ algorithm as an Aggregate Function.
 * <p>
 * This implementation has been based on the following papers:
 * HyperLogLog: the analysis of a near-optimal cardinality estimation algorithm
 * http://algo.inria.fr/flajolet/Publications/FlFuGaMe07.pdf
 * <p>
 * HyperLogLog in Practice: Algorithmic Engineering of a State of The Art Cardinality Estimation
 * Algorithm
 * http://static.googleusercontent.com/external_content/untrusted_dlcp/research.google.com/en/us/pubs/archive/40671.pdf
 * <p>
 * Appendix to HyperLogLog in Practice: Algorithmic Engineering of a State of the Art Cardinality
 * Estimation Algorithm
 * https://docs.google.com/document/d/1gyjfMHy43U9OWBXxfaeG-3MjGzejW1dlpyMwEYAAWEI/view?fullscreen#
 * <p>
 * param:  child to estimate the cardinality of.
 * param:  relativeSD the maximum relative standard deviation allowed.
 */
public  class HyperLogLogPlusPlus extends org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate implements scala.Product, scala.Serializable {
  static public  double validateDoubleLiteral (org.apache.spark.sql.catalyst.expressions.Expression exp)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  double relativeSD ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   HyperLogLogPlusPlus (org.apache.spark.sql.catalyst.expressions.Expression child, double relativeSD, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public   HyperLogLogPlusPlus (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   HyperLogLogPlusPlus (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression relativeSD)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType aggBufferSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.HyperLogLogPlusPlusHelper hllppHelper ()  { throw new RuntimeException(); }
  /** Allocate enough words to store all registers. */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> inputAggBufferAttributes ()  { throw new RuntimeException(); }
  /** Fill all words with zeros. */
  public  void initialize (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  /**
   * Update the HLL++ buffer.
   * @param buffer (undocumented)
   * @param input (undocumented)
   */
  public  void update (org.apache.spark.sql.catalyst.InternalRow buffer, org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /**
   * Merge the HLL++ buffers.
   * @param buffer1 (undocumented)
   * @param buffer2 (undocumented)
   */
  public  void merge (org.apache.spark.sql.catalyst.InternalRow buffer1, org.apache.spark.sql.catalyst.InternalRow buffer2)  { throw new RuntimeException(); }
  /**
   * Compute the HyperLogLog estimate.
   * @param buffer (undocumented)
   * @return (undocumented)
   */
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
}
