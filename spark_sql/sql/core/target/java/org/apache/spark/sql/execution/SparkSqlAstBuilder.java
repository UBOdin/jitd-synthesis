package org.apache.spark.sql.execution;
/**
 * Builder that converts an ANTLR ParseTree into a LogicalPlan/Expression/TableIdentifier.
 */
public  class SparkSqlAstBuilder extends org.apache.spark.sql.catalyst.parser.AstBuilder {
  // not preceding
  public   SparkSqlAstBuilder ()  { throw new RuntimeException(); }
  /**
   * Converts a multi-part identifier to a TableIdentifier.
   * <p>
   * If the multi-part identifier has too many parts, this will throw a ParseException.
   * @param multipart (undocumented)
   * @param command (undocumented)
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.TableIdentifier tableIdentifier (scala.collection.Seq<java.lang.String> multipart, java.lang.String command, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ClearCacheCommand} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitClearCache (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ClearCacheContext ctx)  { throw new RuntimeException(); }
  /**
   * Convert a constants list into a String sequence.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> visitConstantList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ConstantListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a table, returning a {@link CreateTable} logical plan.
   * <p>
   * This is used to produce CreateTempViewUsing from CREATE TEMPORARY TABLE.
   * <p>
   * TODO: Remove this. It is used because CreateTempViewUsing is not a Catalyst plan.
   * Either move CreateTempViewUsing into catalyst as a parsed logical plan, or remove it because
   * it is deprecated.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CreateTableLikeCommand} command.
   * <p>
   * For example:
   * <pre><code>
   *   CREATE TABLE [IF NOT EXISTS] [db_name.]table_name
   *   LIKE [other_db_name.]existing_table_name
   *   [USING provider |
   *    [
   *     [ROW FORMAT row_format]
   *     [STORED AS file_format] [WITH SERDEPROPERTIES (...)]
   *    ]
   *   ]
   *   [locationSpec]
   *   [TBLPROPERTIES (property_name=property_value, ...)]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateTableLike (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateTableLikeContext ctx)  { throw new RuntimeException(); }
  /**
   * Creates a {@link CreateTempViewUsing} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateTempViewUsing (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateTempViewUsingContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link DescribeQueryCommand} logical command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDescribeQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DescribeQueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link ExplainCommand} logical plan.
   * The syntax of using this command in SQL is:
   * <pre><code>
   *   EXPLAIN (EXTENDED | CODEGEN | COST | FORMATTED) SELECT * FROM ...
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitExplain (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ExplainContext ctx)  { throw new RuntimeException(); }
  /**
   * Fail an unsupported Hive native command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitFailNativeCommand (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FailNativeCommandContext ctx)  { throw new RuntimeException(); }
  /**
   * Return the parameters for {@link InsertIntoDir} logical plan.
   * <p>
   * Expected format:
   * <pre><code>
   *   INSERT OVERWRITE [LOCAL] DIRECTORY
   *   [path]
   *   [OPTIONS table_property_list]
   *   select_statement;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple3<java.lang.Object, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat, scala.Option<java.lang.String>> visitInsertOverwriteDir (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InsertOverwriteDirContext ctx)  { throw new RuntimeException(); }
  /**
   * Return the parameters for {@link InsertIntoDir} logical plan.
   * <p>
   * Expected format:
   * <pre><code>
   *   INSERT OVERWRITE [LOCAL] DIRECTORY
   *   path
   *   [ROW FORMAT row_format]
   *   [STORED AS file_format]
   *   select_statement;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple3<java.lang.Object, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat, scala.Option<java.lang.String>> visitInsertOverwriteHiveDir (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InsertOverwriteHiveDirContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link AddFileCommand}, {@link AddJarCommand}, {@link AddArchiveCommand},
   * {@link ListFilesCommand}, {@link ListJarsCommand} or {@link ListArchivesCommand}
   * command depending on the requested operation on resources.
   * Expected format:
   * <pre><code>
   *   ADD (FILE[S] &lt;filepath ...&gt; | JAR[S] &lt;jarpath ...&gt;)
   *   LIST (FILE[S] [filepath ...] | JAR[S] [jarpath ...])
   * </code></pre>
   * <p>
   * Note that filepath/jarpath can be given as follows;
   *  - /path/to/fileOrJar
   *  - "/path/to/fileOrJar"
   *  - '/path/to/fileOrJar'
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitManageResource (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ManageResourceContext ctx)  { throw new RuntimeException(); }
  /**
   * Convert a nested constants list into a sequence of string sequences.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.collection.Seq<java.lang.String>> visitNestedConstantList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.NestedConstantListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link RefreshResource} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRefreshResource (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RefreshResourceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ResetCommand} logical plan.
   * Example SQL :
   * <pre><code>
   *   RESET;
   *   RESET spark.sql.session.timeZone;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitResetConfiguration (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ResetConfigurationContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitResetQuotedConfiguration (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ResetQuotedConfigurationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link SetCommand} logical plan.
   * <p>
   * Note that we assume that everything after the SET keyword is assumed to be a part of the
   * key-value pair. The split between key and value is made by searching for the first <code>=</code>
   * character in the raw string.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetConfiguration (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetConfigurationContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetQuotedConfiguration (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetQuotedConfigurationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link SetCommand} logical plan to set {@link SQLConf.SESSION_LOCAL_TIMEZONE}
   * Example SQL :
   * <pre><code>
   *   SET TIME ZONE LOCAL;
   *   SET TIME ZONE 'Asia/Shanghai';
   *   SET TIME ZONE INTERVAL 10 HOURS;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetTimeZone (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetTimeZoneContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a clause for DISTRIBUTE BY.
   * @param ctx (undocumented)
   * @param expressions (undocumented)
   * @param query (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan withRepartitionByExpression (org.apache.spark.sql.catalyst.parser.SqlBaseParser.QueryOrganizationContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query)  { throw new RuntimeException(); }
  /**
   * Create a {@link ScriptInputOutputSchema}.
   * @param ctx (undocumented)
   * @param inRowFormat (undocumented)
   * @param recordWriter (undocumented)
   * @param outRowFormat (undocumented)
   * @param recordReader (undocumented)
   * @param schemaLess (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.plans.logical.ScriptInputOutputSchema withScriptIOSchema (org.antlr.v4.runtime.ParserRuleContext ctx, org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatContext inRowFormat, org.antlr.v4.runtime.Token recordWriter, org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatContext outRowFormat, org.antlr.v4.runtime.Token recordReader, boolean schemaLess)  { throw new RuntimeException(); }
}
