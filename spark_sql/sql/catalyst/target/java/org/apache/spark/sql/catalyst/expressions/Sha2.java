package org.apache.spark.sql.catalyst.expressions;
/**
 * A function that calculates the SHA-2 family of functions (SHA-224, SHA-256, SHA-384, and SHA-512)
 * and returns it as a hex string. The first argument is the string or binary to be hashed. The
 * second argument indicates the desired bit length of the result, which must have a value of 224,
 * 256, 384, 512, or 0 (which is equivalent to 256). SHA-224 is supported starting from Java 8. If
 * asking for an unsupported SHA function, the return value is NULL. If either argument is NULL or
 * the hash length is not one of the permitted values, the return value is NULL.
 */
public  class Sha2 extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant, scala.Serializable, scala.Product {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  // not preceding
  public   Sha2 (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
