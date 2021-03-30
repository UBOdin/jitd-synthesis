package org.apache.spark.sql;
/**
 * Represents one row of output from a relational operator.  Allows both generic access by ordinal,
 * which will incur boxing overhead for primitives, as well as native primitive access.
 * <p>
 * It is invalid to use the native primitive interface to retrieve a value that is null, instead a
 * user must check <code>isNullAt</code> before attempting to retrieve a value that might be null.
 * <p>
 * To create a new Row, use <code>RowFactory.create()</code> in Java or <code>Row.apply()</code> in Scala.
 * <p>
 * A {@link Row} object can be constructed by providing field values. Example:
 * <pre><code>
 * import org.apache.spark.sql._
 *
 * // Create a Row from values.
 * Row(value1, value2, value3, ...)
 * // Create a Row from a Seq of values.
 * Row.fromSeq(Seq(value1, value2, ...))
 * </code></pre>
 * <p>
 * A value of a row can be accessed through both generic access by ordinal,
 * which will incur boxing overhead for primitives, as well as native primitive access.
 * An example of generic access by ordinal:
 * <pre><code>
 * import org.apache.spark.sql._
 *
 * val row = Row(1, true, "a string", null)
 * // row: Row = [1,true,a string,null]
 * val firstValue = row(0)
 * // firstValue: Any = 1
 * val fourthValue = row(3)
 * // fourthValue: Any = null
 * </code></pre>
 * <p>
 * For native primitive access, it is invalid to use the native primitive interface to retrieve
 * a value that is null, instead a user must check <code>isNullAt</code> before attempting to retrieve a
 * value that might be null.
 * An example of native primitive access:
 * <pre><code>
 * // using the row from the previous example.
 * val firstValue = row.getInt(0)
 * // firstValue: Int = 1
 * val isNull = row.isNullAt(3)
 * // isNull: Boolean = true
 * </code></pre>
 * <p>
 * In Scala, fields in a {@link Row} object can be extracted in a pattern match. Example:
 * <pre><code>
 * import org.apache.spark.sql._
 *
 * val pairs = sql("SELECT key, value FROM src").rdd.map {
 *   case Row(key: Int, value: String) =&gt;
 *     key -&gt; value
 * }
 * </code></pre>
 * <p>
 * @since 1.3.0
 */
