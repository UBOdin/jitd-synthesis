package org.apache.spark.sql.catalyst.expressions;
/**
 * The factory object for <code>MutableProjection</code>.
 */
public  class MutableProjection$ extends org.apache.spark.sql.catalyst.expressions.CodeGeneratorWithInterpretedFallback<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.expressions.MutableProjection> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MutableProjection$ MODULE$ = null;
  public   MutableProjection$ ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.MutableProjection createCodeGeneratedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.MutableProjection createInterpretedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  /**
   * Returns a MutableProjection for given sequence of bound Expressions.
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.MutableProjection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  /**
   * Returns a MutableProjection for given sequence of Expressions, which will be bound to
   * <code>inputSchema</code>.
   * @param exprs (undocumented)
   * @param inputSchema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.MutableProjection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
}
