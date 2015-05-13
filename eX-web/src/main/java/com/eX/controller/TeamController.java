package com.eX.controller;

import com.eX.domain.Hero;
import com.eX.domain.HeroJson;
import com.eX.domain.Team;
import com.eX.domain.TeamJson;
import com.eX.mappers.Mapper;
import com.eX.service.ExServiceClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    private ExServiceClientImpl exServiceClient;
    private Mapper mapper;

    public TeamController() {
    }

    public TeamController(ExServiceClientImpl exServiceClient, Mapper mapper) {
        this.exServiceClient = exServiceClient;
        this.mapper = mapper;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public TeamJson post(@RequestBody TeamJson teamJson) {

        teamJson.setId(0);

        Team returnTeam = exServiceClient.addTeam(mapper.JsonToTeam(teamJson));

        return mapper.teamToJson(returnTeam);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public List<TeamJson> getAll() {

        List<TeamJson> teamJson = new ArrayList<TeamJson>();

        for (Team team : exServiceClient.getTeams()) {
            teamJson.add(mapper.teamToJson(team));
        }

        return teamJson;
    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.GET)
    @ResponseBody
    public TeamJson get(@PathVariable("teamId") int teamId) {

        Team team = exServiceClient.getTeam(teamId);

        if(team == null){
            throw new IllegalStateException("");
        }

        TeamJson teamJson = mapper.teamToJson(team);

        List<HeroJson> heroes = new ArrayList<HeroJson>();

        for(Hero hero: team.getHeroes()){
            heroes.add(mapper.heroToJson(hero));
        }

        teamJson.setHeroes(heroes);

        return teamJson;

    }

    @RequestMapping(value = "/hero/{teamId}", method = RequestMethod.GET)
    @ResponseBody
    public List<HeroJson> getHeroesFiltered(@PathVariable("teamId") int teamId) {

        Team team = exServiceClient.getTeam(teamId);

        if(team == null){
            throw new IllegalStateException("");
        }

        List<HeroJson> heroesJson = new ArrayList<HeroJson>();

        List<Hero> filtering = team.getHeroes();
        List<Hero> heroes = exServiceClient.getHeroes();
        List<Hero> heroesFilter = new ArrayList<Hero>();

        for(Hero hero: heroes){

            for(Hero another: filtering){
                if(hero.getId() == another.getId()){
                    continue;
                }
                heroesFilter.add(hero);
            }

        }

        for(Hero hero: heroesFilter){
            heroesJson.add(mapper.heroToJson(hero));
        }

        return  heroesJson;

    }

    @RequestMapping(value = "/{teamId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("teamId") int teamId) {

        Team team = exServiceClient.getTeam(teamId);

        if(team == null){
            throw new IllegalStateException("");
        }




        exServiceClient.deleteTeam(team);


    }

}
