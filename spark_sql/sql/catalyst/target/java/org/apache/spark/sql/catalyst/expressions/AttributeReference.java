package org.apache.spark.sql.catalyst.expressions;
/**
 * A reference to an attribute produced by another operator in the tree.
 * <p>
 * param:  name The name of this attribute, should only be used during analysis or for debugging.
 * param:  dataType The {@link DataType} of this attribute.
 * param:  nullable True if null is a valid value for this attribute.
 * param:  metadata The metadata of this attribute.
 * param:  exprId A globally unique id used to check if different AttributeReferences refer to the
 *               same attribute.
 * param:  qualifier An optional string that can be used to referred to this attribute in a fully
 *                  qualified way. Consider the examples tableName.name, subQueryAlias.name.
 *                  tableName and subQueryAlias are possible qualifiers.
 */
public  class AttributeReference extends org.apache.spark.sql.catalyst.expressions.Attribute implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.Metadata metadata ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  // not preceding
  public   AttributeReference (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable, org.apache.spark.sql.types.Metadata metadata, org.apache.spark.sql.catalyst.expressions.ExprId exprId, scala.collection.Seq<java.lang.String> qualifier)  { throw new RuntimeException(); }
  /**
   * Returns true iff the expression id is the same for both attributes.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean sameRef (org.apache.spark.sql.catalyst.expressions.AttributeReference other)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression other)  { throw new RuntimeException(); }
  public  int semanticHash ()  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference newInstance ()  { throw new RuntimeException(); }
  /**
   * Returns a copy of this {@link AttributeReference} with changed nullability.
   * @param newNullability (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withNullability (boolean newNullability)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withName (java.lang.String newName)  { throw new RuntimeException(); }
  /**
   * Returns a copy of this {@link AttributeReference} with new qualifier.
   * @param newQualifier (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withQualifier (scala.collection.Seq<java.lang.String> newQualifier)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withExprId (org.apache.spark.sql.catalyst.expressions.ExprId newExprId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference withMetadata (org.apache.spark.sql.types.Metadata newMetadata)  { throw new RuntimeException(); }
  protected final  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
