package org.apache.spark.sql.execution.arrow;
  class MapWriter extends org.apache.spark.sql.execution.arrow.ArrowFieldWriter {
  // not preceding
  public   MapWriter (org.apache.arrow.vector.complex.MapVector valueVector, org.apache.arrow.vector.complex.StructVector structVector, org.apache.spark.sql.execution.arrow.ArrowFieldWriter keyWriter, org.apache.spark.sql.execution.arrow.ArrowFieldWriter valueWriter)  { throw new RuntimeException(); }
  public  void finish ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.arrow.ArrowFieldWriter keyWriter ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  void setNull ()  { throw new RuntimeException(); }
  public  void setValue (org.apache.spark.sql.catalyst.expressions.SpecializedGetters input, int ordinal)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.complex.StructVector structVector ()  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.complex.MapVector valueVector ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.arrow.ArrowFieldWriter valueWriter ()  { throw new RuntimeException(); }
}
