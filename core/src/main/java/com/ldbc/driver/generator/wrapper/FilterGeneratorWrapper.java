package com.ldbc.driver.generator.wrapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Predicate;
import com.ldbc.driver.generator.Generator;
import com.ldbc.driver.generator.GeneratorException;

public class FilterGeneratorWrapper<GENERATE_TYPE> extends Generator<GENERATE_TYPE>
{
    private final Generator<GENERATE_TYPE> generator;
    private final Predicate<GENERATE_TYPE> filter;

    public static <T1> Generator<T1> includeOnly( Generator<T1> generator, T1... includedItems )
    {
        return new FilterGeneratorWrapper<T1>( generator, new IncludeOnlyPredicate<T1>( includedItems ) );
    }

    public static <T1> Generator<T1> excludeAll( Generator<T1> generator, T1... excludedItems )
    {
        return new FilterGeneratorWrapper<T1>( generator, new ExcludeAllPredicate<T1>( excludedItems ) );
    }

    public FilterGeneratorWrapper( Generator<GENERATE_TYPE> generator, Predicate<GENERATE_TYPE> filter )
    {
        this.generator = generator;
        this.filter = filter;
    }

    @Override
    protected GENERATE_TYPE doNext() throws GeneratorException
    {
        while ( generator.hasNext() )
        {
            GENERATE_TYPE next = generator.next();
            if ( filter.apply( next ) ) return next;
        }
        return null;
    }

    private static class IncludeOnlyPredicate<T1> implements Predicate<T1>
    {
        private final Set<T1> includedItems;

        private IncludeOnlyPredicate( T1... includedItems )
        {
            this.includedItems = new HashSet<T1>( Arrays.asList( includedItems ) );
        }

        @Override
        public boolean apply( T1 input )
        {
            return true == includedItems.contains( input );
        }
    }

    private static class ExcludeAllPredicate<T1> implements Predicate<T1>
    {
        private final Set<T1> excludedItems;

        private ExcludeAllPredicate( T1... excludedItems )
        {
            this.excludedItems = new HashSet<T1>( Arrays.asList( excludedItems ) );
        }

        @Override
        public boolean apply( T1 input )
        {
            return false == excludedItems.contains( input );
        }
    }
}
