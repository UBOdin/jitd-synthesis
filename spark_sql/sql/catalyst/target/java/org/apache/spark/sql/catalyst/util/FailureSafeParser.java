package org.apache.spark.sql.catalyst.util;
public  class FailureSafeParser<IN extends java.lang.Object> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   FailureSafeParser (scala.Function1<IN, scala.collection.Iterable<org.apache.spark.sql.catalyst.InternalRow>> rawParser, org.apache.spark.sql.catalyst.util.ParseMode mode, org.apache.spark.sql.types.StructType schema, java.lang.String columnNameOfCorruptRecord)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parse (IN input)  { throw new RuntimeException(); }
}
