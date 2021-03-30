package org.apache.spark.sql.catalyst.expressions;
public  class GenArrayData$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final GenArrayData$ MODULE$ = null;
  public   GenArrayData$ ()  { throw new RuntimeException(); }
  /**
   * Return Java code pieces based on DataType and array size to allocate ArrayData class
   * <p>
   * @param ctx a {@link CodegenContext}
   * @param elementType data type of underlying array elements
   * @param elementsExpr concatenated set of {@link Expression} for each element of an underlying array
   * @param functionName string to include in the error message
   * @return (array allocation, concatenated assignments to each array elements, arrayData name)
   */
  public  scala.Tuple3<java.lang.String, java.lang.String, java.lang.String> genCodeToCreateArrayData (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.types.DataType elementType, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> elementsExpr, java.lang.String functionName)  { throw new RuntimeException(); }
}
