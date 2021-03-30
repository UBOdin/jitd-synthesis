package org.apache.spark.sql.catalyst.expressions;
public  class AnsiCast$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AnsiCast$ MODULE$ = null;
  public   AnsiCast$ ()  { throw new RuntimeException(); }
  /**
   * As per section 6.13 "cast specification" in "Information technology &#x2014; Database languages " +
   * "- SQL &#x2014; Part 2: Foundation (SQL/Foundation)":
   * If the <cast operand> is a <value expression>, then the valid combinations of TD and SD
   * in a <cast specification> are given by the following table. &amp;ldquo;Y&amp;rdquo; indicates that the
   * combination is syntactically valid without restriction; &amp;ldquo;M&amp;rdquo; indicates that the combination
   * is valid subject to other Syntax Rules in this Sub- clause being satisfied; and &amp;ldquo;N&amp;rdquo; indicates
   * that the combination is not valid:
   * SD                   TD
   *     EN AN C D T TS YM DT BO UDT B RT CT RW
   * EN  Y  Y  Y N N  N  M  M  N   M N  M  N N
   * AN  Y  Y  Y N N  N  N  N  N   M N  M  N N
   * C   Y  Y  Y Y Y  Y  Y  Y  Y   M N  M  N N
   * D   N  N  Y Y N  Y  N  N  N   M N  M  N N
   * T   N  N  Y N Y  Y  N  N  N   M N  M  N N
   * TS  N  N  Y Y Y  Y  N  N  N   M N  M  N N
   * YM  M  N  Y N N  N  Y  N  N   M N  M  N N
   * DT  M  N  Y N N  N  N  Y  N   M N  M  N N
   * BO  N  N  Y N N  N  N  N  Y   M N  M  N N
   * UDT M  M  M M M  M  M  M  M   M M  M  M N
   * B   N  N  N N N  N  N  N  N   M Y  M  N N
   * RT  M  M  M M M  M  M  M  M   M M  M  N N
   * CT  N  N  N N N  N  N  N  N   M N  N  M N
   * RW  N  N  N N N  N  N  N  N   N N  N  N M
   * <p>
   * Where:
   *   EN  = Exact Numeric
   *   AN  = Approximate Numeric
   *   C   = Character (Fixed- or Variable-Length, or Character Large Object)
   *   D   = Date
   *   T   = Time
   *   TS  = Timestamp
   *   YM  = Year-Month Interval
   *   DT  = Day-Time Interval
   *   BO  = Boolean
   *   UDT  = User-Defined Type
   *   B   = Binary (Fixed- or Variable-Length or Binary Large Object)
   *   RT  = Reference type
   *   CT  = Collection type
   *   RW  = Row type
   * <p>
   * Spark's ANSI mode follows the syntax rules, except it specially allow the following
   * straightforward type conversions which are disallowed as per the SQL standard:
   *   - Numeric <=&gt; Boolean
   *   - String <=&gt; Binary
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean canCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  public  java.lang.String typeCheckFailureMessage (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to, java.lang.String fallbackConfKey, java.lang.String fallbackConfValue)  { throw new RuntimeException(); }
}
