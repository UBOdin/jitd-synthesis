package org.apache.spark.sql.catalyst.encoders;
/**
 * A factory for constructing encoders that convert external row to/from the Spark SQL
 * internal binary representation.
 * <p>
 * The following is a mapping between Spark SQL types and its allowed external types:
 * <pre><code>
 *   BooleanType -&gt; java.lang.Boolean
 *   ByteType -&gt; java.lang.Byte
 *   ShortType -&gt; java.lang.Short
 *   IntegerType -&gt; java.lang.Integer
 *   FloatType -&gt; java.lang.Float
 *   DoubleType -&gt; java.lang.Double
 *   StringType -&gt; String
 *   DecimalType -&gt; java.math.BigDecimal or scala.math.BigDecimal or Decimal
 *
 *   DateType -&gt; java.sql.Date if spark.sql.datetime.java8API.enabled is false
 *   DateType -&gt; java.time.LocalDate if spark.sql.datetime.java8API.enabled is true
 *
 *   TimestampType -&gt; java.sql.Timestamp if spark.sql.datetime.java8API.enabled is false
 *   TimestampType -&gt; java.time.Instant if spark.sql.datetime.java8API.enabled is true
 *
 *   DayTimeIntervalType -&gt; java.time.Duration
 *   YearMonthIntervalType -&gt; java.time.Period
 *
 *   BinaryType -&gt; byte array
 *   ArrayType -&gt; scala.collection.Seq or Array
 *   MapType -&gt; scala.collection.Map
 *   StructType -&gt; org.apache.spark.sql.Row
 * </code></pre>
 */
public  class RowEncoder$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RowEncoder$ MODULE$ = null;
  public   RowEncoder$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<org.apache.spark.sql.Row> apply (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Returns the <code>DataType</code> that can be used when generating code that converts input data
   * into the Spark SQL internal format.  Unlike <code>externalDataTypeFor</code>, the <code>DataType</code> returned
   * by this function can be more permissive since multiple external types may map to a single
   * internal type.  For example, for an input with DecimalType in external row, its external types
   * can be <code>scala.math.BigDecimal</code>, <code>java.math.BigDecimal</code>, or
   * <code>org.apache.spark.sql.types.Decimal</code>.
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType externalDataTypeForInput (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType externalDataTypeFor (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
}
