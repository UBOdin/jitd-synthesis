package org.apache.spark.sql.catalyst.expressions;
public  interface PathInstruction {
  static public  class Subscript$ implements org.apache.spark.sql.catalyst.expressions.PathInstruction, scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Subscript$ MODULE$ = null;
    public   Subscript$ ()  { throw new RuntimeException(); }
  }
  static public  class Wildcard$ implements org.apache.spark.sql.catalyst.expressions.PathInstruction, scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Wildcard$ MODULE$ = null;
    public   Wildcard$ ()  { throw new RuntimeException(); }
  }
  static public  class Key$ implements org.apache.spark.sql.catalyst.expressions.PathInstruction, scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Key$ MODULE$ = null;
    public   Key$ ()  { throw new RuntimeException(); }
  }
  static   class Index implements org.apache.spark.sql.catalyst.expressions.PathInstruction, scala.Product, scala.Serializable {
    public  long index ()  { throw new RuntimeException(); }
    // not preceding
    public   Index (long index)  { throw new RuntimeException(); }
  }
  static public  class Index$ extends scala.runtime.AbstractFunction1<java.lang.Object, org.apache.spark.sql.catalyst.expressions.PathInstruction.Index> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Index$ MODULE$ = null;
    public   Index$ ()  { throw new RuntimeException(); }
  }
  static   class Named implements org.apache.spark.sql.catalyst.expressions.PathInstruction, scala.Product, scala.Serializable {
    public  java.lang.String name ()  { throw new RuntimeException(); }
    // not preceding
    public   Named (java.lang.String name)  { throw new RuntimeException(); }
  }
  static public  class Named$ extends scala.runtime.AbstractFunction1<java.lang.String, org.apache.spark.sql.catalyst.expressions.PathInstruction.Named> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Named$ MODULE$ = null;
    public   Named$ ()  { throw new RuntimeException(); }
  }
}
