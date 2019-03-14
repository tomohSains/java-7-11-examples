package com.tom.problems;

import com.tom.domain.AsyncFootballerService;
import com.tom.domain.ClubTeam;
import com.tom.domain.Footballer;
import com.tom.domain.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FootballerCompletableFuturesExercisesTest {

    private FootballerCompletableFuturesExercises footballerCompletableFuturesExercises;

    @Mock
    private AsyncFootballerService asyncFootballerService;

    @Before
    public void setup() {
        this.footballerCompletableFuturesExercises = new FootballerCompletableFuturesExercises(asyncFootballerService);
    }

    @Test
    public void givenNoFootballerExistsForId_whenCallGetFootballersName_thenReturnEmptyFuture() throws Exception {
        final int id = 123;

        when(asyncFootballerService.getFootballer(id)).thenReturn(CompletableFuture.completedFuture(Optional.empty()));

        final CompletableFuture<Optional<String>> footballersNameFuture = footballerCompletableFuturesExercises.getFootballersName(id);

        final Optional<String> name = footballersNameFuture.get();

        assertFalse(name.isPresent());
    }

    @Test
    public void givenRonaldinhoExistsForId_whenCallGetFootballersName_thenReturnFutureContainingRonaldinho() throws Exception {
        final int id = 123;

        final String ronaldihnoName = "Ronaldinho";
        final Footballer ronaldihno = Footballer.builder().setName(ronaldihnoName).build();
        when(asyncFootballerService.getFootballer(id)).thenReturn(CompletableFuture.completedFuture(Optional.of(ronaldihno)));

        final CompletableFuture<Optional<String>> footballersNameFuture = footballerCompletableFuturesExercises.getFootballersName(id);

        final Optional<String> name = footballersNameFuture.get();

        assertTrue(name.isPresent());
        assertEquals(ronaldihnoName, name.get());
    }

    @Test
    public void givenNoFootballerExistsForId_whenCallGetUpcomingClubGamesForFootballer_thenReturnEmptyListOfGames() throws Exception {
        final int id = 123;

        when(asyncFootballerService.getFootballer(id)).thenReturn(CompletableFuture.completedFuture(Optional.empty()));

        final CompletableFuture<List<Game>> footballersGamesFuture = footballerCompletableFuturesExercises.getUpcomingClubGamesForFootballer(id);

        final List<Game> games = footballersGamesFuture.get();

        assertNotNull(games);
        assertTrue(games.isEmpty());
        verify(asyncFootballerService, never()).getUpcomingGames(any());
    }

    @Test
    public void givenFootballerExistsForId_AndThereAreNoUpcomingGamesForHisTeam_whenCallGetUpcomingClubGamesForFootballer_thenReturnEmptyListOfGames() throws Exception {
        final int id = 123;

        final ClubTeam barca = ClubTeam.builder().setName("Barca").build();
        final Footballer ronaldihno = Footballer.builder().setName("Ronaldinho").setCurrentClubTeam(barca).build();
        when(asyncFootballerService.getFootballer(id)).thenReturn(CompletableFuture.completedFuture(Optional.of(ronaldihno)));
        when(asyncFootballerService.getUpcomingGames(barca)).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));
        final CompletableFuture<List<Game>> footballersGamesFuture = footballerCompletableFuturesExercises.getUpcomingClubGamesForFootballer(id);

        final List<Game> games = footballersGamesFuture.get();
        assertNotNull(games);
        assertTrue(games.isEmpty());
        verify(asyncFootballerService, times(1)).getUpcomingGames(barca);
    }

    @Test
    public void givenFootballerExistsForId_AndThereAreUpcomingGamesForHisTeam_whenCallGetUpcomingClubGamesForFootballer_thenReturnListOfGames() throws Exception {
        final int id = 123;

        final ClubTeam barca = ClubTeam.builder().setName("Barca").build();
        final Footballer ronaldihno = Footballer.builder().setName("Ronaldinho").setCurrentClubTeam(barca).build();
        when(asyncFootballerService.getFootballer(id)).thenReturn(CompletableFuture.completedFuture(Optional.of(ronaldihno)));
        final List<Game> barcaGames = List.of(new Game());
        when(asyncFootballerService.getUpcomingGames(barca)).thenReturn(CompletableFuture.completedFuture(barcaGames));

        final CompletableFuture<List<Game>> footballersGamesFuture = footballerCompletableFuturesExercises.getUpcomingClubGamesForFootballer(id);

        final List<Game> games = footballersGamesFuture.get();
        assertNotNull(games);
        assertEquals(barcaGames, games);
    }

    @Test
    public void givenNoRecentAndUpcomingGamesExistForTeam_whenCallGetTeamFixtures_thenReturnEmptyListOfGames() throws Exception {
        final ClubTeam barca = ClubTeam.builder().setName("Barca").build();
        when(asyncFootballerService.getUpcomingGames(barca)).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));
        when(asyncFootballerService.getRecentResults(barca)).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));

        final CompletableFuture<List<Game>> teamFixturesFuture = footballerCompletableFuturesExercises.getTeamFixtures(barca);

        final List<Game> fixtures = teamFixturesFuture.get();

        assertNotNull(fixtures);
        assertTrue(fixtures.isEmpty());
    }

    @Test
    public void givenOnlyUpcomingGamesExistForTeam_whenCallGetTeamFixtures_thenReturnOnlyUpcomingGames() throws Exception {
        final ClubTeam barca = ClubTeam.builder().setName("Barca").build();
        final List<Game> upcomingGames = List.of(new Game(), new Game());
        when(asyncFootballerService.getUpcomingGames(barca)).thenReturn(CompletableFuture.completedFuture(upcomingGames));
        when(asyncFootballerService.getRecentResults(barca)).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));

        final CompletableFuture<List<Game>> teamFixturesFuture = footballerCompletableFuturesExercises.getTeamFixtures(barca);

        final List<Game> fixtures = teamFixturesFuture.get();

        assertNotNull(fixtures);
        assertEquals(upcomingGames, fixtures);
    }

    @Test
    public void givenOnlyRecentGamesExistForTeam_whenCallGetTeamFixtures_thenReturnOnlyRecentGames() throws Exception {
        final ClubTeam barca = ClubTeam.builder().setName("Barca").build();
        final List<Game> recentGames = List.of(new Game(), new Game());
        when(asyncFootballerService.getUpcomingGames(barca)).thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));
        when(asyncFootballerService.getRecentResults(barca)).thenReturn(CompletableFuture.completedFuture(recentGames));

        final CompletableFuture<List<Game>> teamFixturesFuture = footballerCompletableFuturesExercises.getTeamFixtures(barca);

        final List<Game> fixtures = teamFixturesFuture.get();

        assertNotNull(fixtures);
        assertEquals(recentGames, fixtures);
    }

    @Test
    public void givenRecentAndUpcomingGamesExistForTeam_whenCallGetTeamFixtures_thenReturnRecentAndUpcomingInOrderedList() throws Exception {
        final ClubTeam barca = ClubTeam.builder().setName("Barca").build();
        final List<Game> upcomingGames = List.of(new Game(), new Game());
        final List<Game> recentGames = List.of(new Game(), new Game());
        when(asyncFootballerService.getUpcomingGames(barca)).thenReturn(CompletableFuture.completedFuture(upcomingGames));
        when(asyncFootballerService.getRecentResults(barca)).thenReturn(CompletableFuture.completedFuture(recentGames));

        final CompletableFuture<List<Game>> teamFixturesFuture = footballerCompletableFuturesExercises.getTeamFixtures(barca);

        final List<Game> fixtures = teamFixturesFuture.get();

        assertNotNull(fixtures);
        assertEquals(4, fixtures.size());
        assertEquals(recentGames, fixtures.subList(0, 2));
        assertEquals(upcomingGames, fixtures.subList(2, 4));
    }

}
