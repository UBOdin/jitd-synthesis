package org.apache.spark.sql.catalyst.expressions;
/**
 * This class is used to compute equality of (sub)expression trees. Expressions can be added
 * to this class and they subsequently query for expression equality. Expression trees are
 * considered equal if for the same input(s), the same result is produced.
 */
public  class EquivalentExpressions {
  /**
   * Wrapper around an Expression that provides semantic equality.
   */
  public  class Expr implements scala.Product, scala.Serializable {
    static public abstract  R apply (T1 v1)  ;
    static public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.Expression e ()  { throw new RuntimeException(); }
    // not preceding
    public   Expr (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
    public  boolean equals (Object o)  { throw new RuntimeException(); }
    public  int hashCode ()  { throw new RuntimeException(); }
  }
  public  class Expr$ extends scala.runtime.AbstractFunction1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.EquivalentExpressions.Expr> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Expr$ MODULE$ = null;
    public   Expr$ ()  { throw new RuntimeException(); }
  }
  public   EquivalentExpressions ()  { throw new RuntimeException(); }
  /**
   * Adds each expression to this data structure, grouping them with existing equivalent
   * expressions. Non-recursive.
   * Returns true if there was already a matching expression.
   * @param expr (undocumented)
   * @return (undocumented)
   */
  public  boolean addExpr (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  /**
   * Adds the expression to this data structure recursively. Stops if a matching expression
   * is found. That is, if <code>expr</code> has already been added, its children are not added.
   * @param expr (undocumented)
   * @param addFunc (undocumented)
   */
  public  void addExprTree (org.apache.spark.sql.catalyst.expressions.Expression expr, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, java.lang.Object> addFunc)  { throw new RuntimeException(); }
  /**
   * Returns the state of the data structure as a string. If <code>all</code> is false, skips sets of
   * equivalent expressions with cardinality 1.
   * @param all (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String debugString (boolean all)  { throw new RuntimeException(); }
  /**
   * Returns all the equivalent sets of expressions.
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> getAllEquivalentExprs ()  { throw new RuntimeException(); }
  /**
   * Returns all of the expression trees that are equivalent to <code>e</code>. Returns
   * an empty collection if there are none.
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> getEquivalentExprs (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
}