public  interface Row extends scala.Serializable {
  /** Number of elements in the Row. */
  public  int size ()  ;
  /** Number of elements in the Row. */
  public  int length ()  ;
  /**
   * Schema for the row.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType schema ()  ;
  /**
   * Returns the value at position i. If the value is null, null is returned. The following
   * is a mapping between Spark SQL types and return types:
   * <p>
   * <pre><code>
   *   BooleanType -&gt; java.lang.Boolean
   *   ByteType -&gt; java.lang.Byte
   *   ShortType -&gt; java.lang.Short
   *   IntegerType -&gt; java.lang.Integer
   *   LongType -&gt; java.lang.Long
   *   FloatType -&gt; java.lang.Float
   *   DoubleType -&gt; java.lang.Double
   *   StringType -&gt; String
   *   DecimalType -&gt; java.math.BigDecimal
   *
   *   DateType -&gt; java.sql.Date if spark.sql.datetime.java8API.enabled is false
   *   DateType -&gt; java.time.LocalDate if spark.sql.datetime.java8API.enabled is true
   *
   *   TimestampType -&gt; java.sql.Timestamp if spark.sql.datetime.java8API.enabled is false
   *   TimestampType -&gt; java.time.Instant if spark.sql.datetime.java8API.enabled is true
   *
   *   BinaryType -&gt; byte array
   *   ArrayType -&gt; scala.collection.Seq (use getList for java.util.List)
   *   MapType -&gt; scala.collection.Map (use getJavaMap for java.util.Map)
   *   StructType -&gt; org.apache.spark.sql.Row
   * </code></pre>
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  Object apply (int i)  ;
  /**
   * Returns the value at position i. If the value is null, null is returned. The following
   * is a mapping between Spark SQL types and return types:
   * <p>
   * <pre><code>
   *   BooleanType -&gt; java.lang.Boolean
   *   ByteType -&gt; java.lang.Byte
   *   ShortType -&gt; java.lang.Short
   *   IntegerType -&gt; java.lang.Integer
   *   LongType -&gt; java.lang.Long
   *   FloatType -&gt; java.lang.Float
   *   DoubleType -&gt; java.lang.Double
   *   StringType -&gt; String
   *   DecimalType -&gt; java.math.BigDecimal
   *
   *   DateType -&gt; java.sql.Date if spark.sql.datetime.java8API.enabled is false
   *   DateType -&gt; java.time.LocalDate if spark.sql.datetime.java8API.enabled is true
   *
   *   TimestampType -&gt; java.sql.Timestamp if spark.sql.datetime.java8API.enabled is false
   *   TimestampType -&gt; java.time.Instant if spark.sql.datetime.java8API.enabled is true
   *
   *   BinaryType -&gt; byte array
   *   ArrayType -&gt; scala.collection.Seq (use getList for java.util.List)
   *   MapType -&gt; scala.collection.Map (use getJavaMap for java.util.Map)
   *   StructType -&gt; org.apache.spark.sql.Row
   * </code></pre>
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  Object get (int i)  ;
  /** Checks whether the value at position i is null. */
  public  boolean isNullAt (int i)  ;
  /**
   * Returns the value at position i as a primitive boolean.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  boolean getBoolean (int i)  ;
  /**
   * Returns the value at position i as a primitive byte.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  byte getByte (int i)  ;
  /**
   * Returns the value at position i as a primitive short.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  short getShort (int i)  ;
  /**
   * Returns the value at position i as a primitive int.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  int getInt (int i)  ;
  /**
   * Returns the value at position i as a primitive long.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  long getLong (int i)  ;
  /**
   * Returns the value at position i as a primitive float.
   * Throws an exception if the type mismatches or if the value is null.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  float getFloat (int i)  ;
  /**
   * Returns the value at position i as a primitive double.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  double getDouble (int i)  ;
  /**
   * Returns the value at position i as a String object.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getString (int i)  ;
  /**
   * Returns the value at position i of decimal type as java.math.BigDecimal.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  java.math.BigDecimal getDecimal (int i)  ;
  /**
   * Returns the value at position i of date type as java.sql.Date.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  java.sql.Date getDate (int i)  ;
  /**
   * Returns the value at position i of date type as java.time.LocalDate.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  java.time.LocalDate getLocalDate (int i)  ;
  /**
   * Returns the value at position i of date type as java.sql.Timestamp.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  java.sql.Timestamp getTimestamp (int i)  ;
  /**
   * Returns the value at position i of date type as java.time.Instant.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  java.time.Instant getInstant (int i)  ;
  /**
   * Returns the value at position i of array type as a Scala Seq.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.Seq<T> getSeq (int i)  ;
  /**
   * Returns the value at position i of array type as <code>java.util.List</code>.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> java.util.List<T> getList (int i)  ;
  /**
   * Returns the value at position i of map type as a Scala Map.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> scala.collection.Map<K, V> getMap (int i)  ;
  /**
   * Returns the value at position i of array type as a <code>java.util.Map</code>.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object, V extends java.lang.Object> java.util.Map<K, V> getJavaMap (int i)  ;
  /**
   * Returns the value at position i of struct type as a {@link Row} object.
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Row getStruct (int i)  ;
  /**
   * Returns the value at position i.
   * For primitive types if value is null it returns 'zero value' specific for primitive
   * i.e. 0 for Int - use isNullAt to ensure that value is not null
   * <p>
   * @throws ClassCastException when data type does not match.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T getAs (int i)  ;
  /**
   * Returns the value of a given fieldName.
   * For primitive types if value is null it returns 'zero value' specific for primitive
   * i.e. 0 for Int - use isNullAt to ensure that value is not null
   * <p>
   * @throws UnsupportedOperationException when schema is not defined.
   * @throws IllegalArgumentException when fieldName do not exist.
   * @throws ClassCastException when data type does not match.
   * @param fieldName (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T getAs (java.lang.String fieldName)  ;
  /**
   * Returns the index of a given field name.
   * <p>
   * @throws UnsupportedOperationException when schema is not defined.
   * @throws IllegalArgumentException when a field <code>name</code> does not exist.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  int fieldIndex (java.lang.String name)  ;
  /**
   * Returns a Map consisting of names and values for the requested fieldNames
   * For primitive types if value is null it returns 'zero value' specific for primitive
   * i.e. 0 for Int - use isNullAt to ensure that value is not null
   * <p>
   * @throws UnsupportedOperationException when schema is not defined.
   * @throws IllegalArgumentException when fieldName do not exist.
   * @throws ClassCastException when data type does not match.
   * @param fieldNames (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> scala.collection.immutable.Map<java.lang.String, T> getValuesMap (scala.collection.Seq<java.lang.String> fieldNames)  ;
  public  java.lang.String toString ()  ;
  /**
   * Make a copy of the current {@link Row} object.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Row copy ()  ;
  /** Returns true if there are any NULL values in this row. */
  public  boolean anyNull ()  ;
  public  boolean equals (Object o)  ;
  public  int hashCode ()  ;
  /**
   * Return a Scala Seq representing the row. Elements are placed in the same order in the Seq.
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.Object> toSeq ()  ;
  /** Displays all elements of this sequence in a string (without a separator). */
  public  java.lang.String mkString ()  ;
  /** Displays all elements of this sequence in a string using a separator string. */
  public  java.lang.String mkString (java.lang.String sep)  ;
  /**
   * Displays all elements of this traversable or iterator in a string using
   * start, end, and separator strings.
   * @param start (undocumented)
   * @param sep (undocumented)
   * @param end (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String mkString (java.lang.String start, java.lang.String sep, java.lang.String end)  ;
  /**
   * Returns the value at position i.
   * <p>
   * @throws UnsupportedOperationException when schema is not defined.
   * @throws ClassCastException when data type does not match.
   * @throws NullPointerException when value is null.
   * @param i (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T getAnyValAs (int i)  ;
  /**
   * The compact JSON representation of this row.
   * @since 3.0
   * @return (undocumented)
   */
  public  java.lang.String json ()  ;
  /**
   * The pretty (i.e. indented) JSON representation of this row.
   * @since 3.0
   * @return (undocumented)
   */
  public  java.lang.String prettyJson ()  ;
  /**
   * JSON representation of the row.
   * <p>
   * Note that this only supports the data types that are also supported by
   * {@link org.apache.spark.sql.catalyst.encoders.RowEncoder}.
   * <p>
   * @return the JSON representation of the row.
   */
    org.json4s.JsonAST.JValue jsonValue ()  ;
}
