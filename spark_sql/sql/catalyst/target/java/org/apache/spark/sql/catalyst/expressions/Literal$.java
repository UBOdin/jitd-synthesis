package org.apache.spark.sql.catalyst.expressions;
public  class Literal$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Literal$ MODULE$ = null;
  public   Literal$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Literal TrueLiteral ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Literal FalseLiteral ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Literal apply (Object v)  { throw new RuntimeException(); }
  /**
   * Constructs a {@link Literal} of {@link ObjectType}, for example when you need to pass an object
   * into code generation.
   * @param obj (undocumented)
   * @param objType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal fromObject (Object obj, org.apache.spark.sql.types.DataType objType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Literal fromObject (Object obj)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Literal create (Object v, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.sql.catalyst.expressions.Literal create (T v, scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
    void validateLiteralValue (Object value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
