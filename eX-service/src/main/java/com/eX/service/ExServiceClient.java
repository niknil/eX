package com.eX.service;

import com.eX.domain.Hero;
import com.eX.domain.Team;

import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
public interface ExServiceClient {

    public Hero addHero(Hero hero);

    public Team addTeam(Team team);

    public Hero getHero(int index);

    public Team getTeam(int index);

    public List<Hero> getHeroes();

    public List<Team> getTeams();

    public void deleteHero(Hero hero);

    public void deleteTeam(Team team);

    public Hero editHero(Hero hero);

    public Team editTeam(Team team);

    public List<Team> getTeams(Hero hero);

    public void removeHeroFromTeam(int teamId, int heroId);
}
