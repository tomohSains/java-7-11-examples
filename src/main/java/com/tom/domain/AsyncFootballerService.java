package com.tom.domain;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AsyncFootballerService {
    /**
     * Asynchronously gets a Footballer for the given ID. If no footballer exists for the ID,
     * then {@link Optional} will be empty.
     * @param id the footballers ID
     * @return a future containing the footballer
     */
    CompletableFuture<Optional<Footballer>> getFootballer(int id);

    /**
     * Asynchronously gets upcoming games for the given team in time order ascending.
     * @param clubTeam the club team
     * @return a future containing the upcoming games for the team
     */
    CompletableFuture<List<Game>> getUpcomingGames(ClubTeam clubTeam);

    /**
     * Asynchronously gets recent games for the given team in time order ascending.
     * @param clubTeam the club team
     * @return a future containing the recent games for the team
     */
    CompletableFuture<List<Game>> getRecentResults(ClubTeam clubTeam);
}
