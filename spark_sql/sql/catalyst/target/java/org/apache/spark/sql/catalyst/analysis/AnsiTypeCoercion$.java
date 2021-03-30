package org.apache.spark.sql.catalyst.analysis;
/**
 * In Spark ANSI mode, the type coercion rules are based on the type precedence lists of the input
 * data types.
 * As per the section "Type precedence list determination" of "ISO/IEC 9075-2:2011
 * Information technology - Database languages - SQL - Part 2: Foundation (SQL/Foundation)",
 * the type precedence lists of primitive data types are as following:
 *   * Byte: Byte, Short, Int, Long, Decimal, Float, Double
 *   * Short: Short, Int, Long, Decimal, Float, Double
 *   * Int: Int, Long, Decimal, Float, Double
 *   * Long: Long, Decimal, Float, Double
 *   * Decimal: Float, Double, or any wider Numeric type
 *   * Float: Float, Double
 *   * Double: Double
 *   * String: String
 *   * Date: Date, Timestamp
 *   * Timestamp: Timestamp
 *   * Binary: Binary
 *   * Boolean: Boolean
 *   * Interval: Interval
 * As for complex data types, Spark will determine the precedent list recursively based on their
 * sub-types and nullability.
 * <p>
 * With the definition of type precedent list, the general type coercion rules are as following:
 *   * Data type S is allowed to be implicitly cast as type T iff T is in the precedence list of S
 *   * Comparison is allowed iff the data type precedence list of both sides has at least one common
 *     element. When evaluating the comparison, Spark casts both sides as the tightest common data
 *     type of their precedent lists.
 *   * There should be at least one common data type among all the children's precedence lists for
 *     the following operators. The data type of the operator is the tightest common precedent
 *     data type.
 *       * In
 *       * Except
 *       * Intersect
 *       * Greatest
 *       * Least
 *       * Union
 *       * If
 *       * CaseWhen
 *       * CreateArray
 *       * Array Concat
 *       * Sequence
 *       * MapConcat
 *       * CreateMap
 *   * For complex types (struct, array, map), Spark recursively looks into the element type and
 *     applies the rules above.
 *  Note: this new type coercion system will allow implicit converting String type literals as other
 *  primitive types, in case of breaking too many existing Spark SQL queries. This is a special
 *  rule and it is not from the ANSI SQL standard.
 */
public  class AnsiTypeCoercion$ extends org.apache.spark.sql.catalyst.analysis.TypeCoercionBase {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AnsiTypeCoercion$ MODULE$ = null;
  public   AnsiTypeCoercion$ ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.List<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> typeCoercionRules ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> findTightestCommonType (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> findWiderTypeForTwo (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.DataType> findWiderCommonType (scala.collection.Seq<org.apache.spark.sql.types.DataType> types)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> implicitCast (org.apache.spark.sql.catalyst.expressions.Expression e, org.apache.spark.sql.types.AbstractDataType expectedType)  { throw new RuntimeException(); }
  public  boolean canCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
}
