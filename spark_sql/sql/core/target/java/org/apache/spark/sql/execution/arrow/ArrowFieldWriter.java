package org.apache.spark.sql.execution.arrow;
 abstract class ArrowFieldWriter {
  public   ArrowFieldWriter ()  { throw new RuntimeException(); }
    int count ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  void finish ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public abstract  void setNull ()  ;
  public abstract  void setValue (org.apache.spark.sql.catalyst.expressions.SpecializedGetters input, int ordinal)  ;
  public abstract  org.apache.arrow.vector.ValueVector valueVector ()  ;
  public  void write (org.apache.spark.sql.catalyst.expressions.SpecializedGetters input, int ordinal)  { throw new RuntimeException(); }
}
