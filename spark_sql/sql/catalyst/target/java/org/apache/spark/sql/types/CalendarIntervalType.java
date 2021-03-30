package org.apache.spark.sql.types;
/**
 * The data type representing calendar intervals. The calendar interval is stored internally in
 * three components:
 *   an integer value representing the number of <code>months</code> in this interval,
 *   an integer value representing the number of <code>days</code> in this interval,
 *   a long value representing the number of <code>microseconds</code> in this interval.
 * <p>
 * Please use the singleton <code>DataTypes.CalendarIntervalType</code> to refer the type.
 * <p>
 * @note Calendar intervals are not comparable.
 * <p>
 * @since 1.5.0
 */
public  class CalendarIntervalType extends org.apache.spark.sql.types.DataType {
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
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  java.lang.String typeName ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.CalendarIntervalType asNullable ()  { throw new RuntimeException(); }
}
