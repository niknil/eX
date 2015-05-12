package com.eX.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-03.
 */

@Entity
@Table(name = "Hero")
public class Hero{

    private int id;
    private String alias;
    private String alterEgo;
    private String abilities;
    private List<Team> teams;

    public Hero() {
    }

    public Hero(Builder builder) {
        this.alterEgo = builder.alterEgo;
        this.alias = builder.alias;
        this.abilities = builder.abilities;
    }

    @Id
    @Column(name = "hero_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId(){
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

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public void setAlterEgo(String alterEgo) {
        this.alterEgo = alterEgo;
    }

    public static Builder builder(){
        return new Builder();
    }

    @ManyToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name="team_hero",
            joinColumns=@JoinColumn(name="hero_id"),
            inverseJoinColumns=@JoinColumn(name="team_id"))
    public List<Team> getTeams() {
        if(teams == null){
            teams = new ArrayList<Team>();
        }

        return teams;
    }

    public void addTeam(Team team){
        if(teams == null){
            teams = new ArrayList<Team>();
        }

        teams.add(team);
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public static class Builder {
        private int id;
        private String alias;
        private String alterEgo;
        private String abilities;
        private List<Team> teams;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withAffiliation(List<Team> teams) {
            this.teams = teams;
            return this;
        }

        public Builder withAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public Builder withAlterEgo(String alterEgo) {
            this.alterEgo = alterEgo;
            return this;
        }

        public Builder withAbilities(String abilities) {
            this.abilities = abilities;
            return this;
        }

        public Hero Build() {
            return new Hero(this);
        }
    }
}
