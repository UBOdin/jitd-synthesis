package org.apache.spark.sql.catalyst.encoders;
/**
 * A factory for constructing encoders that convert objects and primitives to and from the
 * internal row format using catalyst expressions and code generation.  By default, the
 * expressions used to retrieve values from an input row when producing an object will be created as
 * follows:
 *  - Classes will have their sub fields extracted by name using {@link UnresolvedAttribute} expressions
 *    and {@link UnresolvedExtractValue} expressions.
 *  - Tuples will have their subfields extracted by position using {@link BoundReference} expressions.
 *  - Primitives will have their values extracted from the first ordinal with a schema that defaults
 *    to the name <code>value</code>.
 */
public  class ExpressionEncoder$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExpressionEncoder$ MODULE$ = null;
  public   ExpressionEncoder$ ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> apply (scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> javaBean (java.lang.Class<T> beanClass)  { throw new RuntimeException(); }
  /**
   * Given a set of N encoders, constructs a new encoder that produce objects as items in an
   * N-tuple.  Note that these encoders should be unresolved so that information about
   * name/positional binding is preserved.
   * @param encoders (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?> tuple (scala.collection.Seq<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?>> encoders)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple1<T>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> e)  { throw new RuntimeException(); }
  public <T1 extends java.lang.Object, T2 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple2<T1, T2>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2)  { throw new RuntimeException(); }
  public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple3<T1, T2, T3>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T3> e3)  { throw new RuntimeException(); }
  public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object, T4 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple4<T1, T2, T3, T4>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T3> e3, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T4> e4)  { throw new RuntimeException(); }
  public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object, T4 extends java.lang.Object, T5 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple5<T1, T2, T3, T4, T5>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T3> e3, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T4> e4, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T5> e5)  { throw new RuntimeException(); }
}
