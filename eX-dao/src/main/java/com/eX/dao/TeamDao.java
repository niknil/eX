package com.eX.dao;

import com.eX.domain.Hero;
import com.eX.domain.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-05-03.
 */
@Repository
@Transactional
public class TeamDao implements TeamRepo {

    private SessionFactory sessionFactory;

    public TeamDao(){}

    public TeamDao(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session session(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Team> getAll() {
        return (List<Team>) this.session().createQuery("from Team").list();
    }

    @Override
    public Team add(Team team) {
        this.session().save(team);
        return get(team.getId());
    }

    @Override
    public Team get(int id) {
        Team team = (Team) this.session().get(Team.class, id);
        return team;
    }

    @Override
    public Team update(Team team) {
        this.session().update(team);
        return get(team.getId());
    }

    @Override
    public void delete(Team team) {
        this.session().delete(team);
    }
}
