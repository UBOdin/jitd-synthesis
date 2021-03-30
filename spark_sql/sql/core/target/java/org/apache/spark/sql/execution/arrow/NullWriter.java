package org.apache.spark.sql.execution.arrow;
  class NullWriter extends org.apache.spark.sql.execution.arrow.ArrowFieldWriter {
  // not preceding
  public   NullWriter (org.apache.arrow.vector.NullVector valueVector)  { throw new RuntimeException(); }
  public  void setNull ()  { throw new RuntimeException(); }
  public  void setValue (org.apache.spark.sql.catalyst.expressions.SpecializedGetters input, int ordinal)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.NullVector valueVector ()  { throw new RuntimeException(); }
}
