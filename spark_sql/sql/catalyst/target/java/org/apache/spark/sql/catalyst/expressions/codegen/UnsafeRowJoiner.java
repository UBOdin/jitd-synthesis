package org.apache.spark.sql.catalyst.expressions.codegen;
public abstract class UnsafeRowJoiner {
  public   UnsafeRowJoiner ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.UnsafeRow join (org.apache.spark.sql.catalyst.expressions.UnsafeRow row1, org.apache.spark.sql.catalyst.expressions.UnsafeRow row2)  ;
}
