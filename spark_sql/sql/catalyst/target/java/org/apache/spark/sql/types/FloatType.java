package org.apache.spark.sql.types;
/**
 * The data type representing <code>Float</code> values. Please use the singleton <code>DataTypes.FloatType</code>.
 * <p>
 * @since 1.3.0
 */
public  class FloatType extends org.apache.spark.sql.types.FractionalType {
  static public  interface FloatAsIfIntegral extends org.apache.spark.sql.types.FloatType.FloatIsConflicted, scala.math.Integral<java.lang.Object> {
    public  float quot (float x, float y)  ;
    public  float rem (float x, float y)  ;
  }
  static public  class FloatAsIfIntegral$ implements org.apache.spark.sql.types.FloatType.FloatAsIfIntegral {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final FloatAsIfIntegral$ MODULE$ = null;
    public   FloatAsIfIntegral$ ()  { throw new RuntimeException(); }
    public  int compare (float x, float y)  { throw new RuntimeException(); }
  }
  static public  interface FloatIsConflicted extends scala.math.Numeric<java.lang.Object> {
    public  float abs (float x)  ;
    public  float fromInt (int x)  ;
    public  float minus (float x, float y)  ;
    public  float negate (float x)  ;
    public  scala.Option<java.lang.Object> parseString (java.lang.String str)  ;
    public  float plus (float x, float y)  ;
    public  float times (float x, float y)  ;
    public  double toDouble (float x)  ;
    public  float toFloat (float x)  ;
    public  int toInt (float x)  ;
    public  long toLong (float x)  ;
  }
  static   boolean unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static public  java.lang.String typeName ()  { throw new RuntimeException(); }
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
    scala.math.Numeric<java.lang.Object> numeric ()  { throw new RuntimeException(); }
    scala.math.Fractional<java.lang.Object> fractional ()  { throw new RuntimeException(); }
    scala.math.Ordering<java.lang.Object> ordering ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.FloatType.FloatAsIfIntegral$ asIntegral ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.FloatExactNumeric$ exactNumeric ()  { throw new RuntimeException(); }
  /**
   * The default size of a value of the FloatType is 4 bytes.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.FloatType asNullable ()  { throw new RuntimeException(); }
}
