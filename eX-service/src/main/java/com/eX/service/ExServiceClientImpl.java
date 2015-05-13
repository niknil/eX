package com.eX.service;

import com.eX.dao.HeroRepo;
import com.eX.dao.TeamRepo;
import com.eX.domain.Hero;
import com.eX.domain.Team;

import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
public class ExServiceClientImpl implements ExServiceClient {

    private HeroRepo heroRepo;
    private TeamRepo teamRepo;

    public ExServiceClientImpl(HeroRepo heroRepo, TeamRepo teamRepo){
        this.heroRepo = heroRepo;
        this.teamRepo = teamRepo;
    }

    public Hero addHero(Hero hero){
        heroRepo.add(hero);
        return heroRepo.get(hero.getId());
    }

    public Team addTeam(Team team){
        teamRepo.add(team);
        return teamRepo.get(team.getId());
    }

    public Hero getHero(int index){
        return heroRepo.get(index);
    }

    public Team getTeam(int index){
        return teamRepo.get(index);
    }

    public List<Hero> getHeroes(){
        return heroRepo.getAll();
    }

    public List<Team> getTeams(){
        return teamRepo.getAll();
    }

    public void deleteHero(Hero hero){
        heroRepo.delete(hero);
    }

    public void deleteTeam(Team team){
        teamRepo.delete(team);
    }

    public Hero editHero(Hero hero){
        return heroRepo.update(hero);
    }

    public Team editTeam(Team team){
        return teamRepo.update(team);
    }

    @Override
    public List<Team> getTeams(Hero hero) {
        return heroRepo.filteredTeams(hero);
    }


}
