package org.apache.spark.sql.catalyst.expressions.objects;
public  class ExternalMapToCatalyst extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.objects.ExternalMapToCatalyst apply (org.apache.spark.sql.catalyst.expressions.Expression inputMap, org.apache.spark.sql.types.DataType keyType, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> keyConverter, boolean keyNullable, org.apache.spark.sql.types.DataType valueType, scala.Function1<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> valueConverter, boolean valueNullable)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.objects.LambdaVariable keyLoopVar ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyConverter ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.objects.LambdaVariable valueLoopVar ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueConverter ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression inputData ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.MapType dataType ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
