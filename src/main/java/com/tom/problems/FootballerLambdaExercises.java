package com.tom.problems;

import com.tom.domain.Footballer;
import com.tom.domain.FootballerUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FootballerLambdaExercises {

    /**
     * Finds the names of goalkeepers who have been sent off more than 5 times.
     *
     * HINT: use {@link FootballerLambdaExercises#produceFootballersFeed(List, Predicate, Function)}
     *
     * @param allFootballers all of the footballers
     * @return the names of the ill-disciplined goalkeepers
     */
    public List<String> findIllDisciplinedGoalkeepers(final List<Footballer> allFootballers) {
        // plz implement
        return null;
    }

    /**
     * Creates a predicate which matches footballers that have scored over
     * 50 goals and are in either CAF (Confederation of African Football) or UEFA (Union of European Football Associations)
     *
     * HINT: see {@link FootballerUtils}
     *
     * @return the predicate
     */
    public Predicate<Footballer> getHasOver50GoalsAndIsCAForUEFA() {
        // plz implement
        return null;
    }

    /**
     * Create a comparator that sorts footballers by number of goals (most to least, i.e. descending). If two
     * footballers have the same number of goals, the one with the least red cards should come first.
     *
     * @return the sorting
     */
    public Comparator<Footballer> getSortingByNumberOfGoalsAndRedCards() {
        //plz implement
        return null;
    }

    private List<String> produceFootballersFeed(final List<Footballer> allFootballers, final Predicate<Footballer> keepInFeed, final Function<Footballer, String> formatFootballer) {
        final List<String> feed = new ArrayList<>();
        for (final Footballer footballer: allFootballers) {
            if (keepInFeed.test(footballer)) {
                feed.add(formatFootballer.apply(footballer));
            }
        }
        return feed;
    }
}
