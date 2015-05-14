package com.eX.dao;

import com.eX.domain.Hero;
import com.eX.domain.Team;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
public interface HeroRepo {

    List<Hero> getAll();
    Hero add(Hero entity);
    Hero get(int id);
    Hero update(Hero entity);
    void delete(Hero entity);
    public List<Team> filteredTeams(Hero hero);
    public void removeHeroFromTeam(int teamId, int heroId);

}
