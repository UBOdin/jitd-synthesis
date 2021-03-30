package org.apache.spark.sql.catalyst.expressions.codegen;
public  class CodeGenerator$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CodeGenerator$ MODULE$ = null;
  public   CodeGenerator$ ()  { throw new RuntimeException(); }
  public final  int DEFAULT_JVM_HUGE_METHOD_LIMIT ()  { throw new RuntimeException(); }
  public final  int MAX_JVM_METHOD_PARAMS_LENGTH ()  { throw new RuntimeException(); }
  public final  int MAX_JVM_CONSTANT_POOL_SIZE ()  { throw new RuntimeException(); }
  public final  int MERGE_SPLIT_METHODS_THRESHOLD ()  { throw new RuntimeException(); }
  public final  int GENERATED_CLASS_SIZE_THRESHOLD ()  { throw new RuntimeException(); }
  public final  int OUTER_CLASS_VARIABLES_THRESHOLD ()  { throw new RuntimeException(); }
  public final  int MUTABLESTATEARRAY_SIZE_LIMIT ()  { throw new RuntimeException(); }
  public  long compileTime ()  { throw new RuntimeException(); }
  public  void resetCompileTime ()  { throw new RuntimeException(); }
  /**
   * Compile the Java source code into a Java class, using Janino.
   * <p>
   * @return a pair of a generated class and the bytecode statistics of generated functions.
   * @param code (undocumented)
   */
  public  scala.Tuple2<org.apache.spark.sql.catalyst.expressions.codegen.GeneratedClass, org.apache.spark.sql.catalyst.expressions.codegen.ByteCodeStats> compile (org.apache.spark.sql.catalyst.expressions.codegen.CodeAndComment code)  { throw new RuntimeException(); }
  /**
   * Name of Java primitive data type
   * @return (undocumented)
   */
  public final  java.lang.String JAVA_BOOLEAN ()  { throw new RuntimeException(); }
  public final  java.lang.String JAVA_BYTE ()  { throw new RuntimeException(); }
  public final  java.lang.String JAVA_SHORT ()  { throw new RuntimeException(); }
  public final  java.lang.String JAVA_INT ()  { throw new RuntimeException(); }
  public final  java.lang.String JAVA_LONG ()  { throw new RuntimeException(); }
  public final  java.lang.String JAVA_FLOAT ()  { throw new RuntimeException(); }
  public final  java.lang.String JAVA_DOUBLE ()  { throw new RuntimeException(); }
  /**
   * List of java primitive data types
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> primitiveTypes ()  { throw new RuntimeException(); }
  /**
   * Returns true if a Java type is Java primitive primitive type
   * @param jt (undocumented)
   * @return (undocumented)
   */
  public  boolean isPrimitiveType (java.lang.String jt)  { throw new RuntimeException(); }
  public  boolean isPrimitiveType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns the specialized code to access a value from <code>inputRow</code> at <code>ordinal</code>.
   * @param input (undocumented)
   * @param dataType (undocumented)
   * @param ordinal (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getValue (java.lang.String input, org.apache.spark.sql.types.DataType dataType, java.lang.String ordinal)  { throw new RuntimeException(); }
  /**
   * Generates code creating a {@link UnsafeArrayData} or
   * {@link org.apache.spark.sql.catalyst.util.GenericArrayData} based on given parameters.
   * <p>
   * @param arrayName name of the array to create
   * @param elementType data type of the elements in source array
   * @param numElements code representing the number of elements the array should contain
   * @param additionalErrorMessage string to include in the error message
   * <p>
   * @return code representing the allocation of {@link ArrayData}
   */
  public  java.lang.String createArrayData (java.lang.String arrayName, org.apache.spark.sql.types.DataType elementType, java.lang.String numElements, java.lang.String additionalErrorMessage)  { throw new RuntimeException(); }
  /**
   * Generates assignment code for an {@link ArrayData}
   * <p>
   * @param dstArray name of the array to be assigned
   * @param elementType data type of the elements in destination and source arrays
   * @param srcArray name of the array to be read
   * @param needNullCheck value which shows whether a nullcheck is required for the returning
   *                      assignment
   * @param dstArrayIndex an index variable to access each element of destination array
   * @param srcArrayIndex an index variable to access each element of source array
   * <p>
   * @return code representing an assignment to each element of the {@link ArrayData}, which requires
   *         a pair of destination and source loop index variables
   */
  public  java.lang.String createArrayAssignment (java.lang.String dstArray, org.apache.spark.sql.types.DataType elementType, java.lang.String srcArray, java.lang.String dstArrayIndex, java.lang.String srcArrayIndex, boolean needNullCheck)  { throw new RuntimeException(); }
  /**
   * Returns the code to update a column in Row for a given DataType.
   * @param row (undocumented)
   * @param dataType (undocumented)
   * @param ordinal (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String setColumn (java.lang.String row, org.apache.spark.sql.types.DataType dataType, int ordinal, java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Update a column in MutableRow from ExprCode.
   * <p>
   * @param isVectorized True if the underlying row is of type <code>ColumnarBatch.Row</code>, false otherwise
   * @param row (undocumented)
   * @param dataType (undocumented)
   * @param ordinal (undocumented)
   * @param ev (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String updateColumn (java.lang.String row, org.apache.spark.sql.types.DataType dataType, int ordinal, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, boolean nullable, boolean isVectorized)  { throw new RuntimeException(); }
  /**
   * Returns the specialized code to set a given value in a column vector for a given <code>DataType</code>.
   * @param vector (undocumented)
   * @param rowId (undocumented)
   * @param dataType (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String setValue (java.lang.String vector, java.lang.String rowId, org.apache.spark.sql.types.DataType dataType, java.lang.String value)  { throw new RuntimeException(); }
  /**
   * Generates code of setter for an {@link ArrayData}.
   * @param array (undocumented)
   * @param elementType (undocumented)
   * @param i (undocumented)
   * @param value (undocumented)
   * @param isNull (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String setArrayElement (java.lang.String array, org.apache.spark.sql.types.DataType elementType, java.lang.String i, java.lang.String value, scala.Option<java.lang.String> isNull)  { throw new RuntimeException(); }
  /**
   * Returns the specialized code to set a given value in a column vector for a given <code>DataType</code>
   * that could potentially be nullable.
   * @param vector (undocumented)
   * @param rowId (undocumented)
   * @param dataType (undocumented)
   * @param ev (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String updateColumn (java.lang.String vector, java.lang.String rowId, org.apache.spark.sql.types.DataType dataType, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev, boolean nullable)  { throw new RuntimeException(); }
  /**
   * Returns the specialized code to access a value from a column vector for a given <code>DataType</code>.
   * @param vector (undocumented)
   * @param dataType (undocumented)
   * @param rowId (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getValueFromVector (java.lang.String vector, org.apache.spark.sql.types.DataType dataType, java.lang.String rowId)  { throw new RuntimeException(); }
  /**
   * This methods returns two values in a Tuple.
   * <p>
   * First value: Extracts all the input variables from references and subexpression
   * elimination states for a given <code>expr</code>. This result will be used to split the
   * generated code of expressions into multiple functions.
   * <p>
   * Second value: Returns the set of <code>ExprCodes</code>s which are necessary codes before
   * evaluating subexpressions.
   * @param ctx (undocumented)
   * @param expr (undocumented)
   * @param subExprs (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.codegen.VariableValue>, scala.collection.immutable.Set<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode>> getLocalInputVariableValues (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.Expression expr, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.codegen.SubExprEliminationState> subExprs)  { throw new RuntimeException(); }
  /**
   * Returns the name used in accessor and setter for a Java primitive type.
   * @param jt (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String primitiveTypeName (java.lang.String jt)  { throw new RuntimeException(); }
  public  java.lang.String primitiveTypeName (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns the Java type for a DataType.
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String javaType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  java.lang.Class<?> javaClass (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  /**
   * Returns the boxed type in Java.
   * @param jt (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String boxedType (java.lang.String jt)  { throw new RuntimeException(); }
  public  java.lang.String boxedType (org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public  java.lang.String typeName (java.lang.Class<?> clazz)  { throw new RuntimeException(); }
  /**
   * Returns the representation of default value for a given Java Type.
   * @param jt the string name of the Java type
   * @param typedNull if true, for null literals, return a typed (with a cast) version
   * @return (undocumented)
   */
  public  java.lang.String defaultValue (java.lang.String jt, boolean typedNull)  { throw new RuntimeException(); }
  public  java.lang.String defaultValue (org.apache.spark.sql.types.DataType dt, boolean typedNull)  { throw new RuntimeException(); }
  /**
   * Returns the length of parameters for a Java method descriptor. <code>this</code> contributes one unit
   * and a parameter of type long or double contributes two units. Besides, for nullable parameter,
   * we also need to pass a boolean parameter for the null status.
   * @param params (undocumented)
   * @return (undocumented)
   */
  public  int calculateParamLength (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> params)  { throw new RuntimeException(); }
  public  int calculateParamLengthFromExprValues (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprValue> params)  { throw new RuntimeException(); }
  /**
   * In Java, a method descriptor is valid only if it represents method parameters with a total
   * length less than a pre-defined constant.
   * @param paramLength (undocumented)
   * @return (undocumented)
   */
  public  boolean isValidParamLength (int paramLength)  { throw new RuntimeException(); }
}
