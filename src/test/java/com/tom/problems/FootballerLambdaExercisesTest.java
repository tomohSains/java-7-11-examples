package com.tom.problems;

import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class LambdasTest {

    private final Lambdas lambdas = new Lambdas();

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichMatchesGeorgeWeah() {
        final Predicate<Footballer> predicate = lambdas.getCheckForIsCAForUEFAWithOver50Goals();
        assertNotNull(predicate);

        final Footballer georgeWeah = Footballer.builder().setName("George Weah").setGoals(10001).setCountry(Country.LIBERIA).build();

        boolean result = predicate.test(georgeWeah);
        assertTrue(result);
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichDoesNOTMatchPatrickViera() {
        final Predicate<Footballer> predicate = lambdas.getCheckForIsCAForUEFAWithOver50Goals();
        assertNotNull(predicate);

        final Footballer patrickViera = Footballer.builder().setName("Patrick Viera").setGoals(10).setCountry(Country.FRANCE).build();

        boolean result = predicate.test(patrickViera);
        assertFalse(result);
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichMatchesJurgenKlinsmann() {
        final Predicate<Footballer> predicate = lambdas.getCheckForIsCAForUEFAWithOver50Goals();

        assertNotNull(predicate);

        final Footballer jurgenKlinsmann = Footballer.builder().setName("Jurgen Klinsmann").setGoals(1000).setCountry(Country.GERMANY).build();

        boolean result = predicate.test(jurgenKlinsmann);
        assertTrue(result);
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichDoesNOTMatchPele() {
        final Predicate<Footballer> predicate = lambdas.getCheckForIsCAForUEFAWithOver50Goals();
        assertNotNull(predicate);

        final Footballer pele = Footballer.builder().setName("Pele").setGoals(1000).setCountry(Country.BRAZIL).build();

        boolean result = predicate.test(pele);
        assertFalse(result);
    }


}
