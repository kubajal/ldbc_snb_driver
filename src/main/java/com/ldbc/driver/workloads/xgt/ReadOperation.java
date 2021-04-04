package com.ldbc.driver.workloads.xgt;

public class ReadOperation extends Operation<Integer> {
    private final String table;
    private final String key;
    private final List<String> fields;
    public ReadOperation(String table, String key, List<String> fields) {
        this.table = table;
        this.key = key;
        this.fields = fields;
    }
    public String getTable() {
        return table;
    }
    public String getKey() {
        return key;
    }
    public List<String> getFields() {
        return fields;
    }
}