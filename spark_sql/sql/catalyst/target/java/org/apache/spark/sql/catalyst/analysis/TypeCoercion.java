package org.apache.spark.sql.catalyst.analysis;
/**
 * A collection of {@link Rule} that can be used to coerce differing types that participate in
 * operations into compatible ones.
 * <p>
 * Notes about type widening / tightest common types: Broadly, there are two cases when we need
 * to widen data types (e.g. union, binary comparison). In case 1, we are looking for a common
 * data type for two or more data types, and in this case no loss of precision is allowed. Examples
 * include type inference in JSON (e.g. what's the column's data type if one row is an integer
 * while the other row is a long?). In case 2, we are looking for a widened data type with
 * some acceptable loss of precision (e.g. there is no common type for double and decimal because
 * double's range is larger than decimal, and yet decimal is more precise than double, but in
 * union we would cast the decimal into double).
 */
public  class TypeCoercion {
  /**
   * Promotes strings that appear in arithmetic expressions.
   */
  static public  class PromoteStrings$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.analysis.TypeCoercionRule {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final PromoteStrings$ MODULE$ = null;
    public   PromoteStrings$ ()  { throw new RuntimeException(); }
    protected  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan coerceTypes (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  /**
   * Changes numeric values to booleans so that expressions like true = 1 can be evaluated.
   */
  static public  class BooleanEquality$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BooleanEquality$ MODULE$ = null;
    public   BooleanEquality$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  }
  static public  scala.collection.immutable.List<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> typeCoercionRules ()  { throw new RuntimeException(); }
  static public  boolean canCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  static public  scala.collection.IndexedSeq<org.apache.spark.sql.types.NumericType> numericPrecedence ()  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.DataType> findTightestCommonType (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
  /**
   * This function determines the target type of a comparison operator when one operand
   * is a String and the other is not. It also handles when one op is a Date and the
   * other is a Timestamp by making the target type to be String.
   * @param dt1 (undocumented)
   * @param dt2 (undocumented)
   * @param conf (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.spark.sql.types.DataType> findCommonTypeForBinaryComparison (org.apache.spark.sql.types.DataType dt1, org.apache.spark.sql.types.DataType dt2, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.DataType> findWiderTypeForTwo (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.DataType> findWiderCommonType (scala.collection.Seq<org.apache.spark.sql.types.DataType> types)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> implicitCast (org.apache.spark.sql.catalyst.expressions.Expression e, org.apache.spark.sql.types.AbstractDataType expectedType)  { throw new RuntimeException(); }
  /**
   * The method finds a common type for data types that differ only in nullable flags, including
   * <code>nullable</code>, <code>containsNull</code> of {@link ArrayType} and <code>valueContainsNull</code> of {@link MapType}.
   * If the input types are different besides nullable flags, None is returned.
   * @param t1 (undocumented)
   * @param t2 (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<org.apache.spark.sql.types.DataType> findCommonTypeDifferentOnlyInNullFlags (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.DataType> findCommonTypeDifferentOnlyInNullFlags (scala.collection.Seq<org.apache.spark.sql.types.DataType> types)  { throw new RuntimeException(); }
  /**
   * Whether the data type contains StringType.
   * @param dt (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasStringType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static protected  scala.Option<org.apache.spark.sql.types.DataType> findTypeForComplex (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2, scala.Function2<org.apache.spark.sql.types.DataType, org.apache.spark.sql.types.DataType, scala.Option<org.apache.spark.sql.types.DataType>> findTypeFunc)  { throw new RuntimeException(); }
  static protected  scala.Option<org.apache.spark.sql.types.DataType> findWiderTypeForDecimal (org.apache.spark.sql.types.DataType dt1, org.apache.spark.sql.types.DataType dt2)  { throw new RuntimeException(); }
  static   scala.Option<org.apache.spark.sql.types.DataType> findWiderTypeWithoutStringPromotionForTwo (org.apache.spark.sql.types.DataType t1, org.apache.spark.sql.types.DataType t2)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.types.DataType> findWiderTypeWithoutStringPromotion (scala.collection.Seq<org.apache.spark.sql.types.DataType> types)  { throw new RuntimeException(); }
  static public  boolean haveSameType (scala.collection.Seq<org.apache.spark.sql.types.DataType> types)  { throw new RuntimeException(); }
}
