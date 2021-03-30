package org.apache.spark.sql.types;
/**
 * The data type representing <code>java.math.BigDecimal</code> values.
 * A Decimal that must have fixed precision (the maximum number of digits) and scale (the number
 * of digits on right side of dot).
 * <p>
 * The precision can be up to 38, scale can also be up to 38 (less or equal to precision).
 * <p>
 * The default precision and scale is (10, 0).
 * <p>
 * Please use <code>DataTypes.createDecimalType()</code> to create a specific instance.
 * <p>
 * @since 1.3.0
 */
public  class DecimalType extends org.apache.spark.sql.types.FractionalType implements scala.Product, scala.Serializable {
  static public  class Fixed$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Fixed$ MODULE$ = null;
    public   Fixed$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<java.lang.Object, java.lang.Object>> unapply (org.apache.spark.sql.types.DecimalType t)  { throw new RuntimeException(); }
  }
  static public  class Expression$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Expression$ MODULE$ = null;
    public   Expression$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<java.lang.Object, java.lang.Object>> unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  }
  static public  int MAX_PRECISION ()  { throw new RuntimeException(); }
  static public  int MAX_SCALE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DecimalType SYSTEM_DEFAULT ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DecimalType USER_DEFAULT ()  { throw new RuntimeException(); }
  static public  int MINIMUM_ADJUSTED_SCALE ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType BooleanDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType ByteDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType ShortDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType IntDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType LongDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType FloatDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType DoubleDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType BigIntDecimal ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType forType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType fromLiteral (org.apache.spark.sql.catalyst.expressions.Literal literal)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType fromDecimal (org.apache.spark.sql.types.Decimal d)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DecimalType bounded (int precision, int scale)  { throw new RuntimeException(); }
  static   void checkNegativeScale (int scale)  { throw new RuntimeException(); }
  /**
   * Scale adjustment implementation is based on Hive's one, which is itself inspired to
   * SQLServer's one. In particular, when a result precision is greater than
   * {@link #MAX_PRECISION}, the corresponding scale is reduced to prevent the integral part of a
   * result from being truncated.
   * <p>
   * This method is used only when <code>spark.sql.decimalOperations.allowPrecisionLoss</code> is set to true.
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  static   org.apache.spark.sql.types.DecimalType adjustPrecisionScale (int precision, int scale)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  /**
   * Returns if dt is a DecimalType that fits inside an int
   * @param dt (undocumented)
   * @return (undocumented)
   */
  static public  boolean is32BitDecimalType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns if dt is a DecimalType that fits inside a long
   * @param dt (undocumented)
   * @return (undocumented)
   */
  static public  boolean is64BitDecimalType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns if dt is a DecimalType that doesn't fit inside a long
   * @param dt (undocumented)
   * @return (undocumented)
   */
  static public  boolean isByteArrayDecimalType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static public  boolean unapply (org.apache.spark.sql.types.DataType t)  { throw new RuntimeException(); }
  static public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public  int precision ()  { throw new RuntimeException(); }
  public  int scale ()  { throw new RuntimeException(); }
  // not preceding
  public   DecimalType (int precision, int scale)  { throw new RuntimeException(); }
  public   DecimalType (int precision)  { throw new RuntimeException(); }
  public   DecimalType ()  { throw new RuntimeException(); }
  // not preceding
    scala.reflect.api.TypeTags.TypeTag<org.apache.spark.sql.types.Decimal> tag ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.Decimal.DecimalIsFractional$ numeric ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.Decimal.DecimalIsFractional$ fractional ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.Decimal.DecimalIsFractional$ ordering ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.Decimal.DecimalAsIfIntegral$ asIntegral ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalExactNumeric$ exactNumeric ()  { throw new RuntimeException(); }
  public  java.lang.String typeName ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  /**
   * Returns whether this DecimalType is wider than <code>other</code>. If yes, it means <code>other</code>
   * can be casted into <code>this</code> safely without losing any precision or range.
   * @param other (undocumented)
   * @return (undocumented)
   */
    boolean isWiderThan (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  /**
   * Returns whether this DecimalType is tighter than <code>other</code>. If yes, it means <code>this</code>
   * can be casted into <code>other</code> safely without losing any precision or range.
   * @param other (undocumented)
   * @return (undocumented)
   */
    boolean isTighterThan (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  /**
   * The default size of a value of the DecimalType is 8 bytes when precision is at most 18,
   * and 16 bytes otherwise.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType asNullable ()  { throw new RuntimeException(); }
}
