package org.apache.spark.sql.catalyst.expressions.objects;
public  class NewInstance extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.objects.InvokeLike, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.objects.NewInstance apply (java.lang.Class<?> cls, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments, org.apache.spark.sql.types.DataType dataType, boolean propagateNull)  { throw new RuntimeException(); }
  protected  boolean needNullCheck ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> cls ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  { throw new RuntimeException(); }
  public  boolean propagateNull ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Function0<java.lang.Object>> outerPointer ()  { throw new RuntimeException(); }
  // not preceding
  public   NewInstance (java.lang.Class<?> cls, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments, boolean propagateNull, org.apache.spark.sql.types.DataType dataType, scala.Option<scala.Function0<java.lang.Object>> outerPointer)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
