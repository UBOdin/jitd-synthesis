package org.apache.spark.sql.catalyst.expressions.objects;
/**
 * Serializes an input object using a generic serializer (Kryo or Java).  Note that the ClassTag
 * is not an implicit parameter because TreeNode cannot copy implicit parameters.
 * <p>
 * param:  kryo if true, use Kryo. Otherwise, use Java.
 */
public  class DecodeUsingSerializer<T extends java.lang.Object> extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.NonSQLExpression, org.apache.spark.sql.catalyst.expressions.objects.SerializerSupport, scala.Product, scala.Serializable {
  public  org.apache.spark.serializer.SerializerInstance serializerInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.reflect.ClassTag<T> tag ()  { throw new RuntimeException(); }
  public  boolean kryo ()  { throw new RuntimeException(); }
  // not preceding
  public   DecodeUsingSerializer (org.apache.spark.sql.catalyst.expressions.Expression child, scala.reflect.ClassTag<T> tag, boolean kryo)  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
}
