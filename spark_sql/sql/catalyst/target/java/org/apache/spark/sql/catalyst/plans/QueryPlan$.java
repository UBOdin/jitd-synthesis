package org.apache.spark.sql.catalyst.plans;
public  class QueryPlan$ implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final QueryPlan$ MODULE$ = null;
  public   QueryPlan$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<java.lang.Object> OP_ID_TAG ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<java.lang.Object> CODEGEN_ID_TAG ()  { throw new RuntimeException(); }
  /**
   * Normalize the exprIds in the given expression, by updating the exprId in <code>AttributeReference</code>
   * with its referenced ordinal from input attributes. It's similar to <code>BindReferences</code> but we
   * do not use <code>BindReferences</code> here as the plan may take the expression as a parameter with type
   * <code>Attribute</code>, and replace it with <code>BoundReference</code> will cause error.
   * @param e (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public <T extends org.apache.spark.sql.catalyst.expressions.Expression> T normalizeExpressions (T e, org.apache.spark.sql.catalyst.expressions.AttributeSeq input)  { throw new RuntimeException(); }
  /**
   * Composes the given predicates into a conjunctive predicate, which is normalized and reordered.
   * Then returns a new sequence of predicates by splitting the conjunctive predicate.
   * @param predicates (undocumented)
   * @param output (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> normalizePredicates (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, org.apache.spark.sql.catalyst.expressions.AttributeSeq output)  { throw new RuntimeException(); }
  /**
   * Converts the query plan to string and appends it via provided function.
   * @param plan (undocumented)
   * @param append (undocumented)
   * @param verbose (undocumented)
   * @param addSuffix (undocumented)
   * @param maxFields (undocumented)
   * @param printOperatorId (undocumented)
   */
  public <T extends org.apache.spark.sql.catalyst.plans.QueryPlan<T>> void append (scala.Function0<org.apache.spark.sql.catalyst.plans.QueryPlan<T>> plan, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, boolean addSuffix, int maxFields, boolean printOperatorId)  { throw new RuntimeException(); }
}
