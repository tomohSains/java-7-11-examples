package com.tom.problems;

import com.tom.domain.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FootballerOptionalsExercisesTest {

    @Mock
    private FootballerRepository footballerRepository;

    private FootballerOptionalsExercises cut;

    @Before
    public void setup() {
        cut = new FootballerOptionalsExercises(footballerRepository);
    }

    @Test
    public void givenNoFootballerForId_whenCall_getFootballersCountry_thenReturnEmpty() {
        when(footballerRepository.getFootballer(anyInt())).thenReturn(Optional.empty());

        final Optional<Country> optionalCountry = cut.getFootballersCountry(123);

        assertNotNull(optionalCountry); // In actual code, you should not check that the optional is null
        assertFalse(optionalCountry.isPresent());
    }

    @Test
    public void givenBrazilianFootballerForId_whenCall_getFootballersCountry_thenReturnBrazil() {
        final Footballer brazilianFootballer = Footballer.builder().setName("Neymar").setCountry(Country.BRAZIL).build();
        final int brazilianFootballerId = 101;
        when(footballerRepository.getFootballer(brazilianFootballerId)).thenReturn(Optional.of(brazilianFootballer));

        final Optional<Country> optionalCountry = cut.getFootballersCountry(brazilianFootballerId);

        assertNotNull(optionalCountry); // In actual code, you should not check that the optional is null
        assertTrue(optionalCountry.isPresent());
        assertEquals(Country.BRAZIL, optionalCountry.get());
    }

    @Test
    public void givenNoFootballerForId_whenCall_getFootballersClubTeam_thenReturnEmpty() {
        when(footballerRepository.getFootballer(anyInt())).thenReturn(Optional.empty());

        final Optional<String> optionalClubTeamName = cut.getNameOfFootballersClubTeam(123);

        assertNotNull(optionalClubTeamName); // In actual code, you should not check that the optional is null
        assertFalse(optionalClubTeamName.isPresent());
    }

    @Test
    public void givenFootballerWithNoClubTeamForId_whenCall_getFootballersClubTeam_thenReturnEmpty() {
        final Footballer footballerWithNoClubTeam = Footballer.builder().setName("Pele").build();
        final int id = 101;
        when(footballerRepository.getFootballer(id)).thenReturn(Optional.of(footballerWithNoClubTeam));

        final Optional<String> optionalClubTeamName = cut.getNameOfFootballersClubTeam(id);

        assertNotNull(optionalClubTeamName); // In actual code, you should not check that the optional is null
        assertFalse(optionalClubTeamName.isPresent());
    }

    @Test
    public void givenFootballerWithClubTeamForId_whenCall_getFootballersClubTeam_thenReturnClubTeam() {
        String clubName = "Liverpool";
        final ClubTeam liverpool = ClubTeam.builder().setName(clubName).build();
        final Footballer footballerWithClubTeam = Footballer.builder().setName("Mo Salah").setCurrentClubTeam(liverpool).build();
        final int id = 101;
        when(footballerRepository.getFootballer(id)).thenReturn(Optional.of(footballerWithClubTeam));

        final Optional<String> optionalClubTeamName = cut.getNameOfFootballersClubTeam(id);

        assertNotNull(optionalClubTeamName); // In actual code, you should not check that the optional is null
        assertTrue(optionalClubTeamName.isPresent());
        assertEquals(clubName, optionalClubTeamName.get());
    }

    @Test
    public void givenNoFootballerForId_whenCall_getFootballersPosition_thenReturnUNKNOWN() {
        when(footballerRepository.getFootballer(anyInt())).thenReturn(Optional.empty());

        final Position position = cut.getFootballersPosition(123);

        assertNotNull(position); // In actual code, you should not check that the optional is null
        assertEquals(Position.UNKNOWN, position);
    }

    @Test
    public void givenStrikerForId_whenCall_getFootballersPosition_thenReturnStriker() {
        final Footballer striker = Footballer.builder().setName("Jamie Vardy").setPosition(Position.STRIKER).build();
        final int id = 101;
        when(footballerRepository.getFootballer(id)).thenReturn(Optional.of(striker));

        final Position position = cut.getFootballersPosition(id);

        assertNotNull(position); // In actual code, you should not check that the optional is null
        assertEquals(Position.STRIKER, position);
    }
}
