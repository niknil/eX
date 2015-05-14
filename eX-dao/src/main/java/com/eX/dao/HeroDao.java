package com.eX.dao;

import com.eX.domain.Hero;
import com.eX.domain.Team;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-03.
 */

@Repository
@Transactional
public class HeroDao implements HeroRepo {

    private SessionFactory sessionFactory;
    private TeamRepo teamRepo;

    public HeroDao(){}

    public HeroDao(SessionFactory sessionFactory,TeamRepo teamRepo){
        this.teamRepo = teamRepo;
        this.sessionFactory = sessionFactory;
    }

    private Session session(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Hero> getAll() {

        return (List<Hero>) this.session().createQuery("from Hero").list();
    }

    @Override
    public Hero add(Hero hero) {
        this.session().save(hero);
        return get(hero.getId());
    }

    @Override
    public Hero get(int id) {
        Hero hero = (Hero) this.session().get(Hero.class, id);
        return hero;
    }

    @Override
    public Hero update(Hero hero) {
        this.session().update(hero);
        return get(hero.getId());
    }

    @Override
    public void delete(Hero hero) {
        hero.setTeams(new ArrayList<Team>());
        hero = this.update(hero);
        this.session().delete(hero);
        session().clear();
    }


    @Override
    public List<Team> filteredTeams(Hero hero) {

        List<Team> filtered = new ArrayList<>();
        List<Team> takeOut = hero.getTeams();

        if(takeOut.isEmpty()){
              filtered = teamRepo.getAll();
        }else{


        for(Team filter: takeOut){

        for(Team team: teamRepo.getAll()){

                if(team.getId() == filter.getId()){
                    continue;
                }
                filtered.add(team);
            }


        }
        }
        return filtered;
    }

    public void removeHeroFromTeam(int teamId, int heroId) {

            Team team = (Team)session().get(Team.class, teamId);
            Hero hero = (Hero)session().get(Hero.class, teamId);
            team.getHeroes().remove(hero);
            hero.getTeams().remove(team);
            session().save(team);
            session().save(hero);
    }



}
