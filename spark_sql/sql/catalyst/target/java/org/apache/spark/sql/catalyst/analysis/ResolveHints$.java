package org.apache.spark.sql.catalyst.analysis;
/**
 * Collection of rules related to hints. The only hint currently available is join strategy hint.
 * <p>
 * Note that this is separately into two rules because in the future we might introduce new hint
 * rules that have different ordering requirements from join strategies.
 */
public  class ResolveHints$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ResolveHints$ MODULE$ = null;
  public   ResolveHints$ ()  { throw new RuntimeException(); }
}
