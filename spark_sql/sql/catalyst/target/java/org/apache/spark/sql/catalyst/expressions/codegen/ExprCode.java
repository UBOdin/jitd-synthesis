package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Java source for evaluating an {@link Expression} given a {@link InternalRow} of input.
 * <p>
 * param:  code The sequence of statements required to evaluate the expression.
 *             It should be empty string, if <code>isNull</code> and <code>value</code> are already existed, or no code
 *             needed to evaluate them (literals).
 * param:  isNull A term that holds a boolean value representing whether the expression evaluated
 *                 to null.
 * param:  value A term for a (possibly primitive) value of the result of the evaluation. Not
 *              valid if <code>isNull</code> is set to <code>true</code>.
 */
public  class ExprCode implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode apply (org.apache.spark.sql.catalyst.expressions.codegen.ExprValue isNull, org.apache.spark.sql.catalyst.expressions.codegen.ExprValue value)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode forNullValue (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode forNonNullValue (org.apache.spark.sql.catalyst.expressions.codegen.ExprValue value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.Block code ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprValue isNull ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprValue value ()  { throw new RuntimeException(); }
  // not preceding
  public   ExprCode (org.apache.spark.sql.catalyst.expressions.codegen.Block code, org.apache.spark.sql.catalyst.expressions.codegen.ExprValue isNull, org.apache.spark.sql.catalyst.expressions.codegen.ExprValue value)  { throw new RuntimeException(); }
}
