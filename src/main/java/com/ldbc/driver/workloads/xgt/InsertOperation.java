package com.ldbc.driver.workloads.xgt;

public class InsertOperation extends Operation<Object>
{
    private final String table;
    private final String key;
    private final Map<String, ByteIterator> values;
    public UpdateOperation(String table, String key, Map<String, ByteIterator> values) {
        this.table = table;
        this.key = key;
        this.values = values;
    }
    public String getTable() {
        return table;
    }
    public String getKey() {
        return key;
    }
    public Map<String, ByteIterator> getValues() {
        return values;
    }
}
