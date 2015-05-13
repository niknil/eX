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
@RequestMapping("/hero")
public class HeroController {

    private ExServiceClientImpl exServiceClient;
    private Mapper mapper;

    public HeroController() {
    }

    public HeroController(ExServiceClientImpl exServiceClient, Mapper mapper) {
        this.exServiceClient = exServiceClient;
        this.mapper = mapper;
    }

    public HeroController(ExServiceClientImpl exServiceClient) {
        this.exServiceClient = exServiceClient;
    }


    @RequestMapping(value="/", method=RequestMethod.POST)
    @ResponseBody
    public HeroJson post(@RequestBody HeroJson heroJson){

        heroJson.setId(0);

        Hero returnHero = exServiceClient.addHero(mapper.JsonToHero(heroJson));

        return mapper.heroToJson(returnHero);
    }

    @RequestMapping(value = "", method=RequestMethod.GET)
    @ResponseBody
    public List<HeroJson> getAll(){

        List<HeroJson> heroes = new ArrayList<HeroJson>();

        for (Hero hero : exServiceClient.getHeroes()) {

            List<TeamJson> teamJson = new ArrayList<TeamJson>();
            HeroJson heroJsons = mapper.heroToJson(hero);

            for (Team team : hero.getTeams()) {
                teamJson.add(mapper.teamToJson(team));
            }

            heroJsons.setTeams(teamJson);
            heroes.add(heroJsons);

        }


        return heroes;

    }

    @RequestMapping(value = "/{heroId}", method=RequestMethod.GET)
    @ResponseBody
    public HeroJson get(@PathVariable("heroId") int heroId){

        Hero hero = exServiceClient.getHero(heroId);

        if(hero == null){
            throw new IllegalStateException("");
        }

        HeroJson heroJson = mapper.heroToJson(hero);

        List<TeamJson> teams = new ArrayList<TeamJson>();

        for(Team team: hero.getTeams()){
            teams.add(mapper.teamToJson(team));
        }

        heroJson.setTeams(teams);

        return heroJson;


    }

    @RequestMapping(value = "/team/{heroId}", method=RequestMethod.GET)
    @ResponseBody
    public List<TeamJson> getTeams(@PathVariable("heroId") int heroId){

        Hero hero = exServiceClient.getHero(heroId);

        if(hero == null){
            throw new IllegalStateException("");
        }

        List<TeamJson> teams = new ArrayList<>();

        for(Team team: exServiceClient.getTeams(hero)){
                             teams.add(mapper.teamToJson(team));
        }

        return teams;


    }

    @RequestMapping(value = "/team/{heroId}", method=RequestMethod.PUT)
    @ResponseBody
    public HeroJson addTeam(@PathVariable("heroId") int heroId,@RequestBody TeamJson teamJson){

        Hero hero = exServiceClient.getHero(heroId);

        if(hero == null){
            throw new IllegalStateException("");
        }

        Team team = exServiceClient.getTeam(teamJson.getId());




        hero.addTeam(team);

        hero = exServiceClient.editHero(hero);

        return mapper.heroToJson(hero);


    }


    @RequestMapping(value = "/edit/{heroId}", method = RequestMethod.DELETE)
    public HeroJson delete(@PathVariable("heroId") int heroId,@RequestBody HeroJson heroJson) {

        Hero hero = exServiceClient.getHero(heroId);

        if(hero == null){
            throw new IllegalStateException("Can't be null");
        }

        mapper.JsonToHero(heroJson);

        hero = exServiceClient.editHero(mapper.JsonToHero(heroJson));

        return mapper.heroToJson(hero);
    }




}
