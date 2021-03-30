package org.apache.spark.sql.catalyst.expressions;
/**
 * A binary expression specifically for math functions that take two <code>Double</code>s as input and returns
 * a <code>Double</code>.
 * <p>
 * param:  f The math function.
 * param:  name The short name of the function
 */
public abstract class BinaryMathExpression extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Serializable {
  public   BinaryMathExpression (scala.Function2<java.lang.Object, java.lang.Object, java.lang.Object> f, java.lang.String name)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
