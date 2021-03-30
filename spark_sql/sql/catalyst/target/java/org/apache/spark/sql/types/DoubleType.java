package org.apache.spark.sql.types;
/**
 * The data type representing <code>Double</code> values. Please use the singleton <code>DataTypes.DoubleType</code>.
 * <p>
 * @since 1.3.0
 */
public  class DoubleType extends org.apache.spark.sql.types.FractionalType {
  static public  interface DoubleAsIfIntegral extends org.apache.spark.sql.types.DoubleType.DoubleIsConflicted, scala.math.Integral<java.lang.Object> {
    public  double quot (double x, double y)  ;
    public  double rem (double x, double y)  ;
  }
  static public  class DoubleAsIfIntegral$ implements org.apache.spark.sql.types.DoubleType.DoubleAsIfIntegral {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final DoubleAsIfIntegral$ MODULE$ = null;
    public   DoubleAsIfIntegral$ ()  { throw new RuntimeException(); }
    public  int compare (double x, double y)  { throw new RuntimeException(); }
  }
  static public  interface DoubleIsConflicted extends scala.math.Numeric<java.lang.Object> {
    public  double abs (double x)  ;
    public  double fromInt (int x)  ;
    public  double minus (double x, double y)  ;
    public  double negate (double x)  ;
    public  scala.Option<java.lang.Object> parseString (java.lang.String str)  ;
    public  double plus (double x, double y)  ;
    public  double times (double x, double y)  ;
    public  double toDouble (double x)  ;
    public  float toFloat (double x)  ;
    public  int toInt (double x)  ;
    public  long toLong (double x)  ;
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
    org.apache.spark.sql.types.DoubleType.DoubleAsIfIntegral$ asIntegral ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DoubleExactNumeric$ exactNumeric ()  { throw new RuntimeException(); }
  /**
   * The default size of a value of the DoubleType is 8 bytes.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DoubleType asNullable ()  { throw new RuntimeException(); }
}
