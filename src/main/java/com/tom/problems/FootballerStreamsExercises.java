package com.tom.problems;

import com.tom.domain.Country;
import com.tom.domain.Footballer;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;

public class FootballerStreamsExercises {
    /**
     * Finds the names of all footballers with more than 5 red cards.
     * @param allFootballers the input footballers to search
     * @return a list of names
     */
    public List<String> findTheNamesOfFootballersWithMoreThan5RedCards(final List<Footballer> allFootballers) {
        // plz implement
        return null;
    }

    /**
     * Finds the names of the two top-scoring footballers from a list of footballers. If there is a tie between 2nd and 3rd, then this method
     * offers no guarantees about which will be picked.
     *
     * @param allFootballers the input footballers to search
     * @return a list of names
     */
    public List<String> findTheNamesOfTheTwoTopScoringFootballers(final List<Footballer> allFootballers) {
        // plz implement
        return null;
    }

    /**
     * Creates a map from country to total number of goals scored by that country.
     *
     * HINT: see {@link java.util.stream.Collectors#groupingBy(Function, Collector)}
     *
     * @param allFootballers the input footballers to process
     * @return a Map from Country to goals
     */
    public Map<Country, Integer> getTheTotalNumberOfGoalsByCountry(final List<Footballer> allFootballers) {
        // plz implement
        return null;
    }

    /**
     * Finds the names of all the clubs that all the footballers have played for.
     * See: {@link Footballer#getClubTeamHistory()}. This returns all the club teams that a footballer has played for.
     *
     * HINT: {@link java.util.stream.Stream#flatMap(Function)}
     *
     * @param allFootballers the input footballers to process
     * @return the set of all names of the clubs
     */
    public Set<String> getTheNamesOfAllClubTeamsThatTheFootballersHavePlayedFor(final List<Footballer> allFootballers) {
        // plz implement
        return null;
    }
}