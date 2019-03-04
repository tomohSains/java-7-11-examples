package com.tom.problems;

import com.tom.domain.AsyncFootballerService;
import com.tom.domain.Game;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FootballerCompletableFuturesExercises {
    private final AsyncFootballerService asyncFootballerService;

    public FootballerCompletableFuturesExercises(final AsyncFootballerService asyncFootballerService) {
        this.asyncFootballerService = asyncFootballerService;
    }

    public CompletableFuture<String> getFootballersName(int id) {
        // plz implement
        return null;
    }

    public CompletableFuture<List<Game>> getUpcomingGamesForFootballer(int id) {
        // plz implement
        return null;
    }

    public CompletableFuture<List<String>> getFootballerNames(int... ids) {
        // plz implement
        return null;
    }
}
