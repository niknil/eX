package com.eX.mappers;

import com.eX.domain.Hero;
import com.eX.domain.HeroJson;
import com.eX.domain.Team;
import com.eX.domain.TeamJson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-11.
 */
public class Mapper {

    public Mapper(){

    }

    public HeroJson heroToJson(Hero hero) {


        HeroJson heroJson = HeroJson.builder()
                .withId(hero.getId())
                .withAlterEgo(hero.getAlterEgo())
                .withAlias(hero.getAlias())
                .withAffiliation(hero.getAbilities())
                .Build();

        return heroJson;
    }

    public Hero JsonToHero(HeroJson heroJson) {

        Hero hero = Hero.builder()
                .withId(heroJson.getId())
                .withAlias(heroJson.getAlias())
                .withAlterEgo(heroJson.getAlterEgo())
                .withAbilities(heroJson.getAbilities())
                .Build();

        return hero;

    }

    public TeamJson teamToJson(Team team) {

        TeamJson json = TeamJson.builder()
                .withId(team.getId())
                .withName(team.getName())
                .Build();


        return json;
    }

    public Team JsonToTeam(TeamJson teamJson) {

        Team team = Team.builder()
                .withId(teamJson.getId())
                .withName(teamJson.getName())
                .Build();

        return team;
    }

}
