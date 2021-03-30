package org.apache.spark.sql.expressions;
/**
 * A base class for user-defined aggregations, which can be used in <code>Dataset</code> operations to take
 * all of the elements of a group and reduce them to a single value.
 * <p>
 * For example, the following aggregator extracts an <code>int</code> from a specific class and adds them up:
 * <pre><code>
 *   case class Data(i: Int)
 *
 *   val customSummer =  new Aggregator[Data, Int, Int] {
 *     def zero: Int = 0
 *     def reduce(b: Int, a: Data): Int = b + a.i
 *     def merge(b1: Int, b2: Int): Int = b1 + b2
 *     def finish(r: Int): Int = r
 *     def bufferEncoder: Encoder[Int] = Encoders.scalaInt
 *     def outputEncoder: Encoder[Int] = Encoders.scalaInt
 *   }.toColumn()
 *
 *   val ds: Dataset[Data] = ...
 *   val aggregated = ds.select(customSummer)
 * </code></pre>
 * <p>
 * Based loosely on Aggregator from Algebird: https://github.com/twitter/algebird
 * <p>
 * @param <IN>  The input type for the aggregation.
 * @param <BUF>  The type of the intermediate value of the reduction.
 * @param <OUT>  The type of the final output result.
 * @since 1.6.0
 */
public abstract class Aggregator<IN extends java.lang.Object, BUF extends java.lang.Object, OUT extends java.lang.Object> implements scala.Serializable {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   Aggregator ()  { throw new RuntimeException(); }
  /**
   * Specifies the <code>Encoder</code> for the intermediate value type.
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Encoder<BUF> bufferEncoder ()  ;
  /**
   * Transform the output of the reduction.
   * @since 1.6.0
   * @param reduction (undocumented)
   * @return (undocumented)
   */
  public abstract  OUT finish (BUF reduction)  ;
  /**
   * Merge two intermediate values.
   * @since 1.6.0
   * @param b1 (undocumented)
   * @param b2 (undocumented)
   * @return (undocumented)
   */
  public abstract  BUF merge (BUF b1, BUF b2)  ;
  /**
   * Specifies the <code>Encoder</code> for the final output value type.
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Encoder<OUT> outputEncoder ()  ;
  /**
   * Combine two values to produce a new value.  For performance, the function may modify <code>b</code> and
   * return it instead of constructing new object for b.
   * @since 1.6.0
   * @param b (undocumented)
   * @param a (undocumented)
   * @return (undocumented)
   */
  public abstract  BUF reduce (BUF b, IN a)  ;
  /**
   * Returns this <code>Aggregator</code> as a <code>TypedColumn</code> that can be used in <code>Dataset</code>.
   * operations.
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.TypedColumn<IN, OUT> toColumn ()  { throw new RuntimeException(); }
  /**
   * A zero value for this aggregation. Should satisfy the property that any b + zero = b.
   * @since 1.6.0
   * @return (undocumented)
   */
  public abstract  BUF zero ()  ;
}
