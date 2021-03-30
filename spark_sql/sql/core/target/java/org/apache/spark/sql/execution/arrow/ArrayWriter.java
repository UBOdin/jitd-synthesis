package org.apache.spark.sql.execution.arrow;
  class ArrayWriter extends org.apache.spark.sql.execution.arrow.ArrowFieldWriter {
  // not preceding
  public   ArrayWriter (org.apache.arrow.vector.complex.ListVector valueVector, org.apache.spark.sql.execution.arrow.ArrowFieldWriter elementWriter)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.arrow.ArrowFieldWriter elementWriter ()  { throw new RuntimeException(); }
  public  void finish ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  void setNull ()  { throw new RuntimeException(); }
  public  void setValue (org.apache.spark.sql.catalyst.expressions.SpecializedGetters input, int ordinal)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.complex.ListVector valueVector ()  { throw new RuntimeException(); }
}
