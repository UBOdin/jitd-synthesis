package org.apache.spark.sql.catalyst.expressions;
/**
 * Rewrites an expression using rules that are guaranteed preserve the result while attempting
 * to remove cosmetic variations. Deterministic expressions that are <code>equal</code> after canonicalization
 * will always return the same answer given the same input (i.e. false positives should not be
 * possible). However, it is possible that two canonical expressions that are not equal will in fact
 * return the same answer given any input (i.e. false negatives are possible).
 * <p>
 * The following rules are applied:
 *  - Names and nullability hints for {@link org.apache.spark.sql.types.DataType}s are stripped.
 *  - Names for {@link GetStructField} are stripped.
 *  - TimeZoneId for {@link Cast} and {@link AnsiCast} are stripped if <code>needsTimeZone</code> is false.
 *  - Commutative and associative operations ({@link Add} and {@link Multiply}) have their children ordered
 *    by <code>hashCode</code>.
 *  - {@link EqualTo} and {@link EqualNullSafe} are reordered by <code>hashCode</code>.
 *  - Other comparisons ({@link GreaterThan}, {@link LessThan}) are reversed by <code>hashCode</code>.
 *  - Elements in {@link In} are reordered by <code>hashCode</code>.
 */
public  class Canonicalize$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Canonicalize$ MODULE$ = null;
  public   Canonicalize$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression execute (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /** Remove names and nullability from types, and names from `GetStructField`. */
    org.apache.spark.sql.catalyst.expressions.Expression ignoreNamesTypes (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /** Remove TimeZoneId for Cast if needsTimeZone return false. */
    org.apache.spark.sql.catalyst.expressions.Expression ignoreTimeZone (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
}
