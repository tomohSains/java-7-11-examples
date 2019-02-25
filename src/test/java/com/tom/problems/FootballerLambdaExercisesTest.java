package com.tom.problems;

import com.tom.domain.Country;
import com.tom.domain.Footballer;
import com.tom.domain.Position;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class FootballerLambdaExercisesTest {

    private final FootballerLambdaExercises footballerLambdaExercises = new FootballerLambdaExercises();

    @Test
    public void whenCall_FindIllDisciplinedGoalkeepers_thenReturnPeterSchmeichal_andNevilleSouthall() {
        final String peterSchmeichel = "Peter Schmeichel";
        final String nevilleSouthall = "Neville Southall";
        final List<Footballer> allFootballers = List.of(Footballer.builder().setName(peterSchmeichel).setRedCards(6).setPosition(Position.GOALKEEPER).build(),
                Footballer.builder().setName("David de Gea").setRedCards(2).setPosition(Position.GOALKEEPER).build(),
                Footballer.builder().setName("Jurgen Klinsmann").setRedCards(1).setPosition(Position.STRIKER).build(),
                Footballer.builder().setName(nevilleSouthall).setRedCards(7).setPosition(Position.GOALKEEPER).build());

        final List<String> result = footballerLambdaExercises.findIllDisciplinedGoalkeepers(allFootballers);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertThat(result).contains(peterSchmeichel, nevilleSouthall);
    }

    @Test
    public void whenCall_FindIllDisciplinedGoalkeepers_withNoGoalKeepers_thenReturnEmpty() {
        final List<Footballer> allFootballers = List.of(Footballer.builder().setName("Jurgen Klinsmann").setRedCards(1).setPosition(Position.STRIKER).build(),
                Footballer.builder().setName("Patrick Viera").setRedCards(7).setPosition(Position.MIDFIELDER).build());

        final List<String> result = footballerLambdaExercises.findIllDisciplinedGoalkeepers(allFootballers);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCall_FindIllDisciplinedGoalkeepers_withNoFootballers_thenReturnEmpty() {
        final List<Footballer> allFootballers = Collections.emptyList();

        final List<String> result = footballerLambdaExercises.findIllDisciplinedGoalkeepers(allFootballers);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichMatchesGeorgeWeah() {
        final Predicate<Footballer> predicate = footballerLambdaExercises.getHasOver50GoalsAndIsCAForUEFA();
        assertNotNull(predicate);

        final Footballer georgeWeah = Footballer.builder().setName("George Weah").setGoals(10001).setCountry(Country.LIBERIA).build();

        boolean result = predicate.test(georgeWeah);
        assertTrue(result);
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichDoesNOTMatchPatrickViera() {
        final Predicate<Footballer> predicate = footballerLambdaExercises.getHasOver50GoalsAndIsCAForUEFA();
        assertNotNull(predicate);

        final Footballer patrickViera = Footballer.builder().setName("Patrick Viera").setGoals(10).setCountry(Country.FRANCE).build();

        boolean result = predicate.test(patrickViera);
        assertFalse(result);
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichMatchesJurgenKlinsmann() {
        final Predicate<Footballer> predicate = footballerLambdaExercises.getHasOver50GoalsAndIsCAForUEFA();

        assertNotNull(predicate);

        final Footballer jurgenKlinsmann = Footballer.builder().setName("Jurgen Klinsmann").setGoals(1000).setCountry(Country.GERMANY).build();

        boolean result = predicate.test(jurgenKlinsmann);
        assertTrue(result);
    }

    @Test
    public void whenCall_isCAForUEFAWithOver50Goals_ThenReturnPredicate_WhichDoesNOTMatchPele() {
        final Predicate<Footballer> predicate = footballerLambdaExercises.getHasOver50GoalsAndIsCAForUEFA();
        assertNotNull(predicate);

        final Footballer pele = Footballer.builder().setName("Pele").setGoals(1000).setCountry(Country.BRAZIL).build();

        boolean result = predicate.test(pele);
        assertFalse(result);
    }

    @Test
    public void whenCall_getSortingByNumberOfGoalsAndRedCards_ThenReturnComparator_WhichSortsFootballersByGoalsDescending() {
        final Comparator<Footballer> comparator = footballerLambdaExercises.getSortingByNumberOfGoalsAndRedCards();
        assertNotNull(comparator);

        final List<Footballer> footballers = new ArrayList<>();
        footballers.add(Footballer.builder().setName("Gary Neville").setGoals(10).setRedCards(1).build());
        footballers.add(Footballer.builder().setName("Pele").setGoals(100).setRedCards(1).build());
        footballers.add(Footballer.builder().setName("Carlo Cudicini").setGoals(0).setRedCards(1).build());
        footballers.add(Footballer.builder().setName("Phil Jones").setGoals(5).setRedCards(1).build());
        footballers.add(Footballer.builder().setName("Peter Schmeichel").setGoals(2).setRedCards(1).build());


        footballers.sort(comparator);

        assertEquals(footballers.get(0).getName(), "Pele");
        assertEquals(footballers.get(1).getName(), "Gary Neville");
        assertEquals(footballers.get(2).getName(), "Phil Jones");
        assertEquals(footballers.get(3).getName(), "Peter Schmeichel");
        assertEquals(footballers.get(4).getName(), "Carlo Cudicini");
    }

    @Test
    public void whenCall_getSortingByNumberOfGoalsAndRedCards_ThenReturnComparator_WhichSortsFootballersByRedCardsAscending() {
        final Comparator<Footballer> comparator = footballerLambdaExercises.getSortingByNumberOfGoalsAndRedCards();
        assertNotNull(comparator);

        final List<Footballer> footballers = new ArrayList<>();
        footballers.add(Footballer.builder().setName("Steve Bruce").setGoals(10).setRedCards(0).build());
        footballers.add(Footballer.builder().setName("Ronaldo").setGoals(10).setRedCards(4).build());
        footballers.add(Footballer.builder().setName("Neymar").setGoals(10).setRedCards(2).build());
        footballers.add(Footballer.builder().setName("Maradona").setGoals(10).setRedCards(10).build());
        footballers.add(Footballer.builder().setName("Chris Kamara").setGoals(10).setRedCards(1).build());


        footballers.sort(comparator);

        assertEquals(footballers.get(0).getName(), "Steve Bruce");
        assertEquals(footballers.get(1).getName(), "Chris Kamara");
        assertEquals(footballers.get(2).getName(), "Neymar");
        assertEquals(footballers.get(3).getName(), "Ronaldo");
        assertEquals(footballers.get(4).getName(), "Maradona");
    }

    @Test
    public void whenCall_getSortingByNumberOfGoalsAndRedCards_ThenReturnComparator_WhichSortsFootballersBy_GoalsDescending_AndThenRedCardsAscending() {
        final Comparator<Footballer> comparator = footballerLambdaExercises.getSortingByNumberOfGoalsAndRedCards();
        assertNotNull(comparator);

        final List<Footballer> footballers = new ArrayList<>();
        footballers.add(Footballer.builder().setName("Steve Bruce").setGoals(12).setRedCards(0).build());
        footballers.add(Footballer.builder().setName("Ronaldo").setGoals(110).setRedCards(4).build());
        footballers.add(Footballer.builder().setName("Neymar").setGoals(80).setRedCards(2).build());
        footballers.add(Footballer.builder().setName("Maradona").setGoals(120).setRedCards(10).build());
        footballers.add(Footballer.builder().setName("Chris Kamara").setGoals(7).setRedCards(2).build());
        footballers.add(Footballer.builder().setName("Peter Schmeichel").setGoals(0).setRedCards(3).build());
        footballers.add(Footballer.builder().setName("Gary Neville").setGoals(7).setRedCards(3).build());
        footballers.add(Footballer.builder().setName("Pele").setGoals(120).setRedCards(0).build());
        footballers.add(Footballer.builder().setName("Carlo Cudicini").setGoals(0).setRedCards(2).build());
        footballers.add(Footballer.builder().setName("Phil Jones").setGoals(7).setRedCards(1).build());

        footballers.sort(comparator);

        assertEquals(footballers.get(0).getName(), "Pele");
        assertEquals(footballers.get(1).getName(), "Maradona");
        assertEquals(footballers.get(2).getName(), "Ronaldo");
        assertEquals(footballers.get(3).getName(), "Neymar");
        assertEquals(footballers.get(4).getName(), "Steve Bruce");
        assertEquals(footballers.get(5).getName(), "Phil Jones");
        assertEquals(footballers.get(6).getName(), "Chris Kamara");
        assertEquals(footballers.get(7).getName(), "Gary Neville");
        assertEquals(footballers.get(8).getName(), "Carlo Cudicini");
        assertEquals(footballers.get(9).getName(), "Peter Schmeichel");
    }

}
