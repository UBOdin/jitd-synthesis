package org.apache.spark.sql.types;
public  class Decimal$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Decimal$ MODULE$ = null;
  public   Decimal$ ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value ROUND_HALF_UP ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value ROUND_HALF_EVEN ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value ROUND_CEILING ()  { throw new RuntimeException(); }
  public  scala.Enumeration.Value ROUND_FLOOR ()  { throw new RuntimeException(); }
  /** Maximum number of decimal digits an Int can represent */
  public  int MAX_INT_DIGITS ()  { throw new RuntimeException(); }
  /** Maximum number of decimal digits a Long can represent */
  public  int MAX_LONG_DIGITS ()  { throw new RuntimeException(); }
  public  long[] POW_10 ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.Decimal ZERO ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.Decimal ONE ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (double value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (long value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (int value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (scala.math.BigDecimal value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (java.math.BigDecimal value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (java.math.BigInteger value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (scala.math.BigInt value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (scala.math.BigDecimal value, int precision, int scale)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (java.math.BigDecimal value, int precision, int scale)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (long unscaled, int precision, int scale)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal apply (java.lang.String value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal fromDecimal (Object value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal fromString (org.apache.spark.unsafe.types.UTF8String str)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Decimal fromStringANSI (org.apache.spark.unsafe.types.UTF8String str)  { throw new RuntimeException(); }
  /**
   * Creates a decimal from unscaled, precision and scale without checking the bounds.
   * @param unscaled (undocumented)
   * @param precision (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.Decimal createUnsafe (long unscaled, int precision, int scale)  { throw new RuntimeException(); }
  public  int maxPrecisionForBytes (int numBytes)  { throw new RuntimeException(); }
  // not preceding
  public  int[] minBytesForPrecision ()  { throw new RuntimeException(); }
}
