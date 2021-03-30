package org.apache.spark.sql.catalyst.expressions;
/**
 * A codegen object generator which creates objects with codegen path first. Once any compile
 * error happens, it can fallback to interpreted implementation. In tests, we can use a SQL config
 * <code>SQLConf.CODEGEN_FACTORY_MODE</code> to control fallback behavior.
 */
public abstract class CodeGeneratorWithInterpretedFallback<IN extends java.lang.Object, OUT extends java.lang.Object> implements org.apache.spark.internal.Logging {
  public   CodeGeneratorWithInterpretedFallback ()  { throw new RuntimeException(); }
  protected abstract  OUT createCodeGeneratedObject (IN in)  ;
  protected abstract  OUT createInterpretedObject (IN in)  ;
  public  OUT createObject (IN in)  { throw new RuntimeException(); }
}
