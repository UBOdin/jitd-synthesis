package org.apache.spark.sql.catalyst.expressions;
/**
 * Common base class for {@link SortArray} and {@link ArraySort}.
 */
public  interface ArraySortLike extends org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes {
  static public  class NullOrder$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final NullOrder$ MODULE$ = null;
    public   NullOrder$ ()  { throw new RuntimeException(); }
    public  int Least ()  { throw new RuntimeException(); }
    public  int Greatest ()  { throw new RuntimeException(); }
  }
  public  org.apache.spark.sql.catalyst.expressions.Expression arrayExpression ()  ;
  public  int nullOrder ()  ;
  public  org.apache.spark.sql.types.DataType elementType ()  ;
  public  boolean containsNull ()  ;
  public  Object sortEval (Object array, boolean ascending)  ;
  public  java.lang.String sortCodegen (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, java.lang.String base, java.lang.String order)  ;
}
