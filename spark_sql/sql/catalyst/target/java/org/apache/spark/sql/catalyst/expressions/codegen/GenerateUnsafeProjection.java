package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Generates a {@link Projection} that returns an {@link UnsafeRow}.
 * <p>
 * It generates the code for all the expressions, computes the total length for all the columns
 * (can be accessed via variables), and then copies the data into a scratch buffer space in the
 * form of UnsafeRow (the scratch buffer will grow as needed).
 * <p>
 * @note The returned UnsafeRow will be pointed to a scratch buffer inside the projection.
 */
public  class GenerateUnsafeProjection {
  static public  class Schema implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
    public  boolean nullable ()  { throw new RuntimeException(); }
    // not preceding
    public   Schema (org.apache.spark.sql.types.DataType dataType, boolean nullable)  { throw new RuntimeException(); }
  }
  static public  class Schema$ extends scala.runtime.AbstractFunction2<org.apache.spark.sql.types.DataType, java.lang.Object, org.apache.spark.sql.catalyst.expressions.codegen.GenerateUnsafeProjection.Schema> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Schema$ MODULE$ = null;
    public   Schema$ ()  { throw new RuntimeException(); }
  }
  /** Returns true iff we support this data type. */
  static public  boolean canSupport (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode createCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, boolean useSubexprElimination)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> canonicalize (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> bind (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> in, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.UnsafeProjection generate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions, boolean subexpressionEliminationEnabled)  { throw new RuntimeException(); }
  static protected  org.apache.spark.sql.catalyst.expressions.UnsafeProjection create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> references)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  java.lang.String genericMutableRowType ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext newCodeGenContext ()  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
