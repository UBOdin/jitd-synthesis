package org.apache.spark.sql.catalyst.expressions;
/**
 * A trait that gets mixin to define the expected input types of an expression.
 * <p>
 * This trait is typically used by operator expressions (e.g. {@link Add}, {@link Subtract}) to define
 * expected input types without any implicit casting.
 * <p>
 * Most function expressions (e.g. {@link Substring} should extend {@link ImplicitCastInputTypes}) instead.
 */
public  interface ExpectsInputTypes {
  /**
   * Expected input types from child expressions. The i-th position in the returned seq indicates
   * the type requirement for the i-th child.
   * <p>
   * The possible values at each position are:
   * 1. a specific data type, e.g. LongType, StringType.
   * 2. a non-leaf abstract data type, e.g. NumericType, IntegralType, FractionalType.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  ;
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  ;
}
