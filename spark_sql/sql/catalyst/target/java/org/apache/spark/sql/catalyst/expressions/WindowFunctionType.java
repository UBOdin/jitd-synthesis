package org.apache.spark.sql.catalyst.expressions;
/**
 * Case objects that describe whether a window function is a SQL window function or a Python
 * user-defined window function.
 */
public  interface WindowFunctionType {
  static public  class SQL$ implements org.apache.spark.sql.catalyst.expressions.WindowFunctionType, scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final SQL$ MODULE$ = null;
    public   SQL$ ()  { throw new RuntimeException(); }
  }
  static public  class Python$ implements org.apache.spark.sql.catalyst.expressions.WindowFunctionType, scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Python$ MODULE$ = null;
    public   Python$ ()  { throw new RuntimeException(); }
  }
}
