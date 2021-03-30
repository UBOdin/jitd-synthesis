package org.apache.spark.sql.catalyst.parser;
/**
 * Base SQL parsing infrastructure.
 */
public abstract class AbstractSqlParser implements org.apache.spark.sql.catalyst.parser.ParserInterface, org.apache.spark.sql.catalyst.SQLConfHelper, org.apache.spark.internal.Logging {
  public   AbstractSqlParser ()  { throw new RuntimeException(); }
  /** Get the builder (visitor) which converts a ParseTree into an AST. */
  protected abstract  org.apache.spark.sql.catalyst.parser.AstBuilder astBuilder ()  ;
  protected <T extends java.lang.Object> T parse (java.lang.String command, scala.Function1<org.apache.spark.sql.catalyst.parser.SqlBaseParser, T> toResult)  { throw new RuntimeException(); }
  /** Creates/Resolves DataType for a given SQL string. */
  public  org.apache.spark.sql.types.DataType parseDataType (java.lang.String sqlText)  { throw new RuntimeException(); }
  /** Creates Expression for a given SQL string. */
  public  org.apache.spark.sql.catalyst.expressions.Expression parseExpression (java.lang.String sqlText)  { throw new RuntimeException(); }
  /** Creates FunctionIdentifier for a given SQL string. */
  public  org.apache.spark.sql.catalyst.FunctionIdentifier parseFunctionIdentifier (java.lang.String sqlText)  { throw new RuntimeException(); }
  /** Creates a multi-part identifier for a given SQL string */
  public  scala.collection.Seq<java.lang.String> parseMultipartIdentifier (java.lang.String sqlText)  { throw new RuntimeException(); }
  /** Creates LogicalPlan for a given SQL string. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan parsePlan (java.lang.String sqlText)  { throw new RuntimeException(); }
  /** Creates TableIdentifier for a given SQL string. */
  public  org.apache.spark.sql.catalyst.TableIdentifier parseTableIdentifier (java.lang.String sqlText)  { throw new RuntimeException(); }
  /**
   * Creates StructType for a given SQL string, which is a comma separated list of field
   * definitions which will preserve the correct Hive metadata.
   * @param sqlText (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType parseTableSchema (java.lang.String sqlText)  { throw new RuntimeException(); }
}
