package org.apache.spark.sql.types;
public  class ArrayType extends org.apache.spark.sql.types.DataType implements scala.Product, scala.Serializable {
  /**
   * Construct a {@link ArrayType} object with the given element type. The <code>containsNull</code> is true.
   * @param elementType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.ArrayType apply (org.apache.spark.sql.types.DataType elementType)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
  static   boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType elementType ()  { throw new RuntimeException(); }
  public  boolean containsNull ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrayType (org.apache.spark.sql.types.DataType elementType, boolean containsNull)  { throw new RuntimeException(); }
  /** No-arg constructor for kryo. */
  protected   ArrayType ()  { throw new RuntimeException(); }
    void buildFormattedString (java.lang.String prefix, org.apache.spark.sql.catalyst.util.StringUtils.StringConcat stringConcat, int maxDepth)  { throw new RuntimeException(); }
    org.json4s.JsonAST.JObject jsonValue ()  { throw new RuntimeException(); }
  /**
   * The default size of a value of the ArrayType is the default size of the element type.
   * We assume that there is only 1 element on average in an array. See SPARK-18853.
   * @return (undocumented)
   */
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  public  java.lang.String catalogString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.ArrayType asNullable ()  { throw new RuntimeException(); }
    boolean existsRecursively (scala.Function1<org.apache.spark.sql.types.DataType, java.lang.Object> f)  { throw new RuntimeException(); }
  // not preceding
    scala.math.Ordering<org.apache.spark.sql.catalyst.util.ArrayData> interpretedOrdering ()  { throw new RuntimeException(); }
}
