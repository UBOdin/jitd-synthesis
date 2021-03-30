package org.apache.spark.sql.execution.arrow;
  class StructWriter extends org.apache.spark.sql.execution.arrow.ArrowFieldWriter {
  // not preceding
  public   StructWriter (org.apache.arrow.vector.complex.StructVector valueVector, org.apache.spark.sql.execution.arrow.ArrowFieldWriter[] children)  { throw new RuntimeException(); }
  public  void finish ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  void setNull ()  { throw new RuntimeException(); }
  public  void setValue (org.apache.spark.sql.catalyst.expressions.SpecializedGetters input, int ordinal)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.complex.StructVector valueVector ()  { throw new RuntimeException(); }
}
