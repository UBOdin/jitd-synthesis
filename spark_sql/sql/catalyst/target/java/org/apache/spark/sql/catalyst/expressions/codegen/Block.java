package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A trait representing a block of java code.
 */
public  interface Block extends org.apache.spark.sql.catalyst.expressions.codegen.JavaCode {
  /**
   * A custom string interpolator which inlines a string into code block.
   */
  static public  class InlineHelper extends scala.AnyVal {
    public  scala.StringContext sc ()  { throw new RuntimeException(); }
    // not preceding
    public   InlineHelper (scala.StringContext sc)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.codegen.Inline inline (scala.collection.Seq<java.lang.Object> args)  { throw new RuntimeException(); }
  }
  static public  class InlineHelper$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final InlineHelper$ MODULE$ = null;
    public   InlineHelper$ ()  { throw new RuntimeException(); }
  }
  static public  class BlockHelper extends scala.AnyVal {
    public  scala.StringContext sc ()  { throw new RuntimeException(); }
    // not preceding
    public   BlockHelper (scala.StringContext sc)  { throw new RuntimeException(); }
    /**
     * A string interpolator that retains references to the <code>JavaCode</code> inputs, and behaves like
     * the Scala builtin StringContext.s() interpolator otherwise, i.e. it will treat escapes in
     * the code parts, and will not treat escapes in the input arguments.
     * @param args (undocumented)
     * @return (undocumented)
     */
    public  org.apache.spark.sql.catalyst.expressions.codegen.Block code (scala.collection.Seq<java.lang.Object> args)  { throw new RuntimeException(); }
  }
  static public  class BlockHelper$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BlockHelper$ MODULE$ = null;
    public   BlockHelper$ ()  { throw new RuntimeException(); }
  }
  public  java.lang.String toString ()  ;
  public  int length ()  ;
  public  boolean isEmpty ()  ;
  public  boolean nonEmpty ()  ;
  public  scala.Option<java.lang.Object> _marginChar ()  ;
  public  org.apache.spark.sql.catalyst.expressions.codegen.Block stripMargin (char c)  ;
  public  org.apache.spark.sql.catalyst.expressions.codegen.Block stripMargin ()  ;
  /**
   * Apply a map function to each java expression codes present in this java code, and return a new
   * java code based on the mapped java expression codes.
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.Block transformExprValues (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.codegen.ExprValue, org.apache.spark.sql.catalyst.expressions.codegen.ExprValue> f)  ;
  public  java.lang.String verboseString (int maxFields)  ;
  public  java.lang.String simpleStringWithNodeId ()  ;
}
