package com.eX.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-03.
 */
@Entity
@Table(name = "Team")
public class Team implements Serializable {

    private int id;
    private String name;

    private List<Hero> heroes;

    public Team() {
    }

    public Team(Builder builder) {
        name = builder.name;
        heroes = builder.heroes;

    }

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToMany(targetEntity = Hero.class,fetch = FetchType.EAGER,mappedBy = "teams")
    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {

        private int id;
        private String name;
        private List<Hero> heroes;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withHeroes(List<Hero> heroes) {
            this.heroes = heroes;
            return this;
        }

        public Team Build() {
            return new Team(this);
        }
    }


}
