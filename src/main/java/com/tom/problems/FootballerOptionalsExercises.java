package com.tom.problems;

import com.tom.domain.*;

import java.util.Optional;
import java.util.function.Function;

/**
 * HINT: Look at the methods on {@link Optional} that are available.
 */
public class FootballerOptionalsExercises {
    private final FootballerRepository footballerRepository;

    public FootballerOptionalsExercises(FootballerRepository footballerRepository) {
        this.footballerRepository = footballerRepository;
    }

    /**
     * Gets the Country for the footballer that matches to the given ID.
     * If no footballer exists for the given ID then the returned Optional will be empty.
     *
     * HINT: look at the {@link Optional#map(Function)} method
     *
     * @param id the id of the footballer
     * @return the country if found
     */
    public Optional<Country> getFootballersCountry(final int id) {
        // plz implement
        return null;
    }

    /**
     * Gets the name of the current club team for the footballer that matches to the given ID.
     * If no footballer exists for the given ID then the returned Optional will be empty.
     *
     * HINT: why doesn't {@link Optional#map(Function)} work here? Is there another method on the Optional class that you can use?
     *
     * @param id the id of the footballer
     * @return the current club team name if found
     */
    public Optional<String> getNameOfFootballersCurrentClubTeam(final int id) {
        // plz implement
        return null;
    }

    /**
     * Get a footballers position. Note that there is a legacy client that cannot handle optionals. Therefore
     * if there is no footballer for the given id, we need to return {@link Position#UNKNOWN}.
     *
     * HINT: Is there a method you can use on the {@link Optional} class for returning default values?
     *
     * @param id the id of the footballer
     * @return the position of the footballer or UNKNOWN
     */
    public Position getFootballersPosition(final int id) {
        // plz implement
        return null;
    }
}