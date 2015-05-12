package com.eX.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
public class HeroJson {

    private int id;
    private String alias;
    private String alterEgo;
    private String abilities;
    private List<TeamJson> teams;
    private boolean flag;

    @JsonCreator
    public HeroJson(@JsonProperty("id") int id,@JsonProperty("alias") String alias,@JsonProperty("alterEgo") String alterEgo,@JsonProperty("abilities") String abilities,@JsonProperty("flag") boolean flag) {
        this.id = id;
        this.alias = alias;
        this.alterEgo = alterEgo;
        this.abilities = abilities;
        this.flag = flag;
    }

    public HeroJson(Builder builder) {
        this.id = builder.id;
        this.alias = builder.alias;
        this.alterEgo = builder.alterEgo;
        this.abilities = builder.abilities;

    }

    public static Builder builder(){
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public List<TeamJson> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamJson> teams) {
        this.teams = teams;
    }

    public static class Builder {

        private int id;
        private String alias;
        private String alterEgo;
        private String abilities;
        private List<TeamJson> teams;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withAffiliation(String abilities) {
            this.abilities = abilities;
            return this;
        }

        public Builder withAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder withTeams(List<TeamJson> teams) {
            this.teams = teams;
            return this;
        }

        public Builder withAlterEgo(String alterEgo) {
            this.alterEgo = alterEgo;
            return this;
        }


        public HeroJson Build() {
            return new HeroJson(this);
        }
    }
}
