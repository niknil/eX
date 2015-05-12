package com.eX.dao;

import com.eX.domain.Hero;
import com.eX.domain.Team;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

    public List<Hero> getHeroInTeams(int index) {

        Query query = session().createQuery("from User user inner join user.cars car where car.id in (:carIds)");
        query.setInteger("id", index);

        return (List<Hero>) query.list();
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
}
