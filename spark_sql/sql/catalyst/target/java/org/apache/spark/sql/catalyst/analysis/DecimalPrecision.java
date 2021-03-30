package org.apache.spark.sql.catalyst.analysis;
/**
 * Calculates and propagates precision for fixed-precision decimals. Hive has a number of
 * rules for this based on the SQL standard and MS SQL:
 * https://cwiki.apache.org/confluence/download/attachments/27362075/Hive_Decimal_Precision_Scale_Support.pdf
 * https://msdn.microsoft.com/en-us/library/ms190476.aspx
 * <p>
 * In particular, if we have expressions e1 and e2 with precision/scale p1/s2 and p2/s2
 * respectively, then the following operations have the following precision / scale:
 * <p>
 *   Operation    Result Precision                        Result Scale
 *   ------------------------------------------------------------------------
 *   e1 + e2      max(s1, s2) + max(p1-s1, p2-s2) + 1     max(s1, s2)
 *   e1 - e2      max(s1, s2) + max(p1-s1, p2-s2) + 1     max(s1, s2)
 *   e1 * e2      p1 + p2 + 1                             s1 + s2
 *   e1 / e2      p1 - s1 + s2 + max(6, s1 + p2 + 1)      max(6, s1 + p2 + 1)
 *   e1 % e2      min(p1-s1, p2-s2) + max(s1, s2)         max(s1, s2)
 *   e1 union e2  max(s1, s2) + max(p1-s1, p2-s2)         max(s1, s2)
 * <p>
 * When <code>spark.sql.decimalOperations.allowPrecisionLoss</code> is set to true, if the precision / scale
 * needed are out of the range of available values, the scale is reduced up to 6, in order to
 * prevent the truncation of the integer part of the decimals.
 * <p>
 * To implement the rules for fixed-precision types, we introduce casts to turn them to unlimited
 * precision, do the math on unlimited-precision numbers, then introduce casts back to the
 * required fixed precision. This allows us to do all rounding and overflow handling in the
 * cast-to-fixed-precision operator.
 * <p>
 * In addition, when mixing non-decimal types with decimals, we use the following rules:
 * - BYTE gets turned into DECIMAL(3, 0)
 * - SHORT gets turned into DECIMAL(5, 0)
 * - INT gets turned into DECIMAL(10, 0)
 * - LONG gets turned into DECIMAL(20, 0)
 * - FLOAT and DOUBLE cause fixed-length decimals to turn into DOUBLE
 * - Literals INT and LONG get turned into DECIMAL with the precision strictly needed by the value
 */
public  class DecimalPrecision {
  static public  org.apache.spark.sql.types.DecimalType widerDecimalType (org.apache.spark.sql.types.DecimalType d1, org.apache.spark.sql.types.DecimalType d2)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.DecimalType widerDecimalType (int p1, int s1, int p2, int s2)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan coerceTypes (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /** Decimal precision promotion for +, -, *, /, %, pmod, and binary comparison. */
  static   scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> decimalAndDecimal ()  { throw new RuntimeException(); }
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
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
