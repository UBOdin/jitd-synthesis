package org.apache.spark.sql.errors;
/**
 * Object for grouping all error messages of the query runtime.
 * Currently it includes all SparkExceptions and RuntimeExceptions(e.g.
 * UnsupportedOperationException, IllegalStateException).
 */
public  class QueryExecutionErrors {
  static public  java.lang.Throwable columnChangeUnsupportedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable logicalHintOperatorNotRemovedDuringAnalysisError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotEvaluateExpressionError (org.apache.spark.sql.catalyst.expressions.Expression expression)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotGenerateCodeForExpressionError (org.apache.spark.sql.catalyst.expressions.Expression expression)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotTerminateGeneratorError (org.apache.spark.sql.catalyst.analysis.UnresolvedGenerator generator)  { throw new RuntimeException(); }
  static public  java.lang.ArithmeticException castingCauseOverflowError (Object t, java.lang.String targetType)  { throw new RuntimeException(); }
  static public  java.lang.ArithmeticException cannotChangeDecimalPrecisionError (org.apache.spark.sql.types.Decimal value, int decimalPrecision, int decimalScale)  { throw new RuntimeException(); }
  static public  java.lang.NumberFormatException invalidInputSyntaxForNumericError (org.apache.spark.unsafe.types.UTF8String s)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotCastFromNullTypeError (org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotCastError (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotParseDecimalError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable simpleStringWithNodeIdUnsupportedError (java.lang.String nodeName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable evaluateUnevaluableAggregateUnsupportedError (java.lang.String methodName, org.apache.spark.sql.catalyst.expressions.UnevaluableAggregate unEvaluable)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnsupportedError (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnsupportedError (java.lang.String dataType, java.lang.String failure)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedExecuteUserDefinedFunctionError (java.lang.String funcCls, java.lang.String inputTypes, java.lang.String outputType, java.lang.Throwable e)  { throw new RuntimeException(); }
  static public  java.lang.ArithmeticException divideByZeroError ()  { throw new RuntimeException(); }
  static public  java.lang.ArrayIndexOutOfBoundsException invalidArrayIndexError (int index, int numElements)  { throw new RuntimeException(); }
  static public  java.util.NoSuchElementException mapKeyNotExistError (Object key)  { throw new RuntimeException(); }
  static public  java.lang.Throwable rowFromCSVParserNotExpectedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable inputTypeUnsupportedError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.time.DateTimeException invalidFractionOfSecondError ()  { throw new RuntimeException(); }
  static public  java.lang.ArithmeticException overflowInSumOfDecimalError ()  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException mapSizeExceedArraySizeWhenZipMapError (int size)  { throw new RuntimeException(); }
  static public  java.lang.Throwable copyNullFieldNotAllowedError ()  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException literalTypeUnsupportedError (Object v)  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException noDefaultForDataTypeError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable doGenCodeOfAliasShouldNotBeCalledError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable orderedOperationUnsupportedByDataTypeError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable regexGroupIndexLessThanZeroError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable regexGroupIndexExceedGroupCountError (int groupCount, int groupIndex)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidUrlError (org.apache.spark.unsafe.types.UTF8String url, java.net.URISyntaxException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeOperationUnsupportedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable mergeUnsupportedByWindowFunctionError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnexpectedError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable typeUnsupportedError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable negativeValueUnexpectedError (org.apache.spark.sql.catalyst.expressions.Expression frequencyExpression)  { throw new RuntimeException(); }
  static public  java.lang.Throwable addNewFunctionMismatchedWithFunctionError (java.lang.String funcName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotGenerateCodeForUncomparableTypeError (java.lang.String codeType, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotGenerateCodeForUnsupportedTypeError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotInterpolateClassIntoCodeBlockError (Object arg)  { throw new RuntimeException(); }
  static public  java.lang.Throwable customCollectionClsNotResolvedError ()  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException classUnsupportedByMapObjectsError (java.lang.Class<?> cls)  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException nullAsMapKeyNotAllowedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable methodNotDeclaredError (java.lang.String name)  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException inputExternalRowCannotBeNullError ()  { throw new RuntimeException(); }
  static public  java.lang.String fieldCannotBeNullMsg (int index, java.lang.String fieldName)  { throw new RuntimeException(); }
  static public  java.lang.RuntimeException fieldCannotBeNullError (int index, java.lang.String fieldName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToCreateDatabaseAsFailedToCreateDirectoryError (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToDropDatabaseAsFailedToDeleteDirectoryError (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToCreateTableAsFailedToCreateDirectoryError (java.lang.String table, org.apache.hadoop.fs.Path defaultTableLocation, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToDeletePartitionPathError (org.apache.hadoop.fs.Path partitionPath, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToDropTableAsFailedToDeleteDirectoryError (java.lang.String table, org.apache.hadoop.fs.Path dir, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToRenameTableAsFailedToRenameDirectoryError (java.lang.String oldName, java.lang.String newName, org.apache.hadoop.fs.Path oldDir, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToCreatePartitionPathError (org.apache.hadoop.fs.Path partitionPath, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unableToRenamePartitionPathError (org.apache.hadoop.fs.Path oldPartPath, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable methodNotImplementedError (java.lang.String methodName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable tableStatsNotSpecifiedError ()  { throw new RuntimeException(); }
  static public  java.lang.ArithmeticException unaryMinusCauseOverflowError (short originValue)  { throw new RuntimeException(); }
  static public  java.lang.ArithmeticException binaryArithmeticCauseOverflowError (short eval1, java.lang.String symbol, short eval2)  { throw new RuntimeException(); }
  static public  java.lang.String failedSplitSubExpressionMsg (int length)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedSplitSubExpressionError (int length)  { throw new RuntimeException(); }
  static public  java.lang.String failedToCompileMsg (java.lang.Exception e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable internalCompilerError (org.codehaus.janino.InternalCompilerException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable compilerError (org.codehaus.commons.compiler.CompileException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataPathNotSpecifiedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable createStreamingSourceNotSpecifySchemaError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable streamedOperatorUnsupportedByDataSourceError (java.lang.String className, java.lang.String operator)  { throw new RuntimeException(); }
  static public  java.lang.Throwable multiplePathsSpecifiedError (scala.collection.Seq<java.lang.String> allPaths)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedToFindDataSourceError (java.lang.String provider, java.lang.Throwable error)  { throw new RuntimeException(); }
  static public  java.lang.Throwable removedClassInSpark2Error (java.lang.String className, java.lang.Throwable e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable incompatibleDataSourceRegisterError (java.lang.Throwable e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unrecognizedFileFormatError (java.lang.String format)  { throw new RuntimeException(); }
  static public  org.apache.spark.SparkUpgradeException sparkUpgradeInReadingDatesError (java.lang.String format, java.lang.String config, java.lang.String option)  { throw new RuntimeException(); }
  static public  org.apache.spark.SparkUpgradeException sparkUpgradeInWritingDatesError (java.lang.String format, java.lang.String config)  { throw new RuntimeException(); }
  static public  java.lang.Throwable buildReaderUnsupportedForFileFormatError (java.lang.String format)  { throw new RuntimeException(); }
  static public  java.lang.Throwable jobAbortedError (java.lang.Throwable cause)  { throw new RuntimeException(); }
  static public  java.lang.Throwable taskFailedWhileWritingRowsError (java.lang.Throwable cause)  { throw new RuntimeException(); }
  static public  java.lang.Throwable readCurrentFileNotFoundError (java.io.FileNotFoundException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedSaveModeError (java.lang.String saveMode, boolean pathExists)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotClearOutputDirectoryError (org.apache.hadoop.fs.Path staticPrefixPath)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotClearPartitionDirectoryError (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedToCastValueToDataTypeForPartitionColumnError (java.lang.String value, org.apache.spark.sql.types.DataType dataType, java.lang.String columnName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable endOfStreamError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable writeUnsupportedForBinaryFileDataSourceError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable fileLengthExceedsMaxLengthError (org.apache.hadoop.fs.FileStatus status, int maxLength)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedFieldNameError (java.lang.String fieldName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotSpecifyBothJdbcTableNameAndQueryError (java.lang.String jdbcTableName, java.lang.String jdbcQueryString)  { throw new RuntimeException(); }
  static public  java.lang.Throwable missingJdbcTableNameAndQueryError (java.lang.String jdbcTableName, java.lang.String jdbcQueryString)  { throw new RuntimeException(); }
  static public  java.lang.Throwable emptyOptionError (java.lang.String optionName)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidJdbcTxnIsolationLevelError (java.lang.String jdbcTxnIsolationLevel, java.lang.String value)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotGetJdbcTypeError (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unrecognizedSqlTypeError (int sqlType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedJdbcTypeError (java.lang.String content)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedArrayElementTypeBasedOnBinaryError (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  static public  java.lang.Throwable nestedArraysUnsupportedError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotTranslateNonNullValueForFieldError (int pos)  { throw new RuntimeException(); }
  static public  java.lang.Throwable invalidJdbcNumPartitionsError (int n, java.lang.String jdbcNumPartitions)  { throw new RuntimeException(); }
  static public  java.lang.Throwable transactionUnsupportedByJdbcServerError ()  { throw new RuntimeException(); }
  static public  java.lang.Throwable dataTypeUnsupportedYetError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable unsupportedOperationForDataTypeError (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  java.lang.Throwable inputFilterNotFullyConvertibleError (java.lang.String owner)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotReadFooterForFileError (org.apache.hadoop.fs.Path file, java.io.IOException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable cannotReadFooterForFileError (org.apache.hadoop.fs.FileStatus file, java.lang.RuntimeException e)  { throw new RuntimeException(); }
  static public  java.lang.Throwable foundDuplicateFieldInCaseInsensitiveModeError (java.lang.String requiredFieldName, java.lang.String matchedOrcFields)  { throw new RuntimeException(); }
  static public  java.lang.Throwable failedToMergeIncompatibleSchemasError (org.apache.spark.sql.types.StructType left, org.apache.spark.sql.types.StructType right, java.lang.Throwable e)  { throw new RuntimeException(); }
}
