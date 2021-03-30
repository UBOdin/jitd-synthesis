package org.apache.spark.sql.catalyst.analysis;
public  class UnresolvedAttribute$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UnresolvedAttribute$ MODULE$ = null;
  public   UnresolvedAttribute$ ()  { throw new RuntimeException(); }
  /**
   * Creates an {@link UnresolvedAttribute}, parsing segments separated by dots ('.').
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute apply (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Creates an {@link UnresolvedAttribute}, from a single quoted string (for example using backticks in
   * HiveQL.  Since the string is consider quoted, no processing is done on the name.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute quoted (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Creates an {@link UnresolvedAttribute} from a string in an embedded language.  In this case
   * we treat it as a quoted identifier, except for '.', which must be further quoted using
   * backticks if it is part of a column name.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.analysis.UnresolvedAttribute quotedString (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Used to split attribute name by dot with backticks rule.
   * Backticks must appear in pairs, and the quoted string must be a complete name part,
   * which means <code>ab..c</code>e.f is not allowed.
   * Escape character is not supported now, so we can't use backtick inside name part.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> parseAttributeName (java.lang.String name)  { throw new RuntimeException(); }
}
