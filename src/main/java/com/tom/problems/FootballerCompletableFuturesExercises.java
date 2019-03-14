package com.tom.problems;

import com.tom.domain.AsyncFootballerService;
import com.tom.domain.ClubTeam;
import com.tom.domain.Game;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FootballerCompletableFuturesExercises {
    private final AsyncFootballerService asyncFootballerService;

    public FootballerCompletableFuturesExercises(final AsyncFootballerService asyncFootballerService) {
        this.asyncFootballerService = asyncFootballerService;
    }

    /**
     * Asynchronously gets the name of the footballer for the given ID.
     * If no footballer exists for the ID, then the {@link Optional} will be empty.
     *
     * @param id the id for the footballer
     * @return a future containing the name of the footballer if the footballer exists
     */
    public CompletableFuture<Optional<String>> getFootballersName(int id) {
        // plz implement
        return null;
    }

    /**
     * Asynchronously gets the upcoming games for the footballer with the given ID. If no footballer exists for the
     * ID or if there are no upcoming games for the footballer, then the list of games will be empty.
     *
     * HINT: use the {@link CompletableFuture#thenCompose(Function)} for composing dependent futures.
     *
     * @param id the ID for the footballer
     * @return a future containing the upcoming games for the footballer if the footballer exists
     */
    public CompletableFuture<List<Game>> getUpcomingClubGamesForFootballer(int id) {
        // plz implement
        return null;
    }

    /**
     * Asynchronously gets the recent and upcoming games for the club team. The games will be
     * in time order ascending.
     *
     * HINT: use the {@link CompletableFuture#thenCombine(CompletionStage, BiFunction)} for combining independent futures.
     *
     * @param clubTeam the club team
     * @return a future containing the recent/upcoming games for the team
     */
    public CompletableFuture<List<Game>> getTeamFixtures(ClubTeam clubTeam) {
        // plz implement
        return null;
    }
}
