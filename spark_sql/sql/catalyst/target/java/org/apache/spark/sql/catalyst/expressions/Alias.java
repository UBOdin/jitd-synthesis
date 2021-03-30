package org.apache.spark.sql.catalyst.expressions;
/**
 * Used to assign a new name to a computation.
 * For example the SQL expression "1 + 1 AS a" could be represented as follows:
 *  Alias(Add(Literal(1), Literal(1)), "a")()
 * <p>
 * Note that exprId and qualifiers are in a separate parameter list because
 * we only pattern match on child and name.
 * <p>
 * Note that when creating a new Alias, all the {@link AttributeReference} that refer to
 * the original alias should be updated to the new one.
 * <p>
 * param:  child The computation being performed
 * param:  name The name to be associated with the result of computing {@link child}.
 * param:  exprId A globally unique id used to check if an {@link AttributeReference} refers to this
 *               alias. Auto-assigned if left blank.
 * param:  qualifier An optional Seq of string that can be used to refer to this attribute in a
 *                  fully qualified way. Consider the examples tableName.name, subQueryAlias.name.
 *                  tableName and subQueryAlias are possible qualifiers.
 * param:  explicitMetadata Explicit metadata associated with this alias that overwrites child's.
 * param:  nonInheritableMetadataKeys Keys of metadata entries that are supposed to be removed when
 *                                   inheriting the metadata from the child.
 */
public  class Alias extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NamedExpression, scala.Product, scala.Serializable {
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.Metadata> explicitMetadata ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> nonInheritableMetadataKeys ()  { throw new RuntimeException(); }
  // not preceding
  public   Alias (org.apache.spark.sql.catalyst.expressions.Expression child, java.lang.String name, org.apache.spark.sql.catalyst.expressions.ExprId exprId, scala.collection.Seq<java.lang.String> qualifier, scala.Option<org.apache.spark.sql.types.Metadata> explicitMetadata, scala.collection.Seq<java.lang.String> nonInheritableMetadataKeys)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  /** Just a simple passthrough for code generation. */
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode genCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Metadata metadata ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression newInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected final  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
