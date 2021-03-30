package org.apache.spark.sql.catalyst.optimizer;
/**
 * Unwrap casts in binary comparison operations with patterns like following:
 * <p>
 * <code>BinaryComparison(Cast(fromExp, toType), Literal(value, toType))</code>
 *   or
 * <code>BinaryComparison(Literal(value, toType), Cast(fromExp, toType))</code>
 * <p>
 * This rule optimizes expressions with the above pattern by either replacing the cast with simpler
 * constructs, or moving the cast from the expression side to the literal side, which enables them
 * to be optimized away later and pushed down to data sources.
 * <p>
 * Currently this only handles cases where:
 *   1). <code>fromType</code> (of <code>fromExp</code>) and <code>toType</code> are of numeric types (i.e., short, int, float,
 *     decimal, etc)
 *   2). <code>fromType</code> can be safely coerced to <code>toType</code> without precision loss (e.g., short to int,
 *     int to long, but not long to int)
 * <p>
 * If the above conditions are satisfied, the rule checks to see if the literal <code>value</code> is within
 * range <code>(min, max)</code>, where <code>min</code> and <code>max</code> are the minimum and maximum value of <code>fromType</code>,
 * respectively. If this is true then it means we may safely cast <code>value</code> to <code>fromType</code> and thus
 * able to move the cast to the literal side. That is:
 * <p>
 *   <code>cast(fromExp, toType) op value</code> ==&gt; <code>fromExp op cast(value, fromType)</code>
 * <p>
 * Note there are some exceptions to the above: if casting from <code>value</code> to <code>fromType</code> causes
 * rounding up or down, the above conversion will no longer be valid. Instead, the rule does the
 * following:
 * <p>
 * if casting <code>value</code> to <code>fromType</code> causes rounding up:
 *  - <code>cast(fromExp, toType) > value</code> ==&gt; <code>fromExp >= cast(value, fromType)</code>
 *  - <code>cast(fromExp, toType) >= value</code> ==&gt; <code>fromExp >= cast(value, fromType)</code>
 *  - <code>cast(fromExp, toType) === value</code> ==&gt; if(isnull(fromExp), null, false)
 *  - <code>cast(fromExp, toType) <=&gt; value</code> ==&gt; false (if <code>fromExp</code> is deterministic)
 *  - <code>cast(fromExp, toType) <= value</code> ==&gt; <code>fromExp < cast(value, fromType)</code>
 *  - <code>cast(fromExp, toType) < value</code> ==&gt; <code>fromExp < cast(value, fromType)</code>
 * <p>
 * Similarly for the case when casting <code>value</code> to <code>fromType</code> causes rounding down.
 * <p>
 * If the <code>value</code> is not within range <code>(min, max)</code>, the rule breaks the scenario into different
 * cases and try to replace each with simpler constructs.
 * <p>
 * if <code>value > max</code>, the cases are of following:
 *  - <code>cast(fromExp, toType) > value</code> ==&gt; if(isnull(fromExp), null, false)
 *  - <code>cast(fromExp, toType) >= value</code> ==&gt; if(isnull(fromExp), null, false)
 *  - <code>cast(fromExp, toType) === value</code> ==&gt; if(isnull(fromExp), null, false)
 *  - <code>cast(fromExp, toType) <=&gt; value</code> ==&gt; false (if <code>fromExp</code> is deterministic)
 *  - <code>cast(fromExp, toType) <= value</code> ==&gt; if(isnull(fromExp), null, true)
 *  - <code>cast(fromExp, toType) < value</code> ==&gt; if(isnull(fromExp), null, true)
 * <p>
 * if <code>value == max</code>, the cases are of following:
 *  - <code>cast(fromExp, toType) > value</code> ==&gt; if(isnull(fromExp), null, false)
 *  - <code>cast(fromExp, toType) >= value</code> ==&gt; fromExp == max
 *  - <code>cast(fromExp, toType) === value</code> ==&gt; fromExp == max
 *  - <code>cast(fromExp, toType) <=&gt; value</code> ==&gt; fromExp <=&gt; max
 *  - <code>cast(fromExp, toType) <= value</code> ==&gt; if(isnull(fromExp), null, true)
 *  - <code>cast(fromExp, toType) < value</code> ==&gt; fromExp =!= max
 * <p>
 * Similarly for the cases when <code>value == min</code> and <code>value < min</code>.
 * <p>
 * Further, the above <code>if(isnull(fromExp), null, false)</code> is represented using conjunction
 * <code>and(isnull(fromExp), null)</code>, to enable further optimization and filter pushdown to data sources.
 * Similarly, <code>if(isnull(fromExp), null, true)</code> is represented with <code>or(isnotnull(fromExp), null)</code>.
 */
public  class UnwrapCastInBinaryComparison {
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static   scala.Option<scala.Tuple2<java.lang.Object, java.lang.Object>> getRange (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Wraps input expression <code>e</code> with <code>if(isnull(e), null, false)</code>. The if-clause is represented
   * using <code>and(isnull(e), null)</code> which is semantically equivalent by applying 3-valued logic.
   * @param e (undocumented)
   * @return (undocumented)
   */
  static   org.apache.spark.sql.catalyst.expressions.Expression falseIfNotNull (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Wraps input expression <code>e</code> with <code>if(isnull(e), null, true)</code>. The if-clause is represented
   * using <code>or(isnotnull(e), null)</code> which is semantically equivalent by applying 3-valued logic.
   * @param e (undocumented)
   * @return (undocumented)
   */
  static   org.apache.spark.sql.catalyst.expressions.Expression trueIfNotNull (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static public  java.lang.String ruleName ()  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
