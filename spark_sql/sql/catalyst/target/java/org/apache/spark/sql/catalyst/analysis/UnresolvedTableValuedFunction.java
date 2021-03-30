package org.apache.spark.sql.catalyst.analysis;
/**
 * A table-valued function, e.g.
 * <pre><code>
 *   select id from range(10);
 *
 *   // Assign alias names
 *   select t.a from range(10) t(a);
 * </code></pre>
 * <p>
 * param:  name qualified name of this table-value function
 * param:  functionArgs list of function arguments
 * param:  outputNames alias names of function output columns. If these names given, an analyzer
 *                    adds {@link Project} to rename the output columns.
 */
public  class UnresolvedTableValuedFunction extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.analysis.UnresolvedTableValuedFunction apply (java.lang.String name, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionArgs, scala.collection.Seq<java.lang.String> outputNames)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.FunctionIdentifier name ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionArgs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputNames ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedTableValuedFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionArgs, scala.collection.Seq<java.lang.String> outputNames)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
