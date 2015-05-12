package com.eX.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
public class TeamJson {

    private int id;
    private String name;
    private List<HeroJson> heroes;


    @JsonCreator
    public TeamJson(@JsonProperty("id") int id,@JsonProperty("name") String name,@JsonProperty("heroes") List<HeroJson> heroes){
        if(heroes == null){
            heroes = new ArrayList<HeroJson>();
        }

        this.id = id;
        this.name = name;
        this.heroes = heroes;
    }

    public TeamJson(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.heroes = builder.heroes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HeroJson> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<HeroJson> heroes) {
        this.heroes = heroes;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private int id;
        private String name;
        private List<HeroJson> heroes;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withHeroes(List<HeroJson> heroes) {
            this.heroes = heroes;
            return this;
        }

        public TeamJson Build() {
            return new TeamJson(this);
        }
    }



}
