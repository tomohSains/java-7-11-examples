package com.tom.problems;

import java.util.Set;

public class FootballerUtils {

    private static final Set<Country> UEFA_COUNTRIES = Set.of(Country.FRANCE, Country.GERMANY, Country.ENGLAND, Country.HOLLAND);
    private static final Set<Country> CAF_COUNTRIES = Set.of(Country.CAMEROON, Country.ALGERIA, Country.LIBERIA);

    /**
     * Check whether a footballer is from the Union of European Football Associations
     * @param footballer the footballer to check
     * @return true if a footballer is from UEFA
     */
    public static boolean isFromUEFA(final Footballer footballer) {
        return UEFA_COUNTRIES.contains(footballer.getCountry());
    }

    /**
     * Check whether a footballer is from the Confederation of African Football
     * @param footballer the footballer to check
     * @return true if a footballer is from CAF
     */
    public static boolean isFromCAF(final Footballer footballer) {
        return CAF_COUNTRIES.contains(footballer.getCountry());
    }
}
