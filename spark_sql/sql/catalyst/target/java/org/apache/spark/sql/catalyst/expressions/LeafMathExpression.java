package org.apache.spark.sql.catalyst.expressions;
/**
 * A leaf expression specifically for math constants. Math constants expect no input.
 * <p>
 * There is no code generation because they should get constant folded by the optimizer.
 * <p>
 * param:  c The math constant.
 * param:  name The short name of the function
 */
public abstract class LeafMathExpression extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Serializable {
  public   LeafMathExpression (double c, java.lang.String name)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
