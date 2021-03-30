package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * A central moment is the expected value of a specified power of the deviation of a random
 * variable from the mean. Central moments are often used to characterize the properties of about
 * the shape of a distribution.
 * <p>
 * This class implements online, one-pass algorithms for computing the central moments of a set of
 * points.
 * <p>
 * Behavior:
 *  - null values are ignored
 *  - returns <code>Double.NaN</code> when the column contains <code>Double.NaN</code> values
 * <p>
 * References:
 *  - Xiangrui Meng.  "Simpler Online Updates for Arbitrary-Order Central Moments."
 *      2015. http://arxiv.org/abs/1510.04923
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance">
 * Algorithms for calculating variance (Wikipedia)</a>
 * <p>
 * param:  child to compute central moments of.
 */
public abstract class CentralMomentAgg extends org.apache.spark.sql.catalyst.expressions.aggregate.DeclarativeAggregate implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes {
  public   CentralMomentAgg (org.apache.spark.sql.catalyst.expressions.Expression child, boolean nullOnDivideByZero)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference avg ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression divideByZeroEvalResult ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference m2 ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference m3 ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference m4 ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> mergeExpressions ()  { throw new RuntimeException(); }
  /**
   * The central moment order to be computed.
   * @return (undocumented)
   */
  protected abstract  int momentOrder ()  ;
  protected  org.apache.spark.sql.catalyst.expressions.AttributeReference n ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressionsDef ()  { throw new RuntimeException(); }
}
