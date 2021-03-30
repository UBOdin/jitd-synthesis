package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Generates byte code that produces a {@link InternalRow} object that can update itself based on a new
 * input {@link InternalRow} for a fixed set of {@link Expression Expressions}.
 * It exposes a <code>target</code> method, which is used to set the row that will be updated.
 * The internal {@link InternalRow} object created internally is used only when <code>target</code> is not used.
 */
public  class GenerateMutableProjection$ extends org.apache.spark.sql.catalyst.expressions.codegen.CodeGenerator<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.expressions.MutableProjection> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GenerateMutableProjection$ MODULE$ = null;
  public   GenerateMutableProjection$ ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> canonicalize (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> bind (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.MutableProjection generate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, boolean useSubexprElimination)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.MutableProjection generate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, boolean useSubexprElimination)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.MutableProjection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  { throw new RuntimeException(); }
}
