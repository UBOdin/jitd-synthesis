package org.apache.spark.sql.types;
/**
 * The type represents day-time intervals of the SQL standard. A day-time interval is made up
 * of a contiguous subset of the following fields:
 *   - SECOND, seconds within minutes and possibly fractions of a second [0..59.999999],
 *   - MINUTE, minutes within hours [0..59],
 *   - HOUR, hours within days [0..23],
 *   - DAY, days in the range [0..106751991].
 * <p>
 * <code>DayTimeIntervalType</code> represents positive as well as negative day-time intervals.
 * <p>
 * Please use the singleton <code>DataTypes.DayTimeIntervalType</code> to refer the type.
 * <p>
 * @since 3.2.0
 */
public  class DayTimeIntervalType extends org.apache.spark.sql.types.AtomicType {
  static   boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static   org.json4s.JsonAST.JValue jsonValue ()  { throw new RuntimeException(); }
  static public  java.lang.String json ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  static public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  static public  java.lang.String catalogString ()  { throw new RuntimeException(); }
  static   java.lang.String simpleString (int maxNumberFields)  { throw new RuntimeException(); }
  static public  java.lang.String sql ()  { throw new RuntimeException(); }
  static   boolean sameType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  static   boolean existsRecursively (scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> f)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  // not preceding
    scala.reflect.api.TypeTags.TypeTag<java.lang.Object> tag ()  { throw new RuntimeException(); }
    scala.math.Ordering<java.lang.Object> ordering ()  { throw new RuntimeException(); }
  /**
   * The day-time interval type has constant precision. A value of the type always occupies 8 bytes.
   * The DAY field is constrained by the upper bound 106751991 to fit to <code>Long</code>.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DayTimeIntervalType asNullable ()  { throw new RuntimeException(); }
  public  java.lang.String typeName ()  { throw new RuntimeException(); }
}
