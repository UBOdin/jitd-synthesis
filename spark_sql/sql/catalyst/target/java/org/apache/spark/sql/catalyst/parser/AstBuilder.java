package org.apache.spark.sql.catalyst.parser;
/**
 * The AstBuilder converts an ANTLR4 ParseTree into a catalyst Expression, LogicalPlan or
 * TableIdentifier.
 */
public  class AstBuilder extends org.apache.spark.sql.catalyst.parser.SqlBaseBaseVisitor<java.lang.Object> implements org.apache.spark.sql.catalyst.SQLConfHelper, org.apache.spark.internal.Logging {
  public   AstBuilder ()  { throw new RuntimeException(); }
  public  scala.Tuple2<scala.collection.immutable.Map<java.lang.String, java.lang.String>, scala.Option<java.lang.String>> cleanTableOptions (org.antlr.v4.runtime.ParserRuleContext ctx, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, scala.Option<java.lang.String> location)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> cleanTableProperties (org.antlr.v4.runtime.ParserRuleContext ctx, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  /**
   * Create top level table schema.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.types.StructType createSchema (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ColTypeListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link StructType} from a sequence of {@link StructField}s.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.types.StructType createStructType (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ComplexColTypeListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an expression from the given context. This method just passes the context on to the
   * visitor and only takes care of typing (We assume that the visitor returns an Expression here).
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.Expression expression (org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /**
   * Get a function identifier consist by database (optional) and name.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.FunctionIdentifier getFunctionIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FunctionNameContext ctx)  { throw new RuntimeException(); }
  protected  scala.Tuple4<scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>>, scala.Option<java.lang.String>, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>>, scala.Option<java.lang.String>> getRowFormatDelimited (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatDelimitedContext ctx)  { throw new RuntimeException(); }
  protected  scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo> getSerdeInfo (scala.collection.Seq<org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatContext> rowFormatCtx, scala.collection.Seq<org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateFileFormatContext> createFileFormatCtx, org.antlr.v4.runtime.ParserRuleContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CalendarInterval} object
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.unsafe.types.CalendarInterval parseIntervalLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.IntervalContext ctx)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan (org.antlr.v4.runtime.ParserRuleContext tree)  { throw new RuntimeException(); }
  protected <T extends java.lang.Object> T typedVisit (org.antlr.v4.runtime.tree.ParseTree ctx)  { throw new RuntimeException(); }
  /**
   * Throw a {@link ParseException} if the user specified incompatible SerDes through ROW FORMAT
   * and STORED AS.
   * <p>
   * The following are allowed. Anything else is not:
   *   ROW FORMAT SERDE ... STORED AS [SEQUENCEFILE | RCFILE | TEXTFILE]
   *   ROW FORMAT DELIMITED ... STORED AS TEXTFILE
   *   ROW FORMAT ... STORED AS INPUTFORMAT ... OUTPUTFORMAT ...
   * @param rowFormatCtx (undocumented)
   * @param createFileFormatCtx (undocumented)
   * @param parentCtx (undocumented)
   */
  protected  void validateRowFormatFileFormat (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatContext rowFormatCtx, org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateFileFormatContext createFileFormatCtx, org.antlr.v4.runtime.ParserRuleContext parentCtx)  { throw new RuntimeException(); }
  protected  void validateRowFormatFileFormat (scala.collection.Seq<org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatContext> rowFormatCtx, scala.collection.Seq<org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateFileFormatContext> createFileFormatCtx, org.antlr.v4.runtime.ParserRuleContext parentCtx)  { throw new RuntimeException(); }
  /**
   * Parse a {@link AlterTableAddColumnsStatement} command.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table1
   *   ADD COLUMNS (col_name data_type [COMMENT col_comment], ...);
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAddTableColumns (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AddTableColumnsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link AddPartitions}.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE multi_part_name ADD [IF NOT EXISTS] PARTITION spec [LOCATION 'loc1']
   *   ALTER VIEW multi_part_name ADD [IF NOT EXISTS] PARTITION spec
   * </code></pre>
   * <p>
   * ALTER VIEW ... ADD PARTITION ... is not supported because the concept of partitioning
   * is associated with physical tables
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAddTablePartition (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AddTablePartitionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an alias (SubqueryAlias) for a sub-query. This is practically the same as
   * visitAliasedRelation and visitNamedExpression, ANTLR4 however requires us to use 3 different
   * hooks. We could add alias names for output columns, for example:
   * <pre><code>
   *   SELECT col1, col2 FROM testData AS t(col1, col2)
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAliasedQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AliasedQueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an alias (SubqueryAlias) for a join relation. This is practically the same as
   * visitAliasedQuery and visitNamedExpression, ANTLR4 however requires us to use 3 different
   * hooks. We could add alias names for output columns, for example:
   * <pre><code>
   *   SELECT a, b, c, d FROM (src1 s1 INNER JOIN src2 s2 ON s1.id = s2.id) dst(a, b, c, d)
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAliasedRelation (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AliasedRelationContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a {@link AlterTableAlterColumnStatement} command to alter a column's property.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table1 ALTER COLUMN a.b.c TYPE bigint
   *   ALTER TABLE table1 ALTER COLUMN a.b.c SET NOT NULL
   *   ALTER TABLE table1 ALTER COLUMN a.b.c DROP NOT NULL
   *   ALTER TABLE table1 ALTER COLUMN a.b.c COMMENT 'new comment'
   *   ALTER TABLE table1 ALTER COLUMN a.b.c FIRST
   *   ALTER TABLE table1 ALTER COLUMN a.b.c AFTER x
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAlterTableAlterColumn (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AlterTableAlterColumnContext ctx)  { throw new RuntimeException(); }
  /**
   * Alter the query of a view. This creates a {@link AlterViewAs}
   * <p>
   * For example:
   * <pre><code>
   *   ALTER VIEW multi_part_name AS SELECT ...;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAlterViewQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AlterViewQueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link AnalyzeTable}, or an {@link AnalyzeColumn}.
   * Example SQL for analyzing a table or a set of partitions :
   * <pre><code>
   *   ANALYZE TABLE multi_part_name [PARTITION (partcol1[=val1], partcol2[=val2], ...)]
   *   COMPUTE STATISTICS [NOSCAN];
   * </code></pre>
   * <p>
   * Example SQL for analyzing columns :
   * <pre><code>
   *   ANALYZE TABLE multi_part_name COMPUTE STATISTICS FOR COLUMNS column1, column2;
   * </code></pre>
   * <p>
   * Example SQL for analyzing all columns of a table:
   * <pre><code>
   *   ANALYZE TABLE multi_part_name COMPUTE STATISTICS FOR ALL COLUMNS;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAnalyze (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AnalyzeContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link AnalyzeTables}.
   * Example SQL for analyzing all tables in default database:
   * <pre><code>
   *   ANALYZE TABLES IN default COMPUTE STATISTICS;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitAnalyzeTables (org.apache.spark.sql.catalyst.parser.SqlBaseParser.AnalyzeTablesContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a binary arithmetic expression. The following arithmetic operators are supported:
   * - Multiplication: '*'
   * - Division: '/'
   * - Hive Long Division: 'DIV'
   * - Modulo: '%'
   * - Addition: '+'
   * - Subtraction: '-'
   * - Binary AND: '&amp;'
   * - Binary XOR
   * - Binary OR: '|'
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitArithmeticBinary (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ArithmeticBinaryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a unary arithmetic expression. The following arithmetic operators are supported:
   * - Plus: '+'
   * - Minus: '-'
   * - Bitwise Not: '~'
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitArithmeticUnary (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ArithmeticUnaryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a BigDecimal Literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitBigDecimalLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.BigDecimalLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Long Literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitBigIntLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.BigIntLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Boolean literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitBooleanLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.BooleanLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link BucketSpec}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.BucketSpec visitBucketSpec (org.apache.spark.sql.catalyst.parser.SqlBaseParser.BucketSpecContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CacheTable} or {@link CacheTableAsSelect}.
   * <p>
   * For example:
   * <pre><code>
   *   CACHE [LAZY] TABLE multi_part_name
   *   [OPTIONS tablePropertyList] {&#64;link AS] query]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCacheTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CacheTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link Cast} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitCast (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CastContext ctx)  { throw new RuntimeException(); }
  /**
   * Override the default behavior for all visit methods. This will only return a non-null result
   * when the context has only one child. This is done because there is no generic method to
   * combine the results of the context children. In all other cases null is returned.
   * @param node (undocumented)
   * @return (undocumented)
   */
  public  java.lang.Object visitChildren (org.antlr.v4.runtime.tree.RuleNode node)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.TableChange.ColumnPosition visitColPosition (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ColPositionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a top level {@link StructField} from a column definition.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructField visitColType (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ColTypeContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link StructType} from a number of column definitions.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.types.StructField> visitColTypeList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ColTypeListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link UnresolvedAttribute} expression or a {@link UnresolvedRegex} if it is a regex
   * quoted in <code></code>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitColumnReference (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ColumnReferenceContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCommentNamespace (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CommentNamespaceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a comment string.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String visitCommentSpec (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CommentSpecContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an optional comment string.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  scala.Option<java.lang.String> visitCommentSpecList (java.util.List<org.apache.spark.sql.catalyst.parser.SqlBaseParser.CommentSpecContext> ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCommentTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CommentTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a comparison expression. This compares two expressions. The following comparison
   * operators are supported:
   * - Equal: '=' or '=='
   * - Null-safe Equal: '<=&gt;'
   * - Not Equal: '<>' or '!='
   * - Less than: '<'
   * - Less then or Equal: '<='
   * - Greater than: '>'
   * - Greater then or Equal: '>='
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitComparison (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ComparisonContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link StructField} from a column definition.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructField visitComplexColType (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ComplexColTypeContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link StructType} from a number of column definitions.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.types.StructField> visitComplexColTypeList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ComplexColTypeListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a complex DataType. Arrays, Maps and Structures are supported.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType visitComplexDataType (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ComplexDataTypeContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link SerdeInfo} for creating tables.
   * <p>
   * Format: STORED AS (name | INPUTFORMAT input_format OUTPUTFORMAT output_format)
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.SerdeInfo visitCreateFileFormat (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateFileFormatContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a CREATE FUNCTION statement.
   * <p>
   * For example:
   * <pre><code>
   *   CREATE [OR REPLACE] [TEMPORARY] FUNCTION [IF NOT EXISTS] [db_name.]function_name
   *   AS class_name [USING JAR|FILE|ARCHIVE 'file_uri' [, JAR|FILE|ARCHIVE 'file_uri'};
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateFunction (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateFunctionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CreateNamespaceStatement} command.
   * <p>
   * For example:
   * <pre><code>
   *   CREATE NAMESPACE [IF NOT EXISTS] ns1.ns2.ns3
   *     create_namespace_clauses;
   *
   *   create_namespace_clauses (order insensitive):
   *     [COMMENT namespace_comment]
   *     [LOCATION path]
   *     [WITH PROPERTIES (key1=val1, key2=val2, ...)]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateNamespace (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateNamespaceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a table, returning a {@link CreateTableStatement} logical plan.
   * <p>
   * Expected format:
   * <pre><code>
   *   CREATE [TEMPORARY] TABLE [IF NOT EXISTS] [db_name.]table_name
   *   [USING table_provider]
   *   create_table_clauses
   *   {&#64;link AS] select_statement];
   *
   *   create_table_clauses (order insensitive):
   *     [PARTITIONED BY (partition_fields)]
   *     [OPTIONS table_property_list]
   *     [ROW FORMAT row_format]
   *     [STORED AS file_format]
   *     [CLUSTERED BY (col_name, col_name, ...)
   *       [SORTED BY (col_name [ASC|DESC], ...)]
   *       INTO num_buckets BUCKETS
   *     ]
   *     [LOCATION path]
   *     [COMMENT table_comment]
   *     [TBLPROPERTIES (property_name=property_value, ...)]
   *
   *   partition_fields:
   *     col_name, transform(col_name), transform(constant, col_name), ... |
   *     col_name data_type [NOT NULL] [COMMENT col_comment], ...
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateTableContext ctx)  { throw new RuntimeException(); }
  public  scala.Tuple8<scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform>, scala.collection.Seq<org.apache.spark.sql.types.StructField>, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec>, scala.collection.immutable.Map<java.lang.String, java.lang.String>, scala.collection.immutable.Map<java.lang.String, java.lang.String>, scala.Option<java.lang.String>, scala.Option<java.lang.String>, scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo>> visitCreateTableClauses (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateTableClausesContext ctx)  { throw new RuntimeException(); }
  /**
   * Validate a create table statement and return the {@link TableIdentifier}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple4<scala.collection.Seq<java.lang.String>, java.lang.Object, java.lang.Object, java.lang.Object> visitCreateTableHeader (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateTableHeaderContext ctx)  { throw new RuntimeException(); }
  /**
   * Create or replace a view. This creates a {@link CreateViewStatement}
   * <p>
   * For example:
   * <pre><code>
   *   CREATE [OR REPLACE] {&#64;link GLOBAL] TEMPORARY] VIEW [IF NOT EXISTS] multi_part_name
   *   [(column_name [COMMENT column_comment], ...) ]
   *   create_view_clauses
   *
   *   AS SELECT ...;
   *
   *   create_view_clauses (order insensitive):
   *     [COMMENT view_comment]
   *     [TBLPROPERTIES (property_name = property_value, ...)]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitCreateView (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CreateViewContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression visitCurrentDatetime (org.apache.spark.sql.catalyst.parser.SqlBaseParser.CurrentDatetimeContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a decimal literal for a regular decimal number.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitDecimalLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DecimalLiteralContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDeleteFromTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DeleteFromTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a dereference expression. The return type depends on the type of the parent.
   * If the parent is an {@link UnresolvedAttribute}, it can be a {@link UnresolvedAttribute} or
   * a {@link UnresolvedRegex} for regex quoted in <code></code>; if the parent is some other expression,
   * it can be {@link UnresolvedExtractValue}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitDereference (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DereferenceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a plan for a DESCRIBE FUNCTION statement.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDescribeFunction (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DescribeFunctionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link DescribeNamespace}.
   * <p>
   * For example:
   * <pre><code>
   *   DESCRIBE (DATABASE|SCHEMA|NAMESPACE) [EXTENDED] database;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDescribeNamespace (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DescribeNamespaceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link DescribeColumn} or {@link DescribeRelation} commands.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDescribeRelation (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DescribeRelationContext ctx)  { throw new RuntimeException(); }
  public  java.lang.Object visitDmlStatement (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DmlStatementContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Double Literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitDoubleLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DoubleLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a DROP FUNCTION statement.
   * <p>
   * For example:
   * <pre><code>
   *   DROP [TEMPORARY] FUNCTION [IF EXISTS] function;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDropFunction (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DropFunctionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link DropNamespace} command.
   * <p>
   * For example:
   * <pre><code>
   *   DROP (DATABASE|SCHEMA|NAMESPACE) [IF EXISTS] ns1.ns2 [RESTRICT|CASCADE];
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDropNamespace (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DropNamespaceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link DropTable} command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDropTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DropTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a {@link AlterTableDropColumnsStatement} command.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table1 DROP COLUMN a.b.c
   *   ALTER TABLE table1 DROP COLUMNS a.b.c, x, y
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDropTableColumns (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DropTableColumnsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link DropPartitions}
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE multi_part_name DROP [IF EXISTS] PARTITION spec1[, PARTITION spec2, ...]
   *     [PURGE];
   *   ALTER VIEW view DROP [IF EXISTS] PARTITION spec1[, PARTITION spec2, ...];
   * </code></pre>
   * <p>
   * ALTER VIEW ... DROP PARTITION ... is not supported because the concept of partitioning
   * is associated with physical tables
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitDropTablePartitions (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DropTablePartitionsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link DropView} command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  java.lang.Object visitDropView (org.apache.spark.sql.catalyst.parser.SqlBaseParser.DropViewContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a filtering correlated sub-query (EXISTS).
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitExists (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ExistsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a double literal for number with an exponent, e.g. 1E-30
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitExponentLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ExponentLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Extract expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitExtract (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ExtractContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link First} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitFirst (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FirstContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Float Literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitFloatLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FloatLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create or resolve a frame boundary expressions.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitFrameBound (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FrameBoundContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a logical plan for a given 'FROM' clause. Note that we support multiple (comma
   * separated) relations here, these get converted into a single plan by condition-less inner join.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitFromClause (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FromClauseContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitFromStatement (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FromStatementContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a (windowed) Function expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitFunctionCall (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FunctionCallContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link FunctionIdentifier} from a 'functionName' or 'databaseName'.'functionName' pattern.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.FunctionIdentifier visitFunctionIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.FunctionIdentifierContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a function database (optional) and name pair, for multipartIdentifier.
   * This is used in CREATE FUNCTION, DROP FUNCTION, SHOWFUNCTIONS.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.FunctionIdentifier visitFunctionName (org.apache.spark.sql.catalyst.parser.SqlBaseParser.MultipartIdentifierContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a function database (optional) and name pair.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.FunctionIdentifier visitFunctionName (org.apache.spark.sql.catalyst.parser.SqlBaseParser.QualifiedNameContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a {@link AlterTableAlterColumnStatement} command. This is Hive SQL syntax.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table [PARTITION partition_spec]
   *   CHANGE [COLUMN] column_old_name column_new_name column_dataType [COMMENT column_comment]
   *   [FIRST | AFTER column_name];
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitHiveChangeColumn (org.apache.spark.sql.catalyst.parser.SqlBaseParser.HiveChangeColumnContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitHiveReplaceColumns (org.apache.spark.sql.catalyst.parser.SqlBaseParser.HiveReplaceColumnsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Sequence of Strings for a parenthesis enclosed alias list.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> visitIdentifierList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.IdentifierListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Sequence of Strings for an identifier list.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> visitIdentifierSeq (org.apache.spark.sql.catalyst.parser.SqlBaseParser.IdentifierSeqContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an inline table (a virtual table in Hive parlance).
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitInlineTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InlineTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Add an INSERT INTO TABLE operation to the logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple4<org.apache.spark.sql.catalyst.analysis.UnresolvedRelation, scala.collection.Seq<java.lang.String>, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>>, java.lang.Object> visitInsertIntoTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InsertIntoTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Write to a directory, returning a {@link InsertIntoDir} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple3<java.lang.Object, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat, scala.Option<java.lang.String>> visitInsertOverwriteDir (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InsertOverwriteDirContext ctx)  { throw new RuntimeException(); }
  /**
   * Write to a directory, returning a {@link InsertIntoDir} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple3<java.lang.Object, org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat, scala.Option<java.lang.String>> visitInsertOverwriteHiveDir (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InsertOverwriteHiveDirContext ctx)  { throw new RuntimeException(); }
  /**
   * Add an INSERT OVERWRITE TABLE operation to the logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple4<org.apache.spark.sql.catalyst.analysis.UnresolvedRelation, scala.collection.Seq<java.lang.String>, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>>, java.lang.Object> visitInsertOverwriteTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.InsertOverwriteTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an integral literal expression. The code selects the most narrow integral type
   * possible, either a BigDecimal, a Long or an Integer is returned.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitIntegerLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.IntegerLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CalendarInterval} literal expression. Two syntaxes are supported:
   * - multiple unit value pairs, for instance: interval 2 months 2 days.
   * - from-to unit, for instance: interval '1-2' year to month.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitInterval (org.apache.spark.sql.catalyst.parser.SqlBaseParser.IntervalContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link LambdaFunction}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitLambda (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LambdaContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link Last} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitLast (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LastContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a decimal literal for a regular decimal number or a scientific decimal number.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitLegacyDecimalLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LegacyDecimalLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link LoadData}.
   * <p>
   * For example:
   * <pre><code>
   *   LOAD DATA [LOCAL] INPATH 'filepath' [OVERWRITE] INTO TABLE multi_part_name
   *   [PARTITION (partcol1=val1, partcol2=val2 ...)]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitLoadData (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LoadDataContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a location string.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String visitLocationSpec (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LocationSpecContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an optional location string.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  scala.Option<java.lang.String> visitLocationSpecList (java.util.List<org.apache.spark.sql.catalyst.parser.SqlBaseParser.LocationSpecContext> ctx)  { throw new RuntimeException(); }
  /**
   * Combine a number of boolean expressions into a balanced expression tree. These expressions are
   * either combined by a logical {@link And} or a logical {@link Or}.
   * <p>
   * A balanced binary tree is created because regular left recursive trees cause considerable
   * performance degradations and can cause stack overflows.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitLogicalBinary (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LogicalBinaryContext ctx)  { throw new RuntimeException(); }
  /**
   * Invert a boolean expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitLogicalNot (org.apache.spark.sql.catalyst.parser.SqlBaseParser.LogicalNotContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitMergeIntoTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.MergeIntoTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a logical plan which allows for multiple inserts using one 'from' statement. These
   * queries have the following SQL form:
   * <pre><code>
   *   [WITH cte...]?
   *   FROM src
   *   [INSERT INTO tbl1 SELECT *]+
   * </code></pre>
   * For example:
   * <pre><code>
   *   FROM db.tbl1 A
   *   INSERT INTO dbo.tbl1 SELECT * WHERE A.value = 10 LIMIT 5
   *   INSERT INTO dbo.tbl2 SELECT * WHERE A.value = 12
   * </code></pre>
   * This (Hive) feature cannot be combined with set-operators.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitMultiInsertQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.MultiInsertQueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Creates a {@link CalendarInterval} with multiple unit value pairs, e.g. 1 YEAR 2 DAYS.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.unsafe.types.CalendarInterval visitMultiUnitsInterval (org.apache.spark.sql.catalyst.parser.SqlBaseParser.MultiUnitsIntervalContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a multi-part identifier.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> visitMultipartIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.MultipartIdentifierContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an aliased expression if an alias is specified. Both single and multi-aliases are
   * supported.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitNamedExpression (org.apache.spark.sql.catalyst.parser.SqlBaseParser.NamedExpressionContext ctx)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> visitNamedExpressionSeq (org.apache.spark.sql.catalyst.parser.SqlBaseParser.NamedExpressionSeqContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a named logical plan.
   * <p>
   * This is only used for Common Table Expressions.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.SubqueryAlias visitNamedQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.NamedQueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a partition specification map without optional values.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  protected  scala.collection.immutable.Map<java.lang.String, java.lang.String> visitNonOptionalPartitionSpec (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PartitionSpecContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a NULL literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitNullLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.NullLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Overlay expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitOverlay (org.apache.spark.sql.catalyst.parser.SqlBaseParser.OverlayContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an expression for an expression between parentheses. This is need because the ANTLR
   * visitor cannot automatically convert the nested context into an expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitParenthesizedExpression (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ParenthesizedExpressionContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a list of transforms or columns.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform>, scala.collection.Seq<org.apache.spark.sql.types.StructField>> visitPartitionFieldList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PartitionFieldListContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a partition specification map.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> visitPartitionSpec (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PartitionSpecContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Transform visitPartitionTransform (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PartitionTransformContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Pivot column value with or without an alias.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitPivotValue (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PivotValueContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Position expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitPosition (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PositionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a predicated expression. A predicated expression is a normal expression with a
   * predicate attached to it, for example:
   * <pre><code>
   *    a + 1 IS NULL
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitPredicated (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PredicatedContext ctx)  { throw new RuntimeException(); }
  /**
   * Resolve/create a primitive type.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.DataType visitPrimitiveDataType (org.apache.spark.sql.catalyst.parser.SqlBaseParser.PrimitiveDataTypeContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a key-value map from a {@link TablePropertyListContext}, assuming all values are specified.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> visitPropertyKeyValues (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TablePropertyListContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a list of keys from a {@link TablePropertyListContext}, assuming no values are specified.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> visitPropertyKeys (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TablePropertyListContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse new column info from ADD COLUMN into a QualifiedColType.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.QualifiedColType visitQualifiedColTypeWithPosition (org.apache.spark.sql.catalyst.parser.SqlBaseParser.QualifiedColTypeWithPositionContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a qualified name to a multipart name.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> visitQualifiedName (org.apache.spark.sql.catalyst.parser.SqlBaseParser.QualifiedNameContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a top-level plan with Common Table Expressions.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.QueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link RecoverPartitions}
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE multi_part_name RECOVER PARTITIONS;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRecoverPartitions (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RecoverPartitionsContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRefreshFunction (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RefreshFunctionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link RefreshTable}.
   * <p>
   * For example:
   * <pre><code>
   *   REFRESH TABLE multi_part_name
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRefreshTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RefreshTableContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRegularQuerySpecification (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RegularQuerySpecificationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a single relation referenced in a FROM clause. This method is used when a part of the
   * join condition is nested, for example:
   * <pre><code>
   *   select * from t1 join (t2 cross join t3) on col1 = col2
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRelation (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RelationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link RenameTable} command.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE multi_part_name1 RENAME TO multi_part_name2;
   *   ALTER VIEW multi_part_name1 RENAME TO multi_part_name2;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRenameTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RenameTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse a {@link AlterTableRenameColumnStatement} command.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table1 RENAME COLUMN a.b.c TO x
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRenameTableColumn (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RenameTableColumnContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link RenamePartitions}
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE multi_part_name PARTITION spec1 RENAME TO PARTITION spec2;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRenameTablePartition (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RenameTablePartitionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link RepairTable}.
   * <p>
   * For example:
   * <pre><code>
   *   MSCK REPAIR TABLE multi_part_name [{ADD|DROP|SYNC} PARTITIONS]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitRepairTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RepairTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Replace a table, returning a {@link ReplaceTableStatement} logical plan.
   * <p>
   * Expected format:
   * <pre><code>
   *   [CREATE OR] REPLACE TABLE [db_name.]table_name
   *   [USING table_provider]
   *   replace_table_clauses
   *   {&#64;link AS] select_statement];
   *
   *   replace_table_clauses (order insensitive):
   *     [OPTIONS table_property_list]
   *     [PARTITIONED BY (partition_fields)]
   *     [CLUSTERED BY (col_name, col_name, ...)
   *       [SORTED BY (col_name [ASC|DESC], ...)]
   *       INTO num_buckets BUCKETS
   *     ]
   *     [LOCATION path]
   *     [COMMENT table_comment]
   *     [TBLPROPERTIES (property_name=property_value, ...)]
   *
   *   partition_fields:
   *     col_name, transform(col_name), transform(constant, col_name), ... |
   *     col_name data_type [NOT NULL] [COMMENT col_comment], ...
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitReplaceTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ReplaceTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Validate a replace table statement and return the {@link TableIdentifier}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple4<scala.collection.Seq<java.lang.String>, java.lang.Object, java.lang.Object, java.lang.Object> visitReplaceTableHeader (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ReplaceTableHeaderContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CreateStruct} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitRowConstructor (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowConstructorContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link SerdeInfo} used for creating tables.
   * <p>
   * Example format:
   * <pre><code>
   *   SERDE serde_name [WITH SERDEPROPERTIES (k1=v1, k2=v2, ...)]
   * </code></pre>
   * <p>
   * OR
   * <p>
   * <pre><code>
   *   DELIMITED [FIELDS TERMINATED BY char [ESCAPED BY char}
   *   [COLLECTION ITEMS TERMINATED BY char]
   *   [MAP KEYS TERMINATED BY char]
   *   [LINES TERMINATED BY char]
   *   [NULL DEFINED AS char]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.SerdeInfo visitRowFormat (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a delimited row format properties object.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.SerdeInfo visitRowFormatDelimited (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatDelimitedContext ctx)  { throw new RuntimeException(); }
  /**
   * Create SERDE row format name and properties pair.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.SerdeInfo visitRowFormatSerde (org.apache.spark.sql.catalyst.parser.SqlBaseParser.RowFormatSerdeContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a condition based {@link CaseWhen} expression. This has the following SQL syntax:
   * <pre><code>
   *   CASE
   *    WHEN [predicate] THEN [expression]
   *    ...
   *    ELSE [expression]
   *   END
   * </code></pre>
   * <p>
   * @param ctx the parse tree
   * @return (undocumented)
   *    */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitSearchedCase (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SearchedCaseContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link SetNamespaceLocation} logical plan.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER (DATABASE|SCHEMA|NAMESPACE) namespace SET LOCATION path;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetNamespaceLocation (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetNamespaceLocationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link SetNamespaceProperties} logical plan.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER (DATABASE|SCHEMA|NAMESPACE) database
   *   SET (DBPROPERTIES|PROPERTIES) (property_name=property_value, ...);
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetNamespaceProperties (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetNamespacePropertiesContext ctx)  { throw new RuntimeException(); }
  /**
   * Connect two queries by a Set operator.
   * <p>
   * Supported Set operators are:
   * - UNION [ DISTINCT | ALL ]
   * - EXCEPT [ DISTINCT | ALL ]
   * - MINUS [ DISTINCT | ALL ]
   * - INTERSECT [DISTINCT | ALL]
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetOperation (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetOperationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link SetTableLocation} command.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table_name [PARTITION partition_spec] SET LOCATION "loc";
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetTableLocation (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetTableLocationContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse {@link SetViewProperties} or {@link SetTableProperties} commands.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table SET TBLPROPERTIES ('table_property' = 'property_value');
   *   ALTER VIEW view SET TBLPROPERTIES ('table_property' = 'property_value');
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetTableProperties (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetTablePropertiesContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link SetTableSerDeProperties}
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE multi_part_name [PARTITION spec] SET SERDE serde_name
   *     [WITH SERDEPROPERTIES props];
   *   ALTER TABLE multi_part_name [PARTITION spec] SET SERDEPROPERTIES serde_properties;
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSetTableSerDe (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SetTableSerDeContext ctx)  { throw new RuntimeException(); }
  /**
   * A command for users to list the column names for a table.
   * This function creates a {@link ShowColumns} logical plan.
   * <p>
   * The syntax of using this command in SQL is:
   * <pre><code>
   *   SHOW COLUMNS (FROM | IN) tableName=multipartIdentifier
   *        ((FROM | IN) namespace=multipartIdentifier)?
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowColumns (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowColumnsContext ctx)  { throw new RuntimeException(); }
  /**
   * Creates a {@link ShowCreateTable}
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowCreateTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowCreateTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ShowCurrentNamespaceStatement}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowCurrentNamespace (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowCurrentNamespaceContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a plan for a SHOW FUNCTIONS command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowFunctions (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowFunctionsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ShowNamespaces} command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowNamespaces (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowNamespacesContext ctx)  { throw new RuntimeException(); }
  /**
   * A command for users to list the partition names of a table. If partition spec is specified,
   * partitions that match the spec are returned. Otherwise an empty result set is returned.
   * <p>
   * This function creates a {@link ShowPartitionsStatement} logical plan
   * <p>
   * The syntax of using this command in SQL is:
   * <pre><code>
   *   SHOW PARTITIONS multi_part_name [partition_spec];
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowPartitions (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowPartitionsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ShowTableExtended} command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowTableExtended (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowTableExtendedContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ShowTables} command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowTables (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowTablesContext ctx)  { throw new RuntimeException(); }
  /**
   * A command for users to list the properties for a table. If propertyKey is specified, the value
   * for the propertyKey is returned. If propertyKey is not specified, all the keys and their
   * corresponding values are returned.
   * The syntax of using this command in SQL is:
   * <pre><code>
   *   SHOW TBLPROPERTIES multi_part_name[('propertyKey')];
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowTblProperties (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowTblPropertiesContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ShowViews} command.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitShowViews (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ShowViewsContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a value based {@link CaseWhen} expression. This has the following SQL form:
   * <pre><code>
   *   CASE [expression]
   *    WHEN [value] THEN [expression]
   *    ...
   *    ELSE [expression]
   *   END
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitSimpleCase (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SimpleCaseContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType visitSingleDataType (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleDataTypeContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression visitSingleExpression (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleExpressionContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.FunctionIdentifier visitSingleFunctionIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleFunctionIdentifierContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a logical plan for a regular (single-insert) query.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSingleInsertQuery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleInsertQueryContext ctx)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> visitSingleMultipartIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleMultipartIdentifierContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSingleStatement (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleStatementContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier visitSingleTableIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleTableIdentifierContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType visitSingleTableSchema (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SingleTableSchemaContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Short Literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitSmallIntLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SmallIntLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link SortOrder} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.SortOrder visitSortItem (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SortItemContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a star (i.e. all) expression; this selects all elements (in the specified object).
   * Both un-targeted (global) and targeted aliases are supported.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitStar (org.apache.spark.sql.catalyst.parser.SqlBaseParser.StarContext ctx)  { throw new RuntimeException(); }
  /**
   * Convert a constant of any type into a string. This is typically used in DDL commands, and its
   * main purpose is to prevent slight differences due to back to back conversions i.e.:
   * String -> Literal -> String.
   * @param ctx (undocumented)
   * @param legacyNullAsString (undocumented)
   * @return (undocumented)
   */
  protected  java.lang.String visitStringConstant (org.apache.spark.sql.catalyst.parser.SqlBaseParser.ConstantContext ctx, boolean legacyNullAsString)  { throw new RuntimeException(); }
  /**
   * Create a String literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitStringLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.StringLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link CreateStruct} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitStruct (org.apache.spark.sql.catalyst.parser.SqlBaseParser.StructContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a logical plan for a sub-query.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitSubquery (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SubqueryContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link ScalarSubquery} expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitSubqueryExpression (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SubqueryExpressionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link UnresolvedExtractValue} expression, this is used for subscript access to an array.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitSubscript (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SubscriptContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Substring/Substr expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitSubstring (org.apache.spark.sql.catalyst.parser.SqlBaseParser.SubstringContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an un-aliased table reference. This is typically used for top-level table references,
   * for example:
   * <pre><code>
   *   INSERT INTO db.tbl2
   *   TABLE db.tbl1
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link TableIdentifier} from a 'tableName' or 'databaseName'.'tableName' pattern.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.TableIdentifier visitTableIdentifier (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TableIdentifierContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an aliased table reference. This is typically used in FROM clauses.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitTableName (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TableNameContext ctx)  { throw new RuntimeException(); }
  /**
   * A table property key can either be String or a collection of dot separated elements. This
   * function extracts the property key based on whether its a string literal or a table property
   * identifier.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String visitTablePropertyKey (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TablePropertyKeyContext key)  { throw new RuntimeException(); }
  /**
   * Convert a table property list into a key-value map.
   * This should be called through {@link visitPropertyKeyValues} or {@link visitPropertyKeys}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> visitTablePropertyList (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TablePropertyListContext ctx)  { throw new RuntimeException(); }
  /**
   * A table property value can be String, Integer, Boolean or Decimal. This function extracts
   * the property value based on whether its a string, integer, boolean or decimal literal.
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String visitTablePropertyValue (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TablePropertyValueContext value)  { throw new RuntimeException(); }
  /**
   * Create a table-valued function call with arguments, e.g. range(1000)
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitTableValuedFunction (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TableValuedFunctionContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Byte Literal expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitTinyIntLiteral (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TinyIntLiteralContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse an argument to a transform. An argument may be a field reference (qualified name) or
   * a value literal.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.connector.expressions.Expression visitTransformArgument (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TransformArgumentContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitTransformQuerySpecification (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TransformQuerySpecificationContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a Trim expression.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression visitTrim (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TrimContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link TruncateTable} command.
   * <p>
   * For example:
   * <pre><code>
   *   TRUNCATE TABLE multi_part_name [PARTITION (partcol1=val1, partcol2=val2 ...)]
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitTruncateTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TruncateTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a typed Literal expression. A typed literal has the following SQL syntax:
   * <pre><code>
   *   [TYPE] '[VALUE]'
   * </code></pre>
   * Currently Date, Timestamp, Interval and Binary typed literals are supported.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Literal visitTypeConstructor (org.apache.spark.sql.catalyst.parser.SqlBaseParser.TypeConstructorContext ctx)  { throw new RuntimeException(); }
  /**
   * Create an {@link UncacheTable} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitUncacheTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.UncacheTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Creates a {@link CalendarInterval} with from-to unit, e.g. '2-1' YEAR TO MONTH.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.unsafe.types.CalendarInterval visitUnitToUnitInterval (org.apache.spark.sql.catalyst.parser.SqlBaseParser.UnitToUnitIntervalContext ctx)  { throw new RuntimeException(); }
  /**
   * Parse {@link UnsetViewProperties} or {@link UnsetTableProperties} commands.
   * <p>
   * For example:
   * <pre><code>
   *   ALTER TABLE table UNSET TBLPROPERTIES [IF EXISTS] ('comment', 'key');
   *   ALTER VIEW view UNSET TBLPROPERTIES [IF EXISTS] ('comment', 'key');
   * </code></pre>
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitUnsetTableProperties (org.apache.spark.sql.catalyst.parser.SqlBaseParser.UnsetTablePropertiesContext ctx)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitUpdateTable (org.apache.spark.sql.catalyst.parser.SqlBaseParser.UpdateTableContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a {@link UseStatement} logical plan.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan visitUse (org.apache.spark.sql.catalyst.parser.SqlBaseParser.UseContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a window definition, i.e. {@link WindowSpecDefinition}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.WindowSpecDefinition visitWindowDef (org.apache.spark.sql.catalyst.parser.SqlBaseParser.WindowDefContext ctx)  { throw new RuntimeException(); }
  /**
   * Create a reference to a window frame, i.e. {@link WindowSpecReference}.
   * @param ctx (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.WindowSpecReference visitWindowRef (org.apache.spark.sql.catalyst.parser.SqlBaseParser.WindowRefContext ctx)  { throw new RuntimeException(); }
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
