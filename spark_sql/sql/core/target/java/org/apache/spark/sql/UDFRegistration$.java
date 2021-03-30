package org.apache.spark.sql;
public  class UDFRegistration$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UDFRegistration$ MODULE$ = null;
  public   UDFRegistration$ ()  { throw new RuntimeException(); }
  /**
   * Obtaining the schema of output encoder for <code>ScalaUDF</code>.
   * <p>
   * As the serialization in <code>ScalaUDF</code> is for individual column, not the whole row,
   * we just take the data type of vanilla object serializer, not <code>serializer</code> which
   * is transformed somehow for top-level row.
   * @param outputEncoder (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.ScalaReflection.Schema outputSchema (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?> outputEncoder)  { throw new RuntimeException(); }
}
