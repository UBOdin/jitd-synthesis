package org.apache.spark.sql.catalyst.analysis;
/**
 * A trivial {@link Analyzer} with a dummy {@link SessionCatalog} and {@link EmptyFunctionRegistry}.
 * Used for testing when all relations are already filled in and the analyzer needs only
 * to resolve attribute references.
 */
public  class SimpleAnalyzer$ extends org.apache.spark.sql.catalyst.analysis.Analyzer {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SimpleAnalyzer$ MODULE$ = null;
  public   SimpleAnalyzer$ ()  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
}
