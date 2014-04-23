package com.ldbc.driver.workloads.ldbc.socnet.interactive;

import com.ldbc.driver.Operation;

import java.util.List;

public class LdbcQuery8 extends Operation<List<LdbcQuery8Result>> {
    public static final int DEFAULT_LIMIT = 20;

    private final long personId;
    private final int limit;

    public LdbcQuery8(long personId, int limit) {
        super();
        this.personId = personId;
        this.limit = limit;
    }

    public long personId() {
        return personId;
    }

    public int limit() {
        return limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LdbcQuery8 that = (LdbcQuery8) o;

        if (limit != that.limit) return false;
        if (personId != that.personId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + limit;
        return result;
    }

    @Override
    public String toString() {
        return "LdbcQuery7{" +
                "personId=" + personId +
                ", limit=" + limit +
                '}';
    }
}
