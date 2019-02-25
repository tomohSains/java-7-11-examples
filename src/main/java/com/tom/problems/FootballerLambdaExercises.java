package com.tom.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

    public Predicate<Footballer> getCheckForIsCAForUEFAWithOver50Goals() {
        final Predicate<Footballer> isFromCAF = FootballerUtils::isFromCAF;
        return isFromCAF.or(FootballerUtils::isFromUEFA).and(f -> f.getGoals() > 50);
        //return null;
    }

    /**
     * Finds the goalkeepers who have been sent off more than 5 times.
     *
     * @param allFootballers all of the footballers
     * @return the names of the ill-disciplined goalkeepers
     */
    public List<String> findIllDisciplinedGoalkeepers(final List<Footballer> allFootballers) {
        return null;
    }

    public List<String> produceFootballersFeed(final List<Footballer> allFootballers, final Predicate<Footballer> keepInFeed, final Function<Footballer, String> formatFootballer) {
        final List<String> feed = new ArrayList<>();
        for (final Footballer footballer: allFootballers) {
            if (keepInFeed.test(footballer)) {
                feed.add(formatFootballer.apply(footballer));
            }
        }
        return feed;
    }

    private List<Footballer> getAllFootballers() {
        return Collections.emptyList();
    }

}
