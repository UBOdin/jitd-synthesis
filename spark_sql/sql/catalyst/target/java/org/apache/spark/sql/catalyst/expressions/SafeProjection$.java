package org.apache.spark.sql.catalyst.expressions;
/**
 * A projection that could turn UnsafeRow into GenericInternalRow
 */
public  class SafeProjection$ extends org.apache.spark.sql.catalyst.expressions.CodeGeneratorWithInterpretedFallback<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.expressions.Projection> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SafeProjection$ MODULE$ = null;
  public   SafeProjection$ ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Projection createCodeGeneratedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Projection createInterpretedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  /**
   * Returns a SafeProjection for given StructType.
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Projection create (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Returns a SafeProjection for given Array of DataTypes.
   * @param fields (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Projection create (org.apache.spark.sql.types.DataType[] fields)  { throw new RuntimeException(); }
  /**
   * Returns a SafeProjection for given sequence of Expressions (bounded).
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Projection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  /**
   * Returns a SafeProjection for given sequence of Expressions, which will be bound to
   * <code>inputSchema</code>.
   * @param exprs (undocumented)
   * @param inputSchema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Projection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
}
