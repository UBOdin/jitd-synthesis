package org.apache.spark.sql.execution;
/**
 * Find the chained plans that support codegen, collapse them together as WholeStageCodegen.
 * <p>
 * The <code>codegenStageCounter</code> generates ID for codegen stages within a query plan.
 * It does not affect equality, nor does it participate in destructuring pattern matching
 * of WholeStageCodegenExec.
 * <p>
 * This ID is used to help differentiate between codegen stages. It is included as a part
 * of the explain output for physical plans, e.g.
 * <p>
 * == Physical Plan ==
 * *(5) SortMergeJoin [x#3L], [y#9L], Inner
 * :- *(2) Sort [x#3L ASC NULLS FIRST], false, 0
 * :  +- Exchange hashpartitioning(x#3L, 200)
 * :     +- *(1) Project [(id#0L % 2) AS x#3L]
 * :        +- *(1) Filter isnotnull((id#0L % 2))
 * :           +- *(1) Range (0, 5, step=1, splits=8)
 * +- *(4) Sort [y#9L ASC NULLS FIRST], false, 0
 *    +- Exchange hashpartitioning(y#9L, 200)
 *       +- *(3) Project [(id#6L % 2) AS y#9L]
 *          +- *(3) Filter isnotnull((id#6L % 2))
 *             +- *(3) Range (0, 5, step=1, splits=8)
 * <p>
 * where the ID makes it obvious that not all adjacent codegen'd plan operators are of the
 * same codegen stage.
 * <p>
 * The codegen stage ID is also optionally included in the name of the generated classes as
 * a suffix, so that it's easier to associate a generated class back to the physical operator.
 * This is controlled by SQLConf: spark.sql.codegen.useIdInClassName
 * <p>
 * The ID is also included in various log messages.
 * <p>
 * Within a query, a codegen stage in a plan starts counting from 1, in "insertion order".
 * WholeStageCodegenExec operators are inserted into a plan in depth-first post-order.
 * See CollapseCodegenStages.insertWholeStageCodegen for the definition of insertion order.
 * <p>
 * 0 is reserved as a special ID value to indicate a temporary WholeStageCodegenExec object
 * is created, e.g. for special fallback handling when an existing WholeStageCodegenExec
 * failed to generate/compile code.
 */
public  class CollapseCodegenStages extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.util.concurrent.atomic.AtomicInteger codegenStageCounter ()  { throw new RuntimeException(); }
  // not preceding
  public   CollapseCodegenStages (java.util.concurrent.atomic.AtomicInteger codegenStageCounter)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
