package org.apache.spark.sql.execution.python;
/**
 * A user-defined Python function. This is used by the Python API.
 */
public  class UserDefinedPythonFunction implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.api.python.PythonFunction func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  int pythonEvalType ()  { throw new RuntimeException(); }
  public  boolean udfDeterministic ()  { throw new RuntimeException(); }
  // not preceding
  public   UserDefinedPythonFunction (java.lang.String name, org.apache.spark.api.python.PythonFunction func, org.apache.spark.sql.types.DataType dataType, int pythonEvalType, boolean udfDeterministic)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression builder (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> e)  { throw new RuntimeException(); }
  /** Returns a {@link Column} that will evaluate to calling this UDF with the given input. */
  public  org.apache.spark.sql.Column apply (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
}
