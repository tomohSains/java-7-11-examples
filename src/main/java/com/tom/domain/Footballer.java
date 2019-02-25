package com.tom.domain;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Footballer {
    private final int id;
    private final String name;
    private final Country country;
    private final int minutesPlayed;
    private final int appearances;
    private final int goals;
    private final int redCards;
    private final int yellowCards;
    private final Position position;
    private final int yearOfBirth;
    private final ClubTeam currentClubTeam;
    private final List<ClubTeam> clubTeamHistory;

    private Footballer(int id, String name, Country country, int minutesPlayed, int appearances, int goals, int redCards, int yellowCards, Position position, int yearOfBirth, ClubTeam currentClubTeam, List<ClubTeam> clubTeamHistory) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.minutesPlayed = minutesPlayed;
        this.appearances = appearances;
        this.goals = goals;
        this.redCards = redCards;
        this.yellowCards = yellowCards;
        this.position = position;
        this.yearOfBirth = yearOfBirth;
        this.currentClubTeam = currentClubTeam;
        this.clubTeamHistory = clubTeamHistory;
    }

    public int getId() {
        return id;
    }

    /**
     * Some footballers do not have a current club team, e.g. if they are a free-agent or have retired.
     * @return the current club team or empty if the footballer does not have a current team
     */
    public Optional<ClubTeam> getCurrentClubTeam() {
        return Optional.ofNullable(currentClubTeam);
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public int getAppearances() {
        return appearances;
    }

    public int getGoals() {
        return goals;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public Position getPosition() {
        return position;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    /**
     * Get all club teams that the footballer has played for. This includes the current club side.
     * @return all club sides that the footballer has played for
     */
    public List<ClubTeam> getClubTeamHistory() {
        return clubTeamHistory == null ? Collections.emptyList() : Collections.unmodifiableList(clubTeamHistory);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private String name;
        private Country country;
        private int minutesPlayed;
        private int appearances;
        private int goals;
        private int redCards;
        private int yellowCards;
        private Position position;
        private int yearOfBirth;
        private ClubTeam currentClubTeam;
        private List<ClubTeam> clubTeamHistory;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setCurrentClubTeam(ClubTeam currentClubTeam) {
            this.currentClubTeam = currentClubTeam;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public Builder setMinutesPlayed(int minutesPlayed) {
            this.minutesPlayed = minutesPlayed;
            return this;
        }

        public Builder setAppearances(int appearances) {
            this.appearances = appearances;
            return this;
        }

        public Builder setGoals(int goals) {
            this.goals = goals;
            return this;
        }

        public Builder setRedCards(int redCards) {
            this.redCards = redCards;
            return this;
        }

        public Builder setYellowCards(int yellowCards) {
            this.yellowCards = yellowCards;
            return this;
        }

        public Builder setPosition(Position position) {
            this.position = position;
            return this;
        }

        public Builder setYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public Builder setClubTeamHistory(List<ClubTeam> clubTeamHistory) {
            this.clubTeamHistory = clubTeamHistory;
            return this;
        }


        public Footballer build() {
            return new Footballer(id, name, country, minutesPlayed, appearances, goals, redCards, yellowCards, position, yearOfBirth, currentClubTeam, clubTeamHistory);
        }
    }
}
