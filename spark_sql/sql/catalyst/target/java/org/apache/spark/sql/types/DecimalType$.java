package org.apache.spark.sql.types;
/**
 * Extra factory methods and pattern matchers for Decimals.
 * <p>
 * @since 1.3.0
 */
public  class DecimalType$ extends org.apache.spark.sql.types.AbstractDataType implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DecimalType$ MODULE$ = null;
  public   DecimalType$ ()  { throw new RuntimeException(); }
  public  int MAX_PRECISION ()  { throw new RuntimeException(); }
  public  int MAX_SCALE ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DecimalType SYSTEM_DEFAULT ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DecimalType USER_DEFAULT ()  { throw new RuntimeException(); }
  public  int MINIMUM_ADJUSTED_SCALE ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType BooleanDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType ByteDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType ShortDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType IntDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType LongDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType FloatDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType DoubleDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType BigIntDecimal ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType forType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType fromLiteral (org.apache.spark.sql.catalyst.expressions.Literal literal)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType fromDecimal (org.apache.spark.sql.types.Decimal d)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DecimalType bounded (int precision, int scale)  { throw new RuntimeException(); }
    void checkNegativeScale (int scale)  { throw new RuntimeException(); }
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
    org.apache.spark.sql.types.DecimalType adjustPrecisionScale (int precision, int scale)  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
  /**
   * Returns if dt is a DecimalType that fits inside an int
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  boolean is32BitDecimalType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns if dt is a DecimalType that fits inside a long
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  boolean is64BitDecimalType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns if dt is a DecimalType that doesn't fit inside a long
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  boolean isByteArrayDecimalType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  boolean unapply (org.apache.spark.sql.types.DataType t)  { throw new RuntimeException(); }
  public  boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
}
