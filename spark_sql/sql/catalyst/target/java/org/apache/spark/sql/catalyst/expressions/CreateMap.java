package org.apache.spark.sql.catalyst.expressions;
/**
 * Returns a catalyst Map containing the evaluation of all children expressions as keys and values.
 * The children are a flatted sequence of kv pairs, e.g. (key1, value1, key2, value2, ...)
 */
public  class CreateMap extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.NoThrow, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.CreateMap apply (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean useStringTypeWhenEmpty ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateMap (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, boolean useStringTypeWhenEmpty)  { throw new RuntimeException(); }
  public   CreateMap (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.IndexedSeq<org.apache.spark.sql.catalyst.expressions.Expression> keys ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.IndexedSeq<org.apache.spark.sql.catalyst.expressions.Expression> values ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.MapType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
