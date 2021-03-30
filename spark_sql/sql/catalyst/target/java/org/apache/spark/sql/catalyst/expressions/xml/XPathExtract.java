package org.apache.spark.sql.catalyst.expressions.xml;
/**
 * Base class for xpath_boolean, xpath_double, xpath_int, etc.
 * <p>
 * This is not the world's most efficient implementation due to type conversion, but works.
 */
public abstract class XPathExtract extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public   XPathExtract ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  /** XPath expressions are always nullable, e.g. if the xml string is empty. */
  public  boolean nullable ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression path ()  ;
  // not preceding
  protected  java.lang.String pathString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  /** Concrete implementations need to override the following three methods. */
  public abstract  org.apache.spark.sql.catalyst.expressions.Expression xml ()  ;
  // not preceding
  protected  org.apache.spark.sql.catalyst.expressions.xml.UDFXPathUtil xpathUtil ()  { throw new RuntimeException(); }
}
