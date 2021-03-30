package org.apache.spark.sql.catalyst.parser;
/**
 * Parser that turns case class strings into datatypes. This is only here to maintain compatibility
 * with Parquet files written by Spark 1.1 and below.
 */
public  class LegacyTypeStringParser$ implements scala.util.parsing.combinator.RegexParsers {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final LegacyTypeStringParser$ MODULE$ = null;
  protected  scala.util.matching.Regex whiteSpace ()  { throw new RuntimeException(); }
  public  scala.util.parsing.combinator.Parsers.Success$ Success ()  { throw new RuntimeException(); }
  public  scala.util.parsing.combinator.Parsers.NoSuccess$ NoSuccess ()  { throw new RuntimeException(); }
  public  scala.util.parsing.combinator.Parsers.Failure$ Failure ()  { throw new RuntimeException(); }
  public  scala.util.parsing.combinator.Parsers.Error$ Error ()  { throw new RuntimeException(); }
  public   LegacyTypeStringParser$ ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.DataType> primitiveType ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.DataType> fixedDecimalType ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.DataType> arrayType ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.DataType> mapType ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.StructField> structField ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<java.lang.Object> boolVal ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.DataType> structType ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.util.parsing.combinator.Parsers.Parser<org.apache.spark.sql.types.DataType> dataType ()  { throw new RuntimeException(); }
  /**
   * Parses a string representation of a DataType.
   * @param asString (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType parseString (java.lang.String asString)  { throw new RuntimeException(); }
}
