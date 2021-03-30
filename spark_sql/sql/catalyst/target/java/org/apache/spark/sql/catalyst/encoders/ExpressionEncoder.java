package org.apache.spark.sql.catalyst.encoders;
public  class ExpressionEncoder<T extends java.lang.Object> implements org.apache.spark.sql.Encoder<T>, scala.Product, scala.Serializable {
  /**
   * Function that deserializes an {@link InternalRow} into an object of type <code>T</code>. This class is not
   * thread-safe.
   */
  static public  class Deserializer<T extends java.lang.Object> implements scala.Function1<org.apache.spark.sql.catalyst.InternalRow, T>, scala.Serializable {
    // not preceding
    public   Deserializer (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
    public  T apply (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  }
  /**
   * Function that serializes an object of type <code>T</code> to an {@link InternalRow}. This class is not
   * thread-safe. Note that multiple calls to <code>apply(..)</code> return the same actual {@link InternalRow}
   * object.  Thus, the caller should copy the result before making another call if required.
   */
  static public  class Serializer<T extends java.lang.Object> implements scala.Function1<T, org.apache.spark.sql.catalyst.InternalRow>, scala.Serializable {
    // not preceding
    public   Serializer (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.InternalRow apply (T t)  { throw new RuntimeException(); }
  }
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> apply (scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> javaBean (java.lang.Class<T> beanClass)  { throw new RuntimeException(); }
  /**
   * Given a set of N encoders, constructs a new encoder that produce objects as items in an
   * N-tuple.  Note that these encoders should be unresolved so that information about
   * name/positional binding is preserved.
   * @param encoders (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?> tuple (scala.collection.Seq<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?>> encoders)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple1<T>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> e)  { throw new RuntimeException(); }
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple2<T1, T2>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2)  { throw new RuntimeException(); }
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple3<T1, T2, T3>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T3> e3)  { throw new RuntimeException(); }
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object, T4 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple4<T1, T2, T3, T4>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T3> e3, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T4> e4)  { throw new RuntimeException(); }
  static public <T1 extends java.lang.Object, T2 extends java.lang.Object, T3 extends java.lang.Object, T4 extends java.lang.Object, T5 extends java.lang.Object> org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<scala.Tuple5<T1, T2, T3, T4, T5>> tuple (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T1> e1, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T2> e2, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T3> e3, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T4> e4, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T5> e5)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression objSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression objDeserializer ()  { throw new RuntimeException(); }
  public  scala.reflect.ClassTag<T> clsTag ()  { throw new RuntimeException(); }
  // not preceding
  public   ExpressionEncoder (org.apache.spark.sql.catalyst.expressions.Expression objSerializer, org.apache.spark.sql.catalyst.expressions.Expression objDeserializer, scala.reflect.ClassTag<T> clsTag)  { throw new RuntimeException(); }
  /**
   * A sequence of expressions, one for each top-level field that can be used to
   * extract the values from a raw object into an {@link InternalRow}:
   * 1. If <code>serializer</code> encodes a raw object to a struct, strip the outer If-IsNull and get
   *    the <code>CreateNamedStruct</code>.
   * 2. For other cases, wrap the single serializer with <code>CreateNamedStruct</code>.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> serializer ()  { throw new RuntimeException(); }
  /**
   * Returns an expression that can be used to deserialize an input row to an object of type <code>T</code>
   * with a compatible schema. Fields of the row will be extracted using <code>UnresolvedAttribute</code>.
   * of the same name as the constructor arguments.
   * <p>
   * For complex objects that are encoded to structs, Fields of the struct will be extracted using
   * <code>GetColumnByOrdinal</code> with corresponding ordinal.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  /**
   * Returns true if the type <code>T</code> is serialized as a struct by <code>objSerializer</code>.
   * @return (undocumented)
   */
  public  boolean isSerializedAsStruct ()  { throw new RuntimeException(); }
  /**
   * If the type <code>T</code> is serialized as a struct, when it is encoded to a Spark SQL row, fields in
   * the struct are naturally mapped to top-level columns in a row. In other words, the serialized
   * struct is flattened to row. But in case of the <code>T</code> is also an <code>Option</code> type, it can't be
   * flattened to top-level row, because in Spark SQL top-level row can't be null. This method
   * returns true if <code>T</code> is serialized as struct and is not <code>Option</code> type.
   * @return (undocumented)
   */
  public  boolean isSerializedAsStructForTopLevel ()  { throw new RuntimeException(); }
  /**
   * Returns a new copy of this encoder, where the <code>deserializer</code> is resolved and bound to the
   * given schema.
   * <p>
   * Note that, ideally encoder is used as a container of serde expressions, the resolution and
   * binding stuff should happen inside query framework.  However, in some cases we need to
   * use encoder as a function to do serialization directly(e.g. Dataset.collect), then we can use
   * this method to do resolution and binding outside of query framework.
   * @param attrs (undocumented)
   * @param analyzer (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> resolveAndBind (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> attrs, org.apache.spark.sql.catalyst.analysis.Analyzer analyzer)  { throw new RuntimeException(); }
  /**
   * Returns a new set (with unique ids) of {@link NamedExpression} that represent the serialized form
   * of this object.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> namedExpressions ()  { throw new RuntimeException(); }
  /**
   * Create a serializer that can convert an object of type <code>T</code> to a Spark SQL Row.
   * <p>
   * Note that the returned {@link Serializer} is not thread safe. Multiple calls to
   * <code>serializer.apply(..)</code> are allowed to return the same actual {@link InternalRow} object.  Thus,
   *  the caller should copy the result before making another call if required.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder.Serializer<T> createSerializer ()  { throw new RuntimeException(); }
  /**
   * Create a deserializer that can convert a Spark SQL Row into an object of type <code>T</code>.
   * <p>
   * Note that you must <code>resolveAndBind</code> an encoder to a specific schema before you can create a
   * deserializer.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder.Deserializer<T> createDeserializer ()  { throw new RuntimeException(); }
  /**
   * The process of resolution to a given schema throws away information about where a given field
   * is being bound by ordinal instead of by name.  This method checks to make sure this process
   * has not been done already in places where we plan to do later composition of encoders.
   */
  public  void assertUnresolved ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<java.lang.String> attrs ()  { throw new RuntimeException(); }
  protected  java.lang.String schemaString ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
