package org.apache.spark.sql.catalyst;
/**
 * A helper trait to create {@link org.apache.spark.sql.catalyst.encoders.ExpressionEncoder}s
 * for classes whose fields are entirely defined by constructor params but should not be
 * case classes.
 */
public  interface DefinedByConstructorParams {
}
