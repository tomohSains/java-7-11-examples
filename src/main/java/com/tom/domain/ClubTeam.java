package com.tom.domain;

public class ClubTeam {
    private final String name;
    private final int yearEstablished;

    private ClubTeam(String name, int yearEstablished) {
        this.name = name;
        this.yearEstablished = yearEstablished;
    }

    public String getName() {
        return name;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String name;
        private int yearEstablished;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setYearEstablished(int yearEstablished) {
            this.yearEstablished = yearEstablished;
            return this;
        }

        public ClubTeam build() {
            return new ClubTeam(name, yearEstablished);
        }
    }

}
