package org.apache.spark.sql.types;
/**
 * A mutable implementation of BigDecimal that can hold a Long if values are small enough.
 * <p>
 * The semantics of the fields are as follows:
 * - _precision and _scale represent the SQL precision and scale we are looking for
 * - If decimalVal is set, it represents the whole decimal value
 * - Otherwise, the decimal value is longVal / (10 ** _scale)
 * <p>
 * Note, for values between -1.0 and 1.0, precision digits are only counted after dot.
 */
public final class Decimal implements scala.math.Ordered<org.apache.spark.sql.types.Decimal>, scala.Serializable {
  /** A {@link scala.math.Fractional} evidence parameter for Decimals. */
  static public  class DecimalIsFractional$ implements org.apache.spark.sql.types.Decimal.DecimalIsConflicted, scala.math.Fractional<org.apache.spark.sql.types.Decimal> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final DecimalIsFractional$ MODULE$ = null;
    public   DecimalIsFractional$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.Decimal div (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  { throw new RuntimeException(); }
  }
  /** A {@link scala.math.Integral} evidence parameter for Decimals. */
  static public  class DecimalAsIfIntegral$ implements org.apache.spark.sql.types.Decimal.DecimalIsConflicted, scala.math.Integral<org.apache.spark.sql.types.Decimal> {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final DecimalAsIfIntegral$ MODULE$ = null;
    public   DecimalAsIfIntegral$ ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.Decimal quot (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.types.Decimal rem (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  { throw new RuntimeException(); }
  }
  /** Common methods for Decimal evidence parameters */
  static public  interface DecimalIsConflicted extends scala.math.Numeric<org.apache.spark.sql.types.Decimal> {
    public  int compare (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  ;
    public  org.apache.spark.sql.types.Decimal fromInt (int x)  ;
    public  org.apache.spark.sql.types.Decimal minus (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  ;
    public  org.apache.spark.sql.types.Decimal negate (org.apache.spark.sql.types.Decimal x)  ;
    public  scala.Option<org.apache.spark.sql.types.Decimal> parseString (java.lang.String str)  ;
    public  org.apache.spark.sql.types.Decimal plus (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  ;
    public  org.apache.spark.sql.types.Decimal times (org.apache.spark.sql.types.Decimal x, org.apache.spark.sql.types.Decimal y)  ;
    public  double toDouble (org.apache.spark.sql.types.Decimal x)  ;
    public  float toFloat (org.apache.spark.sql.types.Decimal x)  ;
    public  int toInt (org.apache.spark.sql.types.Decimal x)  ;
    public  long toLong (org.apache.spark.sql.types.Decimal x)  ;
  }
  static public  scala.Enumeration.Value ROUND_HALF_UP ()  { throw new RuntimeException(); }
  static public  scala.Enumeration.Value ROUND_HALF_EVEN ()  { throw new RuntimeException(); }
  static public  scala.Enumeration.Value ROUND_CEILING ()  { throw new RuntimeException(); }
  static public  scala.Enumeration.Value ROUND_FLOOR ()  { throw new RuntimeException(); }
  /** Maximum number of decimal digits an Int can represent */
  static public  int MAX_INT_DIGITS ()  { throw new RuntimeException(); }
  /** Maximum number of decimal digits a Long can represent */
  static public  int MAX_LONG_DIGITS ()  { throw new RuntimeException(); }
  static public  long[] POW_10 ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.Decimal ZERO ()  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.Decimal ONE ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (double value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (long value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (int value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (scala.math.BigDecimal value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (java.math.BigDecimal value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (java.math.BigInteger value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (scala.math.BigInt value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (scala.math.BigDecimal value, int precision, int scale)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (java.math.BigDecimal value, int precision, int scale)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (long unscaled, int precision, int scale)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal apply (java.lang.String value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal fromDecimal (Object value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal fromString (org.apache.spark.unsafe.types.UTF8String str)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.Decimal fromStringANSI (org.apache.spark.unsafe.types.UTF8String str)  { throw new RuntimeException(); }
  /**
   * Creates a decimal from unscaled, precision and scale without checking the bounds.
   * @param unscaled (undocumented)
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.Decimal createUnsafe (long unscaled, int precision, int scale)  { throw new RuntimeException(); }
  static public  int maxPrecisionForBytes (int numBytes)  { throw new RuntimeException(); }
  // not preceding
  static public  int[] minBytesForPrecision ()  { throw new RuntimeException(); }
  public   Decimal ()  { throw new RuntimeException(); }
  public  int precision ()  { throw new RuntimeException(); }
  public  int scale ()  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given Long. Will have precision 20 and scale 0.
   * @param longVal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (long longVal)  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given Int. Will have precision 10 and scale 0.
   * @param intVal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (int intVal)  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given unscaled Long, with a given precision and scale.
   * @param unscaled (undocumented)
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (long unscaled, int precision, int scale)  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given unscaled Long, with a given precision and scale,
   * and return it, or return null if it cannot be set due to overflow.
   * @param unscaled (undocumented)
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal setOrNull (long unscaled, int precision, int scale)  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given BigDecimal value, with a given precision and scale.
   * @param decimal (undocumented)
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (scala.math.BigDecimal decimal, int precision, int scale)  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given BigDecimal value, inheriting its precision and scale.
   * @param decimal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (scala.math.BigDecimal decimal)  { throw new RuntimeException(); }
  /**
   * If the value is not in the range of long, convert it to BigDecimal and
   * the precision and scale are based on the converted value.
   * <p>
   * This code avoids BigDecimal object allocation as possible to improve runtime efficiency
   * @param bigintval (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (java.math.BigInteger bigintval)  { throw new RuntimeException(); }
  /**
   * Set this Decimal to the given Decimal value.
   * @param decimal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal set (org.apache.spark.sql.types.Decimal decimal)  { throw new RuntimeException(); }
  public  scala.math.BigDecimal toBigDecimal ()  { throw new RuntimeException(); }
  public  java.math.BigDecimal toJavaBigDecimal ()  { throw new RuntimeException(); }
  public  scala.math.BigInt toScalaBigInt ()  { throw new RuntimeException(); }
  public  java.math.BigInteger toJavaBigInteger ()  { throw new RuntimeException(); }
  public  long toUnscaledLong ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String toDebugString ()  { throw new RuntimeException(); }
  public  double toDouble ()  { throw new RuntimeException(); }
  public  float toFloat ()  { throw new RuntimeException(); }
  public  long toLong ()  { throw new RuntimeException(); }
  public  int toInt ()  { throw new RuntimeException(); }
  public  short toShort ()  { throw new RuntimeException(); }
  public  byte toByte ()  { throw new RuntimeException(); }
  /**
   * @return the Byte value that is equal to the rounded decimal.
   * @throws ArithmeticException if the decimal is too big to fit in Byte type.
   */
    byte roundToByte ()  { throw new RuntimeException(); }
  /**
   * @return the Short value that is equal to the rounded decimal.
   * @throws ArithmeticException if the decimal is too big to fit in Short type.
   */
    short roundToShort ()  { throw new RuntimeException(); }
  /**
   * @return the Int value that is equal to the rounded decimal.
   * @throws ArithmeticException if the decimal too big to fit in Int type.
   */
    int roundToInt ()  { throw new RuntimeException(); }
  /**
   * @return the Long value that is equal to the rounded decimal.
   * @throws ArithmeticException if the decimal too big to fit in Long type.
   */
    long roundToLong ()  { throw new RuntimeException(); }
  /**
   * Update precision and scale while keeping our value the same, and return true if successful.
   * <p>
   * @return true if successful, false if overflow would occur
   * @param precision (undocumented)
   * @param scale (undocumented)
   */
  public  boolean changePrecision (int precision, int scale)  { throw new RuntimeException(); }
  /**
   * Create new <code>Decimal</code> with given precision and scale.
   * <p>
   * @return a non-null <code>Decimal</code> value if successful. Otherwise, if <code>nullOnOverflow</code> is true, null
   *         is returned; if <code>nullOnOverflow</code> is false, an <code>ArithmeticException</code> is thrown.
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @param roundMode (undocumented)
   * @param nullOnOverflow (undocumented)
   */
    org.apache.spark.sql.types.Decimal toPrecision (int precision, int scale, scala.Enumeration.Value roundMode, boolean nullOnOverflow)  { throw new RuntimeException(); }
  /**
   * Update precision and scale while keeping our value the same, and return true if successful.
   * <p>
   * @return true if successful, false if overflow would occur
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @param roundMode (undocumented)
   */
    boolean changePrecision (int precision, int scale, scala.Enumeration.Value roundMode)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal clone ()  { throw new RuntimeException(); }
  public  int compare (org.apache.spark.sql.types.Decimal other)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean isZero ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal quot (org.apache.spark.sql.types.Decimal that)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal remainder (org.apache.spark.sql.types.Decimal that)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal abs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal floor ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal ceil ()  { throw new RuntimeException(); }
}
