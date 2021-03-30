package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Calls the specified function on an object, optionally passing arguments.  If the <code>targetObject</code>
 * expression evaluates to null then null will be returned.
 * <p>
 * In some cases, due to erasure, the schema may expect a primitive type when in fact the method
 * is returning java.lang.Object.  In this case, we will generate code that attempts to unbox the
 * value automatically.
 * <p>
 * param:  targetObject An expression that will return the object to call the method on.
 * param:  functionName The name of the method to call.
 * param:  dataType The expected return type of the function.
 * param:  arguments An optional list of expressions, whose evaluation will be passed to the
 *                 function.
 * param:  propagateNull When true, and any of the arguments is null, null will be returned instead
 *                      of calling the function.
 * param:  returnNullable When false, indicating the invoked method will always return
 *                       non-null value.
 */
public  class Invoke extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.objects.InvokeLike, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  protected  boolean needNullCheck ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression targetObject ()  { throw new RuntimeException(); }
  public  java.lang.String functionName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  { throw new RuntimeException(); }
  public  boolean propagateNull ()  { throw new RuntimeException(); }
  public  boolean returnNullable ()  { throw new RuntimeException(); }
  // not preceding
  public   Invoke (org.apache.spark.sql.catalyst.expressions.Expression targetObject, java.lang.String functionName, org.apache.spark.sql.types.DataType dataType, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments, boolean propagateNull, boolean returnNullable)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<java.lang.Class<?>> argClasses ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.Option<java.lang.reflect.Method> method ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
