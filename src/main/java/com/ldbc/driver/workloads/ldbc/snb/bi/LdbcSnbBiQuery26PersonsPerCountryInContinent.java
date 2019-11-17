package com.ldbc.driver.workloads.ldbc.snb.bi;

import com.google.common.collect.ImmutableMap;
import com.ldbc.driver.Operation;
import com.ldbc.driver.SerializingMarshallingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LdbcSnbBiQuery26PersonsPerCountryInContinent extends Operation<List<LdbcSnbBiQuery26PersonsPerCountryInContinentResult>>
{
    public static final int TYPE = 26;
    public static final String CONTINENT_NAME = "continentName";

    private final String continentName;

    public LdbcSnbBiQuery26PersonsPerCountryInContinent(String continentName)
    {
        this.continentName = continentName;
    }

    public String continentName()
    {
        return continentName;
    }

    @Override
    public Map<String, Object> parameterMap() {
        return ImmutableMap.<String, Object>builder()
                .put(CONTINENT_NAME, continentName)
                .build();
    }

    @Override
    public String toString() {
        return "LdbcSnbBiQuery26PersonsPerCountryInContinent{" +
                "continentName=" + continentName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LdbcSnbBiQuery26PersonsPerCountryInContinent that = (LdbcSnbBiQuery26PersonsPerCountryInContinent) o;
        return Objects.equals(continentName, that.continentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(continentName);
    }

    @Override
    public List<LdbcSnbBiQuery26PersonsPerCountryInContinentResult> marshalResult( String serializedResults ) throws
            SerializingMarshallingException
    {
        List<List<Object>> resultsAsList = SerializationUtil.marshalListOfLists( serializedResults );
        List<LdbcSnbBiQuery26PersonsPerCountryInContinentResult> result = new ArrayList<>();
        for ( int i = 0; i < resultsAsList.size(); i++ )
        {
            List<Object> row = resultsAsList.get( i );
            String countryName = (String) row.get( 0 );
            int personCount = (int) row.get( 1 );
            result.add(
                    new LdbcSnbBiQuery26PersonsPerCountryInContinentResult( countryName, personCount )
            );
        }
        return result;
    }

    @Override
    public String serializeResult( Object resultsObject ) throws SerializingMarshallingException
    {
        List<LdbcSnbBiQuery26PersonsPerCountryInContinentResult> result =
                (List<LdbcSnbBiQuery26PersonsPerCountryInContinentResult>) resultsObject;
        List<List<Object>> resultsFields = new ArrayList<>();
        for ( int i = 0; i < result.size(); i++ )
        {
            LdbcSnbBiQuery26PersonsPerCountryInContinentResult row = result.get( i );
            List<Object> resultFields = new ArrayList<>();
            resultFields.add( row.countryName() );
            resultFields.add( row.personCount() );
            resultsFields.add( resultFields );
        }
        return SerializationUtil.toJson( resultsFields );
    }

    @Override
    public int type()
    {
        return TYPE;
    }
}
