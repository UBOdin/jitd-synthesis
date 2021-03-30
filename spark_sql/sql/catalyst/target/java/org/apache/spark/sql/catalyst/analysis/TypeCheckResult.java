package org.apache.spark.sql.catalyst.analysis;
/**
 * Represents the result of <code>Expression.checkInputDataTypes</code>.
 * We will throw <code>AnalysisException</code> in <code>CheckAnalysis</code> if <code>isFailure</code> is true.
 */
public  interface TypeCheckResult {
  /**
   * Represents the successful result of <code>Expression.checkInputDataTypes</code>.
   */
  static public  class TypeCheckSuccess$ implements org.apache.spark.sql.catalyst.analysis.TypeCheckResult {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final TypeCheckSuccess$ MODULE$ = null;
    public   TypeCheckSuccess$ ()  { throw new RuntimeException(); }
    public  boolean isSuccess ()  { throw new RuntimeException(); }
  }
  /**
   * Represents the failing result of <code>Expression.checkInputDataTypes</code>,
   * with an error message to show the reason of failure.
   */
  static public  class TypeCheckFailure implements org.apache.spark.sql.catalyst.analysis.TypeCheckResult, scala.Product, scala.Serializable {
    public  java.lang.String message ()  { throw new RuntimeException(); }
    // not preceding
    public   TypeCheckFailure (java.lang.String message)  { throw new RuntimeException(); }
    public  boolean isSuccess ()  { throw new RuntimeException(); }
  }
  static public  class TypeCheckFailure$ extends scala.runtime.AbstractFunction1<java.lang.String, org.apache.spark.sql.catalyst.analysis.TypeCheckResult.TypeCheckFailure> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final TypeCheckFailure$ MODULE$ = null;
    public   TypeCheckFailure$ ()  { throw new RuntimeException(); }
  }
  public  boolean isFailure ()  ;
  public  boolean isSuccess ()  ;
}
