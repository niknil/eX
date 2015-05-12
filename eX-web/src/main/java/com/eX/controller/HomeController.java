package com.eX.controller;

import com.eX.domain.Hero;
import com.eX.domain.Team;
import com.eX.service.ExServiceClient;
import com.eX.service.ExServiceClientImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bamsen on 2015-04-16.
 */


@Controller
public class HomeController {

    private ExServiceClient exServiceClient;

    public HomeController() {}

    public HomeController(ExServiceClient exServiceClient) {
        this.exServiceClient = exServiceClient;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {
        return new ModelAndView("index.jsp");
    }


    //QUICK INSERTION
    public void init() {

        Hero hulk = Hero.builder()
                .withAlias("The Hulk")
                .withAlterEgo("Bruce Banner")
                .withAbilities("Smasher,Very very very strong")
                .Build();

        Hero wonderWoman = Hero.builder()
                .withAlias("Wonder Woman")
                .withAlterEgo("Diana Prince")
                .withAbilities("Can fly, Access to magical weapons")
                .Build();

        Hero starLord = Hero.builder()
                .withAlias("StarLord")
                .withAlterEgo("Peter Quill")
                .withAbilities("Skilled Marksman, Master strategist and problem solver")
                .Build();

        Hero batman = Hero.builder()
                .withAlias("Batman")
                .withAlterEgo("Bruce Wayne")
                .withAbilities("Cunning,Access to modern gadget,Intelligent")
                .Build();

        Hero superMan = Hero.builder()
                .withAlias("Superman")
                .withAlterEgo("Clark Kent")
                .withAbilities("Superhuman strength, Laser eyes and Flying")
                .Build();

        Hero flash = Hero.builder()
                .withAlias("The Flash")
                .withAlterEgo("Barry Allen")
                .withAbilities("Fast as the lightning")
                .Build();

        Hero thanos = Hero.builder()
                .withAlias("Thanos")
                .withAlterEgo("none")
                .withAbilities("One of the most powerful villains, Intelligent")
                .Build();

        Hero captain = Hero.builder()
                .withAlias("Captain America")
                .withAlterEgo("Steve Rogers")
                .withAbilities("Strong, fast and a Natural leader")
                .Build();

        Hero iron = Hero.builder()
                .withAlias("Tony Stark")
                .withAlterEgo("Steve Rogers")
                .withAbilities("Genius-level intellect,Highly proficient scientist, engineer, and businessperson , Powered armored suit")
                .Build();


        Team team = Team.builder().withName("Avengers").Build();
        Team team1 = Team.builder().withName("Justice League").Build();
        Team team2 = Team.builder().withName("Guardians of the Galaxy").Build();
        Team team3 = Team.builder().withName("S.H.I.E.L.D").Build();

            exServiceClient.addTeam(team);
            exServiceClient.addTeam(team1);
            exServiceClient.addTeam(team2);
            exServiceClient.addTeam(team3);

        List<Hero> justice = new ArrayList<Hero>();

        justice.add(wonderWoman);
        justice.add(batman);
        justice.add(superMan);
        justice.add(flash);

        List<Hero> avengers = new ArrayList<Hero>();
        avengers.add(hulk);
        avengers.add(captain);
        avengers.add(iron);


        List<Hero> guardians = new ArrayList<Hero>();
        guardians.add(starLord);

        List<Hero> shield = new ArrayList<Hero>();
        shield.add(captain);

        List<Team> captains = new ArrayList<Team>();
        captains.add(team3);
        captains.add(team);

        captain.setTeams(captains);

        List<Team> justiceteam = new ArrayList<Team>();
        justiceteam.add(team1);

        wonderWoman.setTeams(justiceteam);
        batman.setTeams(justiceteam);
        superMan.setTeams(justiceteam);
        flash.setTeams(justiceteam);

        List<Team> guardianteam = new ArrayList<Team>();
        guardianteam.add(team2);

        starLord.setTeams(guardianteam);

        List<Team> avengersteam = new ArrayList<Team>();
        avengersteam.add(team);

        captain.setTeams(avengersteam);
        iron.setTeams(avengersteam);
        hulk.setTeams(avengersteam);

/*
        exServiceClient.editHero(hulk);
        exServiceClient.editHero(iron);
        exServiceClient.editHero(captain);
        exServiceClient.editHero(thanos);
        exServiceClient.editHero(wonderWoman);
        exServiceClient.editHero(batman);
        exServiceClient.editHero(flash);
        exServiceClient.editHero(batman);
        exServiceClient.editHero(starLord);
        exServiceClient.editHero(superMan);

        exServiceClient.editTeam(team2);
        exServiceClient.editTeam(team3);
        exServiceClient.editTeam(team);
        exServiceClient.editTeam(team1);


        exServiceClient.addTeam(team);
        exServiceClient.addTeam(team1);
        exServiceClient.addTeam(team2);
        exServiceClient.addTeam(team3);
*/


            exServiceClient.addHero(hulk);
            exServiceClient.addHero(iron);
            exServiceClient.addHero(captain);
            exServiceClient.addHero(thanos);
            exServiceClient.addHero(wonderWoman);
            exServiceClient.addHero(batman);
            exServiceClient.addHero(flash);
            exServiceClient.addHero(starLord);
            exServiceClient.addHero(superMan);

    }


}
