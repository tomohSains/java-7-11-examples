package com.tom.problems;

import com.tom.domain.*;

import java.util.Optional;

public class FootballerOptionalsExercises {
    private final FootballerRepository footballerRepository;

    public FootballerOptionalsExercises(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    public Optional<Country> getFootballersCountry(final int id) {
        // plz implement
        return null;
    }

    public Optional<String> getNameOfFootballersClubTeam(final int id) {
        // plz implement
        return null;
    }

    /**
     * Get a footballers position. Note that there is a legacy client that cannot handle optionals. Therefore
     * if there is no footballer for the given id, we need to return {@link Position#UNKNOWN}.
     *
     * @param id the id of the footballer
     * @return the position of the footballer or UNKNOWN
     */
    public Position getFootballersPosition(final int id) {
        // plz implement
        return null;
    }
}