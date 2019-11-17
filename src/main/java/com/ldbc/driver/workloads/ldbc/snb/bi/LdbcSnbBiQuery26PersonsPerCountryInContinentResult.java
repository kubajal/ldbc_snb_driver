package com.ldbc.driver.workloads.ldbc.snb.bi;

import java.util.List;
import java.util.Objects;

public class LdbcSnbBiQuery26PersonsPerCountryInContinentResult
{
    private final String countryName;
    private final int personCount;

    public LdbcSnbBiQuery26PersonsPerCountryInContinentResult(String countryName, int personCount)
    {
        this.countryName = countryName;
        this.personCount = personCount;
    }

    public String countryName() {
        return countryName;
    }

    public int personCount() {
        return personCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LdbcSnbBiQuery26PersonsPerCountryInContinentResult that = (LdbcSnbBiQuery26PersonsPerCountryInContinentResult) o;
        return personCount == that.personCount &&
                Objects.equals(countryName, that.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, personCount);
    }
}
