package org.apache.spark.sql.catalyst.expressions;
public  class Literal extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.Literal TrueLiteral ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Literal FalseLiteral ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Literal apply (Object v)  { throw new RuntimeException(); }
  /**
   * Constructs a {@link Literal} of {@link ObjectType}, for example when you need to pass an object
   * into code generation.
   * @param obj (undocumented)
   * @param objType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.Literal fromObject (Object obj, org.apache.spark.sql.types.DataType objType)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Literal fromObject (Object obj)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Literal create (Object v, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.expressions.Literal create (T v, scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
  static   void validateLiteralValue (Object value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  Object value ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public   Literal (Object value, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  protected  scala.collection.immutable.List<scala.Tuple2<java.lang.String, org.json4s.JsonAST.JValue>> jsonFields ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
