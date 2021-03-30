package org.apache.spark.sql.catalyst.expressions.aggregate;
public  class PivotFirst extends org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate implements scala.Product, scala.Serializable {
  // not preceding
  static public  boolean supportsDataType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression pivotColumn ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueColumn ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> pivotColumnValues ()  { throw new RuntimeException(); }
  public  int mutableAggBufferOffset ()  { throw new RuntimeException(); }
  public  int inputAggBufferOffset ()  { throw new RuntimeException(); }
  public   PivotFirst (org.apache.spark.sql.catalyst.expressions.Expression pivotColumn, org.apache.spark.sql.catalyst.expressions.Expression valueColumn, scala.collection.Seq<java.lang.Object> pivotColumnValues, int mutableAggBufferOffset, int inputAggBufferOffset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType valueDataType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.Object> pivotIndex ()  { throw new RuntimeException(); }
  public  int indexSize ()  { throw new RuntimeException(); }
  public  void update (org.apache.spark.sql.catalyst.InternalRow mutableAggBuffer, org.apache.spark.sql.catalyst.InternalRow inputRow)  { throw new RuntimeException(); }
  public  void merge (org.apache.spark.sql.catalyst.InternalRow mutableAggBuffer, org.apache.spark.sql.catalyst.InternalRow inputAggBuffer)  { throw new RuntimeException(); }
  public  void initialize (org.apache.spark.sql.catalyst.InternalRow mutableAggBuffer)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewInputAggBufferOffset (int newInputAggBufferOffset)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate withNewMutableAggBufferOffset (int newMutableAggBufferOffset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType aggBufferSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> inputAggBufferAttributes ()  { throw new RuntimeException(); }
}
