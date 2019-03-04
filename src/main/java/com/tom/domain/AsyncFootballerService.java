package com.tom.domain;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncFootballerService {
    CompletableFuture<Footballer> getFootballer(int id);
    CompletableFuture<List<Game>> getUpcomingGames(ClubTeam clubTeam);
}
