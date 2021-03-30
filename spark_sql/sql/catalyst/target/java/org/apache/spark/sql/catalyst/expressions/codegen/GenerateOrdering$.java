package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Generates bytecode for an {@link Ordering} of rows for a given set of expressions.
 */
public  class GenerateOrdering$ extends org.apache.spark.sql.catalyst.expressions.codegen.CodeGenerator<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>, org.apache.spark.sql.catalyst.expressions.BaseOrdering> implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GenerateOrdering$ MODULE$ = null;
  public   GenerateOrdering$ ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> canonicalize (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> in)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> bind (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  /**
   * Creates a code gen ordering for sorting this schema, in ascending order.
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.BaseOrdering create (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Generates the code for comparing a struct type according to its natural ordering
   * (i.e. ascending order by field 1, then field 2, ..., then field n.
   * @param ctx (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String genComparisons (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Generates the code for ordering based on the given order.
   * @param ctx (undocumented)
   * @param ordering (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String genComparisons (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BaseOrdering create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering)  { throw new RuntimeException(); }
}
