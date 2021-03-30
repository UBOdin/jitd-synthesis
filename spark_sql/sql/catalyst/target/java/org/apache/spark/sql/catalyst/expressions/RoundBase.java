package org.apache.spark.sql.catalyst.expressions;
/**
 * Round the <code>child</code>'s result to <code>scale</code> decimal place when <code>scale</code> >= 0
 * or round at integral part when <code>scale</code> < 0.
 * <p>
 * Child of IntegralType would round to itself when <code>scale</code> >= 0.
 * Child of FractionalType whose value is NaN or Infinite would always round to itself.
 * <p>
 * Round's dataType would always equal to <code>child</code>'s dataType except for DecimalType,
 * which would lead scale decrease from the origin DecimalType.
 * <p>
 * param:  child expr to be round, all {@link NumericType} is allowed as Input
 * param:  scale new scale to be round to, this should be a constant int at runtime
 * param:  mode rounding mode (e.g. HALF_UP, HALF_EVEN)
 * param:  modeStr rounding mode string name (e.g. "ROUND_HALF_UP", "ROUND_HALF_EVEN")
 */
public abstract class RoundBase extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements scala.Serializable, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes {
  public   RoundBase (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression scale, scala.Enumeration.Value mode, java.lang.String modeStr)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object input1)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
}
