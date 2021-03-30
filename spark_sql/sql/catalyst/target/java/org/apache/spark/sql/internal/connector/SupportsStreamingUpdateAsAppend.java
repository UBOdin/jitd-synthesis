package org.apache.spark.sql.internal.connector;
/**
 * An internal <code>WriteBuilder</code> mixin to support UPDATE streaming output mode. Now there's no good
 * way to pass the <code>keys</code> to upsert or replace (delete -> append), we do the same with append writes
 * and let end users to deal with.
 * <p>
 * This approach may be still valid for streaming writers which can't do the upsert or replace.
 * We can promote the API to the official API along with the new API for upsert/replace.
 */
public  interface SupportsStreamingUpdateAsAppend extends org.apache.spark.sql.connector.write.WriteBuilder {
}
