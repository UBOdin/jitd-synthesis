package org.apache.spark.sql.errors;
/**
 * Object for grouping all error messages of the query compilation.
 * Currently it includes all AnalysisExceptions.
 */
public  class QueryCompilationErrors {
  static public  java.lang.Throwable groupingIDMismatchError (org.apache.spark.sql.catalyst.expressions.GroupingID groupingID, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupByExprs)  { throw new RuntimeException(); }
  static public  java.lang.Throwable groupingColInvalidError (org.apache.spark.sql.catalyst.expressions.Expression groupingCol, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> groupByExprs)  { throw new RuntimeException(); }
  static public  java.lang.Throwable groupingSizeTooLargeError (int sizeLimit)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unorderablePivotColError (org.apache.spark.sql.catalyst.expressions.Expression pivotCol)  { throw new RuntimeException(); }
  static public  java.lang.Throwable nonLiteralPivotValError (org.apache.spark.sql.catalyst.expressions.Expression pivotVal)  { throw new RuntimeException(); }
  static public  java.lang.Throwable pivotValDataTypeMismatchError (org.apache.spark.sql.catalyst.expressions.Expression pivotVal, org.apache.spark.sql.catalyst.expressions.Expression pivotCol)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedIfNotExistsError (java.lang.String tableName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable nonPartitionColError (java.lang.String partitionName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable addStaticValToUnknownColError (java.lang.String staticName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unknownStaticPartitionColError (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.Throwable nestedGeneratorError (org.apache.spark.sql.catalyst.expressions.Expression trimmedNestedGenerator)  { throw new RuntimeException(); }
  static public  java.lang.Throwable moreThanOneGeneratorError (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> generators, java.lang.String clause)  { throw new RuntimeException(); }
  static public  java.lang.Throwable generatorOutsideSelectError (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static public  java.lang.Throwable legacyStoreAssignmentPolicyError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable unresolvedUsingColForJoinError (java.lang.String colName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, java.lang.String side)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeMismatchForDeserializerError (org.apache.spark.sql.types.DataType dataType, java.lang.String desiredType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable fieldNumberMismatchForDeserializerError (org.apache.spark.sql.types.StructType schema, int maxOrdinal)  { throw new RuntimeException(); }
  static public  java.lang.Throwable upCastFailureError (java.lang.String fromStr, org.apache.spark.sql.catalyst.expressions.Expression from, org.apache.spark.sql.types.DataType to, scala.collection.Seq<java.lang.String> walkedTypePath)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedAbstractDataTypeForUpCastError (org.apache.spark.sql.types.AbstractDataType gotType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable outerScopeFailureForNewInstanceError (java.lang.String className)  { throw new RuntimeException(); }
  static public  java.lang.Throwable referenceColNotFoundForAlterTableChangesError (org.apache.spark.sql.connector.catalog.TableChange.After after, java.lang.String parentName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable windowSpecificationNotDefinedError (java.lang.String windowName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable selectExprNotInGroupByError (org.apache.spark.sql.catalyst.expressions.Expression expr, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Alias> groupByAliases)  { throw new RuntimeException(); }
  static public  java.lang.Throwable groupingMustWithGroupingSetsOrCubeOrRollupError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable pandasUDFAggregateNotSupportedInPivotError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable aggregateExpressionRequiredForPivotError (java.lang.String sql)  { throw new RuntimeException(); }
  static public  java.lang.Throwable writeIntoTempViewNotAllowedError (java.lang.String quoted)  { throw new RuntimeException(); }
  static public  java.lang.Throwable expectTableOrPermanentViewNotTempViewError (java.lang.String quoted, java.lang.String cmd, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable readNonStreamingTempViewError (java.lang.String quoted)  { throw new RuntimeException(); }
  static public  java.lang.Throwable viewDepthExceedsMaxResolutionDepthError (org.apache.spark.sql.catalyst.TableIdentifier identifier, int maxNestedViewDepth, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable insertIntoViewNotAllowedError (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable writeIntoViewNotAllowedError (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable writeIntoV1TableNotAllowedError (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable expectTableNotViewError (org.apache.spark.sql.catalyst.analysis.ResolvedView v, java.lang.String cmd, scala.Option<java.lang.String> mismatchHint, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable expectViewNotTableError (org.apache.spark.sql.catalyst.analysis.ResolvedTable v, java.lang.String cmd, scala.Option<java.lang.String> mismatchHint, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable permanentViewNotSupportedByStreamingReadingAPIError (java.lang.String quoted)  { throw new RuntimeException(); }
  static public  java.lang.Throwable starNotAllowedWhenGroupByOrdinalPositionUsedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidStarUsageError (java.lang.String prettyName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable singleTableStarInCountNotAllowedError (java.lang.String targetString)  { throw new RuntimeException(); }
  static public  java.lang.Throwable orderByPositionRangeError (int index, int size, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable groupByPositionRangeError (int index, int size, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable generatorNotExpectedError (org.apache.spark.sql.catalyst.FunctionIdentifier name, java.lang.String classCanonicalName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable functionWithUnsupportedSyntaxError (java.lang.String prettyName, java.lang.String syntax)  { throw new RuntimeException(); }
  static public  java.lang.Throwable nonDeterministicFilterInAggregateError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable aliasNumberNotMatchColumnNumberError (int columnSize, int outputSize, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable aliasesNumberNotMatchUDTFOutputError (int aliasesSize, java.lang.String aliasesNames)  { throw new RuntimeException(); }
  static public  java.lang.Throwable windowAggregateFunctionWithFilterNotSupportedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable windowFunctionInsideAggregateFunctionNotAllowedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable expressionWithoutWindowExpressionError (org.apache.spark.sql.catalyst.expressions.NamedExpression expr)  { throw new RuntimeException(); }
  static public  java.lang.Throwable expressionWithMultiWindowExpressionsError (org.apache.spark.sql.catalyst.expressions.NamedExpression expr, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.WindowSpecDefinition> distinctWindowSpec)  { throw new RuntimeException(); }
  static public  java.lang.Throwable windowFunctionNotAllowedError (java.lang.String clauseName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotSpecifyWindowFrameError (java.lang.String prettyName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable windowFrameNotMatchRequiredFrameError (org.apache.spark.sql.catalyst.expressions.SpecifiedWindowFrame f, org.apache.spark.sql.catalyst.expressions.WindowFrame required)  { throw new RuntimeException(); }
  static public  java.lang.Throwable windowFunctionWithWindowFrameNotOrderedError (org.apache.spark.sql.catalyst.expressions.WindowFunction wf)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotResolveUserSpecifiedColumnsError (java.lang.String col, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable writeTableWithMismatchedColumnsError (int columnSize, int outputSize, org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable multiTimeWindowExpressionsNotSupportedError (org.apache.spark.sql.catalyst.trees.TreeNode<?> t)  { throw new RuntimeException(); }
  static public  java.lang.Throwable viewOutputNumberMismatchQueryColumnNamesError (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<java.lang.String> queryColumnNames)  { throw new RuntimeException(); }
  static public  java.lang.Throwable attributeNotFoundError (java.lang.String colName, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotUpCastAsAttributeError (org.apache.spark.sql.catalyst.expressions.Attribute fromAttr, org.apache.spark.sql.catalyst.expressions.Attribute toAttr)  { throw new RuntimeException(); }
  static public  java.lang.Throwable functionUndefinedError (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidFunctionArgumentsError (java.lang.String name, java.lang.String expectedInfo, int actualNumber)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidFunctionArgumentNumberError (scala.collection.Seq<java.lang.Object> validParametersCount, java.lang.String name, scala.collection.Seq<java.lang.Class<org.apache.spark.sql.catalyst.expressions.Expression>> params)  { throw new RuntimeException(); }
  static public  java.lang.Throwable functionAcceptsOnlyOneArgumentError (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.Throwable alterV2TableSetLocationWithPartitionNotSupportedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable joinStrategyHintParameterNotSupportedError (Object unsupported)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidHintParameterError (java.lang.String hintName, scala.collection.Seq<java.lang.Object> invalidParams)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidCoalesceHintParameterError (java.lang.String hintName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable attributeNameSyntaxError (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.Throwable starExpandDataTypeNotSupportedError (scala.collection.Seq<java.lang.String> attributes)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotResolveStarExpandGivenInputColumnsError (java.lang.String targetString, java.lang.String columns)  { throw new RuntimeException(); }
  static public  java.lang.Throwable addColumnWithV1TableCannotSpecifyNotNullError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable replaceColumnsOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable alterQualifiedColumnOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable alterColumnWithV1TableCannotSpecifyNotNullError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable alterOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable alterColumnCannotFindColumnInV1TableError (java.lang.String colName, org.apache.spark.sql.connector.catalog.V1Table v1Table)  { throw new RuntimeException(); }
  static public  java.lang.Throwable renameColumnOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable dropColumnOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidDatabaseNameError (java.lang.String quoted)  { throw new RuntimeException(); }
  static public  java.lang.Throwable replaceTableOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable replaceTableAsSelectOnlySupportedWithV2TableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotDropViewWithDropTableError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable showColumnsWithConflictDatabasesError (scala.collection.Seq<java.lang.String> db, org.apache.spark.sql.catalyst.TableIdentifier v1TableName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable externalCatalogNotSupportShowViewsError (org.apache.spark.sql.catalyst.analysis.ResolvedNamespace resolved)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedFunctionNameError (java.lang.String quoted)  { throw new RuntimeException(); }
  static public  java.lang.Throwable sqlOnlySupportedWithV1TablesError (java.lang.String sql)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotCreateTableWithBothProviderAndSerdeError (scala.Option<java.lang.String> provider, scala.Option<org.apache.spark.sql.catalyst.plans.logical.SerdeInfo> maybeSerdeInfo)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidFileFormatForStoredAsError (org.apache.spark.sql.catalyst.plans.logical.SerdeInfo serdeInfo)  { throw new RuntimeException(); }
  static public  java.lang.Throwable commandNotSupportNestedColumnError (java.lang.String command, java.lang.String quoted)  { throw new RuntimeException(); }
  static public  java.lang.Throwable columnDoesNotExistError (java.lang.String colName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable renameTempViewToExistingViewError (java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable databaseNotEmptyError (java.lang.String db, java.lang.String details)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidNameForTableOrDatabaseError (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotCreateDatabaseWithSameNameAsPreservedDatabaseError (java.lang.String database)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotDropDefaultDatabaseError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotUsePreservedDatabaseAsCurrentDatabaseError (java.lang.String database)  { throw new RuntimeException(); }
  static public  java.lang.Throwable createExternalTableWithoutLocationError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotOperateManagedTableWithExistingLocationError (java.lang.String methodName, org.apache.spark.sql.catalyst.TableIdentifier tableIdentifier, org.apache.hadoop.fs.Path tableLocation)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dropNonExistentColumnsNotSupportedError (scala.collection.Seq<java.lang.String> nonExistentColumnNames)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotRetrieveTableOrViewNotInSameDatabaseError (scala.collection.Seq<org.apache.spark.sql.catalyst.QualifiedTableName> qualifiedTableNames)  { throw new RuntimeException(); }
  static public  java.lang.Throwable renameTableSourceAndDestinationMismatchError (java.lang.String db, java.lang.String newDb)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotRenameTempViewWithDatabaseSpecifiedError (org.apache.spark.sql.catalyst.TableIdentifier oldName, org.apache.spark.sql.catalyst.TableIdentifier newName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotRenameTempViewToExistingTableError (org.apache.spark.sql.catalyst.TableIdentifier oldName, org.apache.spark.sql.catalyst.TableIdentifier newName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidPartitionSpecError (java.lang.String details)  { throw new RuntimeException(); }
  static public  java.lang.Throwable functionAlreadyExistsError (org.apache.spark.sql.catalyst.FunctionIdentifier func)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotLoadClassWhenRegisteringFunctionError (java.lang.String className, org.apache.spark.sql.catalyst.FunctionIdentifier func)  { throw new RuntimeException(); }
  static public  java.lang.Throwable v2CatalogNotSupportFunctionError (java.lang.String catalog, scala.collection.Seq<java.lang.String> namespace)  { throw new RuntimeException(); }
  static public  java.lang.Throwable resourceTypeNotSupportedError (java.lang.String resourceType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable tableNotSpecifyDatabaseError (org.apache.spark.sql.catalyst.TableIdentifier identifier)  { throw new RuntimeException(); }
  static public  java.lang.Throwable tableNotSpecifyLocationUriError (org.apache.spark.sql.catalyst.TableIdentifier identifier)  { throw new RuntimeException(); }
  static public  java.lang.Throwable partitionNotSpecifyLocationUriError (java.lang.String specString)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidBucketNumberError (int bucketingMaxBuckets, int numBuckets)  { throw new RuntimeException(); }
  static public  java.lang.Throwable corruptedTableNameContextInCatalogError (int numParts, int index)  { throw new RuntimeException(); }
  static public  java.lang.Throwable corruptedViewSQLConfigsInCatalogError (java.lang.Exception e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable corruptedViewQueryOutputColumnsInCatalogError (java.lang.String numCols, int index)  { throw new RuntimeException(); }
  static public  java.lang.Throwable corruptedViewReferredTempViewInCatalogError (java.lang.Exception e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable corruptedViewReferredTempFunctionsInCatalogError (java.lang.Exception e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable columnStatisticsDeserializationNotSupportedError (java.lang.String name, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable columnStatisticsSerializationNotSupportedError (java.lang.String colName, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotReadCorruptedTablePropertyError (java.lang.String key, java.lang.String details)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidSchemaStringError (org.apache.spark.sql.catalyst.expressions.Expression exp)  { throw new RuntimeException(); }
  static public  java.lang.Throwable schemaNotFoldableError (org.apache.spark.sql.catalyst.expressions.Expression exp)  { throw new RuntimeException(); }
  static public  java.lang.Throwable schemaIsNotStructTypeError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable keyValueInMapNotStringError (org.apache.spark.sql.catalyst.expressions.CreateMap m)  { throw new RuntimeException(); }
  static public  java.lang.Throwable nonMapFunctionNotAllowedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidFieldTypeForCorruptRecordError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnsupportedByClassError (org.apache.spark.sql.types.DataType x, java.lang.String className)  { throw new RuntimeException(); }
  static public  java.lang.Throwable parseModeUnsupportedError (java.lang.String funcName, org.apache.spark.sql.catalyst.util.ParseMode mode)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unfoldableFieldUnsupportedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable literalTypeUnsupportedForSourceTypeError (java.lang.String field, org.apache.spark.sql.catalyst.expressions.Expression source)  { throw new RuntimeException(); }
  static public  java.lang.Throwable arrayComponentTypeUnsupportedError (java.lang.Class<?> clz)  { throw new RuntimeException(); }
  static public  java.lang.Throwable secondArgumentNotDoubleLiteralError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnsupportedByExtractValueError (org.apache.spark.sql.types.DataType dataType, org.apache.spark.sql.catalyst.expressions.Expression extraction, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  static public  java.lang.Throwable noHandlerForUDAFError (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.Throwable databaseFromV1SessionCatalogNotSpecifiedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable nestedDatabaseUnsupportedByV1SessionCatalogError (java.lang.String catalog)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidRepartitionExpressionsError (scala.collection.Seq<java.lang.Object> sortOrders)  { throw new RuntimeException(); }
  static public  java.lang.Throwable partitionColumnNotSpecifiedError (java.lang.String format, java.lang.String partitionColumn)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataSchemaNotSpecifiedError (java.lang.String format)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataPathNotExistError (java.lang.String path)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataSourceOutputModeUnsupportedError (java.lang.String className, org.apache.spark.sql.streaming.OutputMode outputMode)  { throw new RuntimeException(); }
  static public  java.lang.Throwable schemaNotSpecifiedForSchemaRelationProviderError (java.lang.String className)  { throw new RuntimeException(); }
  static public  java.lang.Throwable userSpecifiedSchemaMismatchActualSchemaError (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.types.StructType actualSchema)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataSchemaNotSpecifiedError (java.lang.String format, java.lang.String fileCatalog)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidDataSourceError (java.lang.String className)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotSaveIntervalIntoExternalStorageError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotResolveAttributeError (java.lang.String name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan data)  { throw new RuntimeException(); }
  static public  java.lang.Throwable orcNotUsedWithHiveEnabledError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedToFindAvroDataSourceError (java.lang.String provider)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedToFindKafkaDataSourceError (java.lang.String provider)  { throw new RuntimeException(); }
  static public  java.lang.Throwable findMultipleDataSourceError (java.lang.String provider, scala.collection.Seq<java.lang.String> sourceNames)  { throw new RuntimeException(); }
  static public  java.lang.Throwable writeEmptySchemasUnsupportedByDataSourceError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable insertMismatchedColumnNumberError (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> targetAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> sourceAttributes, int staticPartitionsSize)  { throw new RuntimeException(); }
  static public  java.lang.Throwable insertMismatchedPartitionNumberError (org.apache.spark.sql.types.StructType targetPartitionSchema, int providedPartitionsSize)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidPartitionColumnError (java.lang.String partKey, org.apache.spark.sql.types.StructType targetPartitionSchema)  { throw new RuntimeException(); }
  static public  java.lang.Throwable multiplePartitionColumnValuesSpecifiedError (org.apache.spark.sql.types.StructField field, scala.collection.immutable.Map<java.lang.String, java.lang.String> potentialSpecs)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidOrderingForConstantValuePartitionColumnError (org.apache.spark.sql.types.StructType targetPartitionSchema)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotWriteDataToRelationsWithMultiplePathsError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedToRebuildExpressionError (org.apache.spark.sql.sources.Filter filter)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnsupportedByDataSourceError (java.lang.String format, org.apache.spark.sql.types.StructField field)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failToResolveDataSourceForTableError (org.apache.spark.sql.catalyst.catalog.CatalogTable table, java.lang.String key)  { throw new RuntimeException(); }
  static public  java.lang.Throwable outputPathAlreadyExistsError (org.apache.hadoop.fs.Path outputPath)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotUseDataTypeForPartitionColumnError (org.apache.spark.sql.types.StructField field)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotUseAllColumnsForPartitionColumnsError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable partitionColumnNotFoundInSchemaError (java.lang.String col, java.lang.String schemaCatalog)  { throw new RuntimeException(); }
  static public  java.lang.Throwable columnNotFoundInSchemaError (org.apache.spark.sql.types.StructField col, scala.Option<org.apache.spark.sql.types.StructType> tableSchema)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedDataSourceTypeForDirectQueryOnFilesError (java.lang.String className)  { throw new RuntimeException(); }
  static public  java.lang.Throwable saveDataIntoViewNotAllowedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable mismatchedTableFormatError (java.lang.String tableName, java.lang.Class<?> existingProvider, java.lang.Class<?> specifiedProvider)  { throw new RuntimeException(); }
  static public  java.lang.Throwable mismatchedTableLocationError (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.catalyst.catalog.CatalogTable existingTable, org.apache.spark.sql.catalyst.catalog.CatalogTable tableDesc)  { throw new RuntimeException(); }
  static public  java.lang.Throwable mismatchedTableColumnNumberError (java.lang.String tableName, org.apache.spark.sql.catalyst.catalog.CatalogTable existingTable, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotResolveColumnGivenInputColumnsError (java.lang.String col, java.lang.String inputColumns)  { throw new RuntimeException(); }
  static public  java.lang.Throwable mismatchedTablePartitionColumnError (java.lang.String tableName, scala.collection.Seq<java.lang.String> specifiedPartCols, java.lang.String existingPartCols)  { throw new RuntimeException(); }
  static public  java.lang.Throwable mismatchedTableBucketingError (java.lang.String tableName, java.lang.String specifiedBucketString, java.lang.String existingBucketString)  { throw new RuntimeException(); }
  static public  java.lang.Throwable specifyPartitionNotAllowedWhenTableSchemaNotDefinedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable bucketingColumnCannotBePartOfPartitionColumnsError (java.lang.String bucketCol, scala.collection.Seq<java.lang.String> normalizedPartCols)  { throw new RuntimeException(); }
  static public  java.lang.Throwable bucketSortingColumnCannotBePartOfPartitionColumnsError (java.lang.String sortCol, scala.collection.Seq<java.lang.String> normalizedPartCols)  { throw new RuntimeException(); }
  static public  java.lang.Throwable mismatchedInsertedDataColumnNumberError (java.lang.String tableName, org.apache.spark.sql.catalyst.plans.logical.InsertIntoStatement insert, scala.collection.immutable.Set<java.lang.String> staticPartCols)  { throw new RuntimeException(); }
  static public  java.lang.Throwable requestedPartitionsMismatchTablePartitionsError (java.lang.String tableName, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> normalizedPartSpec, org.apache.spark.sql.types.StructType partColNames)  { throw new RuntimeException(); }
  static public  java.lang.Throwable ddlWithoutHiveSupportEnabledError (java.lang.String detail)  { throw new RuntimeException(); }
  static public  java.lang.Throwable createTableColumnTypesOptionColumnNotFoundInSchemaError (java.lang.String col, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  static public  java.lang.Throwable parquetTypeUnsupportedError (java.lang.String parquetType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable parquetTypeUnsupportedYetError (java.lang.String parquetType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable illegalParquetTypeError (java.lang.String parquetType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unrecognizedParquetTypeError (java.lang.String field)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotConvertDataTypeToParquetTypeError (org.apache.spark.sql.types.StructField field)  { throw new RuntimeException(); }
}
