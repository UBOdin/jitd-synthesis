package org.apache.spark.sql.catalyst.expressions.codegen;
public  class EmptyBlock {
  static public  scala.Option<java.lang.Object> _marginChar ()  { throw new RuntimeException(); }
  static public  java.lang.String code ()  { throw new RuntimeException(); }
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.Block> children ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.Origin origin ()  { throw new RuntimeException(); }
  static public  void copyTagsFrom (BaseType other)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> void setTagValue (org.apache.spark.sql.catalyst.trees.TreeNodeTag<T> tag, T value)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> scala.Option<T> getTagValue (org.apache.spark.sql.catalyst.trees.TreeNodeTag<T> tag)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object> void unsetTagValue (org.apache.spark.sql.catalyst.trees.TreeNodeTag<T> tag)  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.trees.TreeNode<?>> containsChild ()  { throw new RuntimeException(); }
  static public  int hashCode ()  { throw new RuntimeException(); }
  static public  boolean fastEquals (org.apache.spark.sql.catalyst.trees.TreeNode<?> other)  { throw new RuntimeException(); }
  static public  scala.Option<BaseType> find (scala.Function1<BaseType, java.lang.Object> f)  { throw new RuntimeException(); }
  static public  void foreach (scala.Function1<BaseType, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  static public  void foreachUp (scala.Function1<BaseType, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> scala.collection.Seq<A> map (scala.Function1<BaseType, A> f)  { throw new RuntimeException(); }
  static public <A extends java.lang.Object> scala.collection.Seq<A> flatMap (scala.Function1<BaseType, scala.collection.TraversableOnce<A>> f)  { throw new RuntimeException(); }
  static public <B extends java.lang.Object> scala.collection.Seq<B> collect (scala.PartialFunction<BaseType, B> pf)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<BaseType> collectLeaves ()  { throw new RuntimeException(); }
  static public <B extends java.lang.Object> scala.Option<B> collectFirst (scala.PartialFunction<BaseType, B> pf)  { throw new RuntimeException(); }
  static protected <B extends java.lang.Object> java.lang.Object mapProductIterator (scala.Function1<java.lang.Object, B> f, scala.reflect.ClassTag<B> evidence$1)  { throw new RuntimeException(); }
  static public  BaseType withNewChildren (scala.collection.Seq<BaseType> newChildren)  { throw new RuntimeException(); }
  static public  BaseType transform (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  static public  BaseType transformDown (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  static public  BaseType transformUp (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  static public  BaseType mapChildren (scala.Function1<BaseType, BaseType> f)  { throw new RuntimeException(); }
  static protected  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  static public  BaseType makeCopy (java.lang.Object[] newArgs)  { throw new RuntimeException(); }
  static public  BaseType clone ()  { throw new RuntimeException(); }
  static public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  static protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  static public  java.lang.String argString (int maxFields)  { throw new RuntimeException(); }
  static public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  static public  java.lang.String verboseStringWithSuffix (int maxFields)  { throw new RuntimeException(); }
  static public final  java.lang.String treeString ()  { throw new RuntimeException(); }
  static public final  java.lang.String treeString (boolean verbose, boolean addSuffix, int maxFields, boolean printOperatorId)  { throw new RuntimeException(); }
  static public final  boolean treeString$default$2 ()  { throw new RuntimeException(); }
  static public final  int treeString$default$3 ()  { throw new RuntimeException(); }
  static public final  boolean treeString$default$4 ()  { throw new RuntimeException(); }
  static public  void treeString (scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, boolean addSuffix, int maxFields, boolean printOperatorId)  { throw new RuntimeException(); }
  static public  java.lang.String numberedTreeString ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.TreeNode<?> apply (int number)  { throw new RuntimeException(); }
  static public  BaseType p (int number)  { throw new RuntimeException(); }
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.trees.TreeNode<?>> innerChildren ()  { throw new RuntimeException(); }
  static public  void generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, java.lang.String prefix, boolean addSuffix, int maxFields, boolean printNodeId, int indent)  { throw new RuntimeException(); }
  static public  java.lang.String generateTreeString$default$5 ()  { throw new RuntimeException(); }
  static public  boolean generateTreeString$default$6 ()  { throw new RuntimeException(); }
  static public  int generateTreeString$default$9 ()  { throw new RuntimeException(); }
  static public  java.lang.String asCode ()  { throw new RuntimeException(); }
  static public  java.lang.String toJSON ()  { throw new RuntimeException(); }
  static public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  static protected  scala.collection.immutable.List<scala.Tuple2<java.lang.String, org.json4s.JsonAST.JValue>> jsonFields ()  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  static public  int length ()  { throw new RuntimeException(); }
  static public  boolean isEmpty ()  { throw new RuntimeException(); }
  static public  boolean nonEmpty ()  { throw new RuntimeException(); }
  static public  void _marginChar_$eq (scala.Option<java.lang.Object> x$1)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.Block stripMargin (char c)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.Block stripMargin ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.Block transformExprValues (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.codegen.ExprValue, org.apache.spark.sql.catalyst.expressions.codegen.ExprValue> f)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.codegen.Block $plus (org.apache.spark.sql.catalyst.expressions.codegen.Block other)  { throw new RuntimeException(); }
  static public  java.lang.String verboseString (int maxFields)  { throw new RuntimeException(); }
  static public  java.lang.String simpleStringWithNodeId ()  { throw new RuntimeException(); }
}
