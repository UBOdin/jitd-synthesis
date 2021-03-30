package org.apache.spark.sql.catalyst.trees;
public abstract class TreeNode<BaseType extends org.apache.spark.sql.catalyst.trees.TreeNode<BaseType>> implements scala.Product {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree().setOriginal(AppliedTypeTree(Ident(org.apache.spark.sql.catalyst.trees.TreeNode), List(TypeTree().setOriginal(Ident(TypeName("BaseType"))))))))
  public   TreeNode ()  { throw new RuntimeException(); }
  /**
   * Returns the tree node at the specified number, used primarily for interactive debugging.
   * Numbers for each node can be found in the {@link numberedTreeString}.
   * <p>
   * Note that this cannot return BaseType because logical plan's plan node might return
   * physical plan for innerChildren, e.g. in-memory relation logical plan node has a reference
   * to the physical plan node it is referencing.
   * @param number (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.trees.TreeNode<?> apply (int number)  { throw new RuntimeException(); }
  /** Returns a string representing the arguments to this node, minus any children */
  public  java.lang.String argString (int maxFields)  { throw new RuntimeException(); }
  /**
   * Returns a 'scala code' representation of this <code>TreeNode</code> and its children.  Intended for use
   * when debugging where the prettier toString function is obfuscating the actual structure. In the
   * case of 'pure' <code>TreeNodes</code> that only contain primitives and other TreeNodes, the result can be
   * pasted in the REPL to build an equivalent Tree.
   * @return (undocumented)
   */
  public  java.lang.String asCode ()  { throw new RuntimeException(); }
  /**
   * Returns a Seq of the children of this node.
   * Children should not change. Immutability required for containsChild optimization
   * @return (undocumented)
   */
  public abstract  scala.collection.Seq<BaseType> children ()  ;
  public  BaseType clone ()  { throw new RuntimeException(); }
  /**
   * Returns a Seq containing the result of applying a partial function to all elements in this
   * tree on which the function is defined.
   * @param pf (undocumented)
   * @return (undocumented)
   */
  public <B extends java.lang.Object> scala.collection.Seq<B> collect (scala.PartialFunction<BaseType, B> pf)  { throw new RuntimeException(); }
  /**
   * Finds and returns the first {@link TreeNode} of the tree for which the given partial function
   * is defined (pre-order), and applies the partial function to it.
   * @param pf (undocumented)
   * @return (undocumented)
   */
  public <B extends java.lang.Object> scala.Option<B> collectFirst (scala.PartialFunction<BaseType, B> pf)  { throw new RuntimeException(); }
  /**
   * Returns a Seq containing the leaves in this tree.
   * @return (undocumented)
   */
  public  scala.collection.Seq<BaseType> collectLeaves ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Set<org.apache.spark.sql.catalyst.trees.TreeNode<?>> containsChild ()  { throw new RuntimeException(); }
  public  void copyTagsFrom (BaseType other)  { throw new RuntimeException(); }
  /**
   * Faster version of equality which short-circuits when two treeNodes are the same instance.
   * We don't just override Object.equals, as doing so prevents the scala compiler from
   * generating case class <code>equals</code> methods
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean fastEquals (org.apache.spark.sql.catalyst.trees.TreeNode<?> other)  { throw new RuntimeException(); }
  /**
   * Find the first {@link TreeNode} that satisfies the condition specified by <code>f</code>.
   * The condition is recursively applied to this node and all of its children (pre-order).
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<BaseType> find (scala.Function1<BaseType, java.lang.Object> f)  { throw new RuntimeException(); }
  /**
   * Returns a Seq by applying a function to all nodes in this tree and using the elements of the
   * resulting collections.
   * @param f (undocumented)
   * @return (undocumented)
   */
  public <A extends java.lang.Object> scala.collection.Seq<A> flatMap (scala.Function1<BaseType, scala.collection.TraversableOnce<A>> f)  { throw new RuntimeException(); }
  /**
   * Runs the given function on this node and then recursively on {@link children}.
   * @param f the function to be applied to each node in the tree.
   */
  public  void foreach (scala.Function1<BaseType, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * Runs the given function recursively on {@link children} then on this node.
   * @param f the function to be applied to each node in the tree.
   */
  public  void foreachUp (scala.Function1<BaseType, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * Appends the string representation of this node and its children to the given Writer.
   * <p>
   * The <code>i</code>-th element in <code>lastChildren</code> indicates whether the ancestor of the current node at
   * depth <code>i + 1</code> is the last child of its own parent node.  The depth of the root node is 0, and
   * <code>lastChildren</code> for the root node should be empty.
   * <p>
   * Note that this traversal (numbering) order must be the same as {@link getNodeNumbered}.
   * @param depth (undocumented)
   * @param lastChildren (undocumented)
   * @param append (undocumented)
   * @param verbose (undocumented)
   * @param prefix (undocumented)
   * @param addSuffix (undocumented)
   * @param maxFields (undocumented)
   * @param printNodeId (undocumented)
   * @param indent (undocumented)
   */
  public  void generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, java.lang.String prefix, boolean addSuffix, int maxFields, boolean printNodeId, int indent)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> scala.Option<T> getTagValue (org.apache.spark.sql.catalyst.trees.TreeNodeTag<T> tag)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  /**
   * All the nodes that should be shown as a inner nested tree of this node.
   * For example, this can be used to show sub-queries.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.trees.TreeNode<?>> innerChildren ()  { throw new RuntimeException(); }
  protected  scala.collection.immutable.List<scala.Tuple2<java.lang.String, org.json4s.JsonAST.JValue>> jsonFields ()  { throw new RuntimeException(); }
  /**
   * Creates a copy of this type of tree node after a transformation.
   * Must be overridden by child classes that have constructor arguments
   * that are not present in the productIterator.
   * @param newArgs the new product arguments.
   * @return (undocumented)
   */
  public  BaseType makeCopy (java.lang.Object[] newArgs)  { throw new RuntimeException(); }
  /**
   * Returns a Seq containing the result of applying the given function to each
   * node in this tree in a preorder traversal.
   * @param f the function to be applied.
   * @return (undocumented)
   */
  public <A extends java.lang.Object> scala.collection.Seq<A> map (scala.Function1<BaseType, A> f)  { throw new RuntimeException(); }
  /**
   * Returns a copy of this node where <code>f</code> has been applied to all the nodes in <code>children</code>.
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  BaseType mapChildren (scala.Function1<BaseType, BaseType> f)  { throw new RuntimeException(); }
  /**
   * Efficient alternative to <code>productIterator.map(f).toArray</code>.
   * @param f (undocumented)
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  protected <B extends java.lang.Object> java.lang.Object mapProductIterator (scala.Function1<java.lang.Object, B> f, scala.reflect.ClassTag<B> evidence$1)  { throw new RuntimeException(); }
  /**
   * Returns the name of this type of TreeNode.  Defaults to the class name.
   * Note that we remove the "Exec" suffix for physical operators here.
   * @return (undocumented)
   */
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  /**
   * Returns a string representation of the nodes in this tree, where each operator is numbered.
   * The numbers can be used with {@link TreeNode.apply} to easily access specific subtrees.
   * <p>
   * The numbers are based on depth-first traversal of the tree (with innerChildren traversed first
   * before children).
   * @return (undocumented)
   */
  public  java.lang.String numberedTreeString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.trees.Origin origin ()  { throw new RuntimeException(); }
  /**
   * Args to the constructor that should be copied, but not transformed.
   * These are appended to the transformed args automatically by makeCopy
   * @return
   */
  protected  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  /**
   * Returns the tree node at the specified number, used primarily for interactive debugging.
   * Numbers for each node can be found in the {@link numberedTreeString}.
   * <p>
   * This is a variant of {@link apply} that returns the node as BaseType (if the type matches).
   * @param number (undocumented)
   * @return (undocumented)
   */
  public  BaseType p (int number)  { throw new RuntimeException(); }
  public  java.lang.String prettyJson ()  { throw new RuntimeException(); }
  public <T extends java.lang.Object> void setTagValue (org.apache.spark.sql.catalyst.trees.TreeNodeTag<T> tag, T value)  { throw new RuntimeException(); }
  /**
   * ONE line description of this node.
   * @param maxFields Maximum number of fields that will be converted to strings.
   *                  Any elements beyond the limit will be dropped.
   * @return (undocumented)
   */
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  /**
   * ONE line description of this node containing the node identifier.
   * @return
   */
  public abstract  java.lang.String simpleStringWithNodeId ()  ;
  /**
   * The arguments that should be included in the arg string.  Defaults to the <code>productIterator</code>.
   * @return (undocumented)
   */
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  java.lang.String toJSON ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /**
   * Returns a copy of this node where <code>rule</code> has been recursively applied to the tree.
   * When <code>rule</code> does not apply to a given node it is left unchanged.
   * Users should not expect a specific directionality. If a specific directionality is needed,
   * transformDown or transformUp should be used.
   * <p>
   * @param rule the function use to transform this nodes children
   * @return (undocumented)
   */
  public  BaseType transform (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  /**
   * Returns a copy of this node where <code>rule</code> has been recursively applied to it and all of its
   * children (pre-order). When <code>rule</code> does not apply to a given node it is left unchanged.
   * <p>
   * @param rule the function used to transform this nodes children
   * @return (undocumented)
   */
  public  BaseType transformDown (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  /**
   * Returns a copy of this node where <code>rule</code> has been recursively applied first to all of its
   * children and then itself (post-order). When <code>rule</code> does not apply to a given node, it is left
   * unchanged.
   * <p>
   * @param rule the function use to transform this nodes children
   * @return (undocumented)
   */
  public  BaseType transformUp (scala.PartialFunction<BaseType, BaseType> rule)  { throw new RuntimeException(); }
  /** Returns a string representation of the nodes in this tree */
  public final  java.lang.String treeString ()  { throw new RuntimeException(); }
  public final  java.lang.String treeString (boolean verbose, boolean addSuffix, int maxFields, boolean printOperatorId)  { throw new RuntimeException(); }
  public  void treeString (scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, boolean addSuffix, int maxFields, boolean printOperatorId)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> void unsetTagValue (org.apache.spark.sql.catalyst.trees.TreeNodeTag<T> tag)  { throw new RuntimeException(); }
  /** ONE line description of this node with more information */
  public abstract  java.lang.String verboseString (int maxFields)  ;
  /** ONE line description of this node with some suffix information */
  public  java.lang.String verboseStringWithSuffix (int maxFields)  { throw new RuntimeException(); }
  /**
   * Returns a copy of this node with the children replaced.
   * TODO: Validate somewhere (in debug mode?) that children are ordered correctly.
   * @param newChildren (undocumented)
   * @return (undocumented)
   */
  public  BaseType withNewChildren (scala.collection.Seq<BaseType> newChildren)  { throw new RuntimeException(); }
}
