package org.apache.spark.sql.catalyst.expressions;
/**
 * A mixin for the analyzer to perform implicit type casting using
 * {@link org.apache.spark.sql.catalyst.analysis.TypeCoercion.ImplicitTypeCasts}.
 */
public  interface ImplicitCastInputTypes extends org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes {
}
