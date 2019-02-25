package com.tom.problems;

import com.tom.domain.Country;
import com.tom.domain.Footballer;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FootballerStreamsExercisesTest {

    private FootballerStreamsExercises cut = new FootballerStreamsExercises();

    @Test
    public void whenCall_findTheNamesOfFootballersWithMoreThan5RedCards_withNoFootballers_thenReturnEmpty() {
        final List<String> result = cut.findTheNamesOfFootballersWithMoreThan5RedCards(Collections.emptyList());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCall_findTheNamesOfFootballersWithMoreThan5RedCards_withNoFootballersWithMoreThan5RedCards_thenReturnEmpty() {
        final List<Footballer> footballers = List.of(
                    Footballer.builder().setName("Maradona").setRedCards(5).build(),
                    Footballer.builder().setName("Paul Scholes").setRedCards(4).build(),
                    Footballer.builder().setName("Ruud Gullit").setRedCards(2).build()
                );

        final List<String> result = cut.findTheNamesOfFootballersWithMoreThan5RedCards(footballers);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCall_findTheNamesOfFootballersWithMoreThan5RedCards_withThreeFootballersWithMoreThan5RedCards_thenReturnThreeFootballers() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Maradona").setRedCards(6).build(),
                Footballer.builder().setName("Darren Anderton").setRedCards(3).build(),
                Footballer.builder().setName("Paul Scholes").setRedCards(6).build(),
                Footballer.builder().setName("Robbie Earle").setRedCards(5).build(),
                Footballer.builder().setName("Gary Neville").setRedCards(4).build(),
                Footballer.builder().setName("Ruud Gullit").setRedCards(7).build()
        );

        final List<String> result = cut.findTheNamesOfFootballersWithMoreThan5RedCards(footballers);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.contains("Maradona"));
        assertTrue(result.contains("Ruud Gullit"));
        assertTrue(result.contains("Paul Scholes"));
    }


    @Test
    public void whenCall_findTheNamesOfTheTwoTopScoringFootballers_withNoFootballers_thenReturnEmpty() {
        final List<String> result = cut.findTheNamesOfTheTwoTopScoringFootballers(Collections.emptyList());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCall_findTheNamesOfTheTwoTopScoringFootballers_withOneFootballer_thenReturnOneFootballer() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Michael Owen").setGoals(10).build()
        );

        final List<String> result = cut.findTheNamesOfTheTwoTopScoringFootballers(footballers);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains("Michael Owen"));
    }

    @Test
    public void whenCall_findTheNamesOfTheTwoTopScoringFootballers_withTwoFootballers_thenReturnTwoFootballers() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Michael Owen").setGoals(10).build(),
                Footballer.builder().setName("Ronaldo").setGoals(100).build()
        );

        final List<String> result = cut.findTheNamesOfTheTwoTopScoringFootballers(footballers);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Michael Owen"));
        assertTrue(result.contains("Ronaldo"));
    }

    @Test
    public void whenCall_findTheNamesOfTheTwoTopScoringFootballers_withThreeFootballers_thenReturnTheTwoTopScoringFootballers() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Michael Owen").setGoals(10).build(),
                Footballer.builder().setName("Neil Ardley").setGoals(4).build(),
                Footballer.builder().setName("Ronaldo").setGoals(100).build()
        );

        final List<String> result = cut.findTheNamesOfTheTwoTopScoringFootballers(footballers);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Michael Owen"));
        assertTrue(result.contains("Ronaldo"));
    }

    @Test
    public void whenCall_findTheNamesOfTheTwoTopScoringFootballers_withFiveFootballers_thenReturnTheTwoTopScoringFootballers() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Michael Owen").setGoals(10).build(),
                Footballer.builder().setName("Ronaldo").setGoals(100).build(),
                Footballer.builder().setName("Neil Ardley").setGoals(4).build(),
                Footballer.builder().setName("Maradona").setGoals(120).build(),
                Footballer.builder().setName("Rivaldo").setGoals(99).build()
        );

        final List<String> result = cut.findTheNamesOfTheTwoTopScoringFootballers(footballers);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Maradona"));
        assertTrue(result.contains("Ronaldo"));
    }

    @Test
    public void whenCall_getTheTotalNumberOfGoalsByCountry_withNoFootballers_thenReturnEmpty() {
        final Map<Country, Integer> result = cut.getTheTotalNumberOfGoalsByCountry(Collections.emptyList());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCall_getTheTotalNumberOfGoalsByCountry_with3FootballersFromOneCountry_thenReturn1CountryAndItsTotalGoals() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Ronaldo").setCountry(Country.BRAZIL).setGoals(10).build(),
                Footballer.builder().setName("Rivaldo").setCountry(Country.BRAZIL).setGoals(20).build(),
                Footballer.builder().setName("Socrates").setCountry(Country.BRAZIL).setGoals(25).build()
        );

        final Map<Country, Integer> result = cut.getTheTotalNumberOfGoalsByCountry(footballers);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.containsKey(Country.BRAZIL));
        assertEquals(55, (int) result.get(Country.BRAZIL));
    }

    @Test
    public void whenCall_getTheTotalNumberOfGoalsByCountry_with2FootballersFromDifferentCountries_thenReturn2CountriesAndTheGoalsForEachFootballer() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Ronaldo").setCountry(Country.BRAZIL).setGoals(20).build(),
                Footballer.builder().setName("Giroud").setCountry(Country.FRANCE).setGoals(1).build(),
                Footballer.builder().setName("Rivaldo").setCountry(Country.BRAZIL).setGoals(20).build(),
                Footballer.builder().setName("Pogba").setCountry(Country.FRANCE).setGoals(10).build(),
                Footballer.builder().setName("Socrates").setCountry(Country.BRAZIL).setGoals(25).build(),
                Footballer.builder().setName("Mbappe").setCountry(Country.FRANCE).setGoals(20).build()
        );

        final Map<Country, Integer> result = cut.getTheTotalNumberOfGoalsByCountry(footballers);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(Country.BRAZIL));
        assertTrue(result.containsKey(Country.FRANCE));
        assertEquals(65, (int) result.get(Country.BRAZIL));
        assertEquals(31, (int) result.get(Country.FRANCE));
    }

    @Test
    public void whenCall_getTheTotalNumberOfGoalsByCountry_with3FootballersForEachOf3Countries_thenReturn3CountriesAndTotalGoalsForEach() {
        final List<Footballer> footballers = List.of(
                Footballer.builder().setName("Ronaldo").setCountry(Country.BRAZIL).setGoals(20).build(),
                Footballer.builder().setName("Oliver Bierhoff").setCountry(Country.GERMANY).setGoals(30).build(),
                Footballer.builder().setName("Thomas Mueller").setCountry(Country.GERMANY).setGoals(2).build(),
                Footballer.builder().setName("Bastion Schweinsteiger").setCountry(Country.GERMANY).setGoals(5).build(),
                Footballer.builder().setName("Giroud").setCountry(Country.FRANCE).setGoals(1).build(),
                Footballer.builder().setName("Rivaldo").setCountry(Country.BRAZIL).setGoals(20).build(),
                Footballer.builder().setName("Pogba").setCountry(Country.FRANCE).setGoals(10).build(),
                Footballer.builder().setName("Socrates").setCountry(Country.BRAZIL).setGoals(25).build(),
                Footballer.builder().setName("Mbappe").setCountry(Country.FRANCE).setGoals(20).build()
        );

        final Map<Country, Integer> result = cut.getTheTotalNumberOfGoalsByCountry(footballers);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(result.containsKey(Country.BRAZIL));
        assertTrue(result.containsKey(Country.FRANCE));
        assertTrue(result.containsKey(Country.GERMANY));
        assertEquals(65, (int) result.get(Country.BRAZIL));
        assertEquals(31, (int) result.get(Country.FRANCE));
        assertEquals(37, (int) result.get(Country.GERMANY));
    }
}
