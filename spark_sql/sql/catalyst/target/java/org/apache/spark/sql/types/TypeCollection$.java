package org.apache.spark.sql.types;
public  class TypeCollection$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TypeCollection$ MODULE$ = null;
  public   TypeCollection$ ()  { throw new RuntimeException(); }
  /**
   * Types that include numeric types and interval type. They are only used in unary_minus,
   * unary_positive, add and subtract operations.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.TypeCollection NumericAndInterval ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.TypeCollection apply (scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> types)  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType>> unapply (org.apache.spark.sql.types.AbstractDataType typ)  { throw new RuntimeException(); }
}
