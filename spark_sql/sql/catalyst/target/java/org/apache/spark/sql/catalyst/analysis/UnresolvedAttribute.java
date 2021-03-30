package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the name of an attribute that has yet to be resolved.
 */
public  class UnresolvedAttribute extends org.apache.spark.sql.catalyst.expressions.Attribute implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  /**
   * Creates an {@link UnresolvedAttribute}, parsing segments separated by dots ('.').
   * @param name (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute apply (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Creates an {@link UnresolvedAttribute}, from a single quoted string (for example using backticks in
   * HiveQL.  Since the string is consider quoted, no processing is done on the name.
   * @param name (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute quoted (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Creates an {@link UnresolvedAttribute} from a string in an embedded language.  In this case
   * we treat it as a quoted identifier, except for '.', which must be further quoted using
   * backticks if it is part of a column name.
   * @param name (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute quotedString (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Used to split attribute name by dot with backticks rule.
   * Backticks must appear in pairs, and the quoted string must be a complete name part,
   * which means <code>ab..c</code>e.f is not allowed.
   * Escape character is not supported now, so we can't use backtick inside name part.
   * @param name (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<java.lang.String> parseAttributeName (java.lang.String name)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> nameParts ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedAttribute (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute newInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute withNullability (boolean newNullability)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute withQualifier (scala.collection.Seq<java.lang.String> newQualifier)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute withName (java.lang.String newName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withMetadata (org.apache.spark.sql.types.Metadata newMetadata)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute withExprId (org.apache.spark.sql.catalyst.expressions.ExprId newExprId)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
