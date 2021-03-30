package org.apache.spark.sql.catalyst.expressions;
/**
 * Creates a struct with the given field names and values
 * <p>
 * param:  children Seq(name1, val1, name2, val2, ...)
 */
public  class CreateNamedStruct extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.NoThrow, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateNamedStruct (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public  scala.collection.immutable.List<org.apache.spark.sql.catalyst.expressions.Expression> nameExprs ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.List<org.apache.spark.sql.catalyst.expressions.Expression> valExprs ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.List<java.lang.Object> names ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  /**
   * Returns Aliased {@link Expression}s that could be used to construct a flattened version of this
   * StructType.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> flatten ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
