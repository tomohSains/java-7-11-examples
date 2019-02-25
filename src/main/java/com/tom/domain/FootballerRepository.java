package com.tom.domain;

import java.util.Optional;

public interface FootballerRepository {
    /**
     * Gets the footballer matching the id
     * @param id the unique id of the footballer
     * @return returns an empty Optional if there is no footballer for the given id
     */
    Optional<Footballer> getFootballer(int id);
}
