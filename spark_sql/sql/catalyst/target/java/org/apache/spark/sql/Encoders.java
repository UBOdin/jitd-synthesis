package org.apache.spark.sql;
/**
 * Methods for creating an {@link Encoder}.
 * <p>
 * @since 1.6.0
 */
public  class Encoders {
  /**
   * An encoder for nullable boolean type.
   * The Scala primitive encoder is available as {@link scalaBoolean}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Boolean> BOOLEAN ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable byte type.
   * The Scala primitive encoder is available as {@link scalaByte}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Byte> BYTE ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable short type.
   * The Scala primitive encoder is available as {@link scalaShort}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Short> SHORT ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable int type.
   * The Scala primitive encoder is available as {@link scalaInt}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Integer> INT ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable long type.
   * The Scala primitive encoder is available as {@link scalaLong}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Long> LONG ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable float type.
   * The Scala primitive encoder is available as {@link scalaFloat}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Float> FLOAT ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable double type.
   * The Scala primitive encoder is available as {@link scalaDouble}.
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Double> DOUBLE ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable string type.
   * <p>
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.String> STRING ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable decimal type.
   * <p>
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.math.BigDecimal> DECIMAL ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable date type.
   * <p>
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.sql.Date> DATE ()  { throw new RuntimeException(); }
  /**
   * Creates an encoder that serializes instances of the <code>java.time.LocalDate</code> class
   * to the internal representation of nullable Catalyst's DateType.
   * <p>
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.time.LocalDate> LOCALDATE ()  { throw new RuntimeException(); }
  /**
   * An encoder for nullable timestamp type.
   * <p>
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.sql.Timestamp> TIMESTAMP ()  { throw new RuntimeException(); }
  /**
   * Creates an encoder that serializes instances of the <code>java.time.Instant</code> class
   * to the internal representation of nullable Catalyst's TimestampType.
   * <p>
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.time.Instant> INSTANT ()  { throw new RuntimeException(); }
  /**
   * An encoder for arrays of bytes.
   * <p>
   * @since 1.6.1
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<byte[]> BINARY ()  { throw new RuntimeException(); }
  /**
   * Creates an encoder that serializes instances of the <code>java.time.Duration</code> class
   * to the internal representation of nullable Catalyst's DayTimeIntervalType.
   * <p>
   * @since 3.2.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.time.Duration> DURATION ()  { throw new RuntimeException(); }
  /**
   * Creates an encoder that serializes instances of the <code>java.time.Period</code> class
   * to the internal representation of nullable Catalyst's YearMonthIntervalType.
   * <p>
   * @since 3.2.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.time.Period> PERIOD ()  { throw new RuntimeException(); }
  /**
   * Creates an encoder for Java Bean of type T.
   * <p>
   * T must be publicly accessible.
   * <p>
   * supported types for java bean field:
   *  - primitive types: boolean, int, double, etc.
   *  - boxed types: Boolean, Integer, Double, etc.
   *  - String
   *  - java.math.BigDecimal, java.math.BigInteger
   *  - time related: java.sql.Date, java.sql.Timestamp, java.time.LocalDate, java.time.Instant
   *  - collection types: array, java.util.List, and map
   *  - nested java bean.
   * <p>
   * @since 1.6.0
   * @param beanClass (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Encoder<T> bean (java.lang.Class<T> beanClass)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Creates an encoder that serializes objects of type T using Kryo.
   * This encoder maps T into a single byte array (binary) field.
   * <p>
   * T must be publicly accessible.
   * <p>
   * @since 1.6.0
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Encoder<T> kryo (scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  /**
   * Creates an encoder that serializes objects of type T using Kryo.
   * This encoder maps T into a single byte array (binary) field.
   * <p>
   * T must be publicly accessible.
   * <p>
   * @since 1.6.0
   * @param clazz (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Encoder<T> kryo (java.lang.Class<T> clazz)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Creates an encoder that serializes objects of type T using generic Java
   * serialization. This encoder maps T into a single byte array (binary) field.
   * <p>
   * T must be publicly accessible.
   * <p>
   * @note This is extremely inefficient and should only be used as the last resort.
   * <p>
   * @since 1.6.0
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Encoder<T> javaSerialization (scala.reflect.ClassTag<T> evidence$2)  { throw new RuntimeException(); }
  /**
   * Creates an encoder that serializes objects of type T using generic Java serialization.
   * This encoder maps T into a single byte array (binary) field.
   * <p>
   * T must be publicly accessible.
   * <p>
   * @note This is extremely inefficient and should only be used as the last resort.
   * <p>
   * @since 1.6.0
   * @param clazz (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Encoder<T> javaSerialization (java.lang.Class<T> clazz)  { throw new RuntimeException(); }
  /**
   * An encoder for 2-ary tuples.
   * <p>
   * @since 1.6.0
   * @param e1 (undocumented)
   * @param e2 (undocumented)
   * @return (undocumented)
   */
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object> org.apache.spark.sql.Encoder<scala.Tuple2<T1, T2>> tuple (org.apache.spark.sql.Encoder<T1> e1, org.apache.spark.sql.Encoder<T2> e2)  { throw new RuntimeException(); }
  /**
   * An encoder for 3-ary tuples.
   * <p>
   * @since 1.6.0
   * @param e1 (undocumented)
   * @param e2 (undocumented)
   * @param e3 (undocumented)
   * @return (undocumented)
   */
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object> org.apache.spark.sql.Encoder<scala.Tuple3<T1, T2, T3>> tuple (org.apache.spark.sql.Encoder<T1> e1, org.apache.spark.sql.Encoder<T2> e2, org.apache.spark.sql.Encoder<T3> e3)  { throw new RuntimeException(); }
  /**
   * An encoder for 4-ary tuples.
   * <p>
   * @since 1.6.0
   * @param e1 (undocumented)
   * @param e2 (undocumented)
   * @param e3 (undocumented)
   * @param e4 (undocumented)
   * @return (undocumented)
   */
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object, T4 extends java.lang.Object> org.apache.spark.sql.Encoder<scala.Tuple4<T1, T2, T3, T4>> tuple (org.apache.spark.sql.Encoder<T1> e1, org.apache.spark.sql.Encoder<T2> e2, org.apache.spark.sql.Encoder<T3> e3, org.apache.spark.sql.Encoder<T4> e4)  { throw new RuntimeException(); }
  /**
   * An encoder for 5-ary tuples.
   * <p>
   * @since 1.6.0
   * @param e1 (undocumented)
   * @param e2 (undocumented)
   * @param e3 (undocumented)
   * @param e4 (undocumented)
   * @param e5 (undocumented)
   * @return (undocumented)
   */
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object, T4 extends java.lang.Object, T5 extends java.lang.Object> org.apache.spark.sql.Encoder<scala.Tuple5<T1, T2, T3, T4, T5>> tuple (org.apache.spark.sql.Encoder<T1> e1, org.apache.spark.sql.Encoder<T2> e2, org.apache.spark.sql.Encoder<T3> e3, org.apache.spark.sql.Encoder<T4> e4, org.apache.spark.sql.Encoder<T5> e5)  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's product type (tuples, case classes, etc).
   * @since 2.0.0
   * @param evidence$5 (undocumented)
   * @return (undocumented)
   */
  static public <T extends scala.Product> org.apache.spark.sql.Encoder<T> product (scala.reflect.api.TypeTags.TypeTag<T> evidence$5)  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive int type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaInt ()  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive long type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaLong ()  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive double type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaDouble ()  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive float type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaFloat ()  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive byte type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaByte ()  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive short type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaShort ()  { throw new RuntimeException(); }
  /**
   * An encoder for Scala's primitive boolean type.
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Encoder<java.lang.Object> scalaBoolean ()  { throw new RuntimeException(); }
}
