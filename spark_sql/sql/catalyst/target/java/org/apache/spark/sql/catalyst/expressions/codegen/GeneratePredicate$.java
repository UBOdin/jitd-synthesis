package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Generates bytecode that evaluates a boolean {@link Expression} on a given input {@link InternalRow}.
 */
public  class GeneratePredicate$ extends org.apache.spark.sql.catalyst.expressions.codegen.CodeGenerator<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.BasePredicate> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GeneratePredicate$ MODULE$ = null;
  public   GeneratePredicate$ ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression canonicalize (org.apache.spark.sql.catalyst.expressions.Expression in)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.Expression bind (org.apache.spark.sql.catalyst.expressions.Expression in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.BasePredicate generate (org.apache.spark.sql.catalyst.expressions.Expression expressions, boolean useSubexprElimination)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BasePredicate create (org.apache.spark.sql.catalyst.expressions.Expression predicate)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BasePredicate create (org.apache.spark.sql.catalyst.expressions.Expression predicate, boolean useSubexprElimination)  { throw new RuntimeException(); }
}
