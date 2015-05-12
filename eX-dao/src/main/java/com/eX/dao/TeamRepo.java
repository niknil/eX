package com.eX.dao;

import com.eX.domain.Hero;
import com.eX.domain.Team;

import java.util.List;

/**
 * Created by Bamsen on 2015-05-10.
 */
public interface TeamRepo {

    List<Team> getAll();
    Team add(Team team);
    Team get(int id);
    Team update(Team entity);
    void delete(Team entity);
}
