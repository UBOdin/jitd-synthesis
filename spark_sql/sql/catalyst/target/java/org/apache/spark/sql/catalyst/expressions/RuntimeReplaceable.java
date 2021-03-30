package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that gets replaced at runtime (currently by the optimizer) into a different
 * expression for evaluation. This is mainly used to provide compatibility with other databases.
 * For example, we use this to support "nvl" by replacing it with "coalesce".
 * <p>
 * A RuntimeReplaceable should have the original parameters along with a "child" expression in the
 * case class constructor, and define a normal constructor that accepts only the original
 * parameters. For an example, see {@link Nvl}. To make sure the explain plan and expression SQL
 * works correctly, the implementation should also override flatArguments method and sql method.
 */
public  interface RuntimeReplaceable extends org.apache.spark.sql.catalyst.expressions.Unevaluable {
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  ;
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  /**
   * Only used to generate SQL representation of this expression.
   * <p>
   * Implementations should override this with original parameters
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprsReplaced ()  ;
  public  java.lang.String mkString (scala.collection.Seq<java.lang.String> childrenString)  ;
  public  boolean nullable ()  ;
  public  java.lang.String sql ()  ;
}
