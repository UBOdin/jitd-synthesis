package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Generates byte code that produces a {@link InternalRow} object (not an {@link UnsafeRow}) that can update
 * itself based on a new input {@link InternalRow} for a fixed set of {@link Expression Expressions}.
 */
public  class GenerateSafeProjection$ extends org.apache.spark.sql.catalyst.expressions.codegen.CodeGenerator<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.expressions.Projection> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GenerateSafeProjection$ MODULE$ = null;
  public   GenerateSafeProjection$ ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> canonicalize (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> bind (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Projection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
}
