package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Invokes a static function, returning the result.  By default, any of the arguments being null
 * will result in returning null instead of calling the function.
 * <p>
 * param:  staticObject The target of the static call.  This can either be the object itself
 *                     (methods defined on scala objects), or the class object
 *                     (static methods defined in java).
 * param:  dataType The expected return type of the function call
 * param:  functionName The name of the method to call.
 * param:  arguments An optional list of expressions to pass as arguments to the function.
 * param:  propagateNull When true, and any of the arguments is null, null will be returned instead
 *                      of calling the function.
 * param:  returnNullable When false, indicating the invoked method will always return
 *                       non-null value.
 */
public  class StaticInvoke extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.objects.InvokeLike, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  boolean needNullCheck ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> staticObject ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String functionName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  { throw new RuntimeException(); }
  public  boolean propagateNull ()  { throw new RuntimeException(); }
  public  boolean returnNullable ()  { throw new RuntimeException(); }
  // not preceding
  public   StaticInvoke (java.lang.Class<?> staticObject, org.apache.spark.sql.types.DataType dataType, java.lang.String functionName, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments, boolean propagateNull, boolean returnNullable)  { throw new RuntimeException(); }
  public  java.lang.String objectName ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> cls ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<java.lang.Class<?>> argClasses ()  { throw new RuntimeException(); }
  // not preceding
  public  java.lang.reflect.Method method ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
