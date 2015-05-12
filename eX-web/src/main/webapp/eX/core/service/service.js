(function () {
    angular.module('core.service')
        .factory('dataService', dataService);

    function dataService($http,$q) {

        var team = {};
        var hero = {};
        var teamList = [];
        var heroList = [];
        var heroFilter = [];

        var service = {
            setHeroList: setHeroList,
            setTeamList: setTeamList,
            addTeam: addTeam,
            getTeams: getTeams,
            getTeamList: getTeamList,
            getTeam:getTeam,
            getHeroes:getHeroes,
            getHero:getHero,
            addHero:addHero,
            getHeroList:getHeroList,
            getTeamWithId:getTeamWithId,
            getHeroWithId:getHeroWithId,
            getFilteredHeroes:getFilteredHeroes,
            getHeroFilter:getHeroFilter

        };

        function setTeamList(data){
            teamList = data;
        }

        function getHero() {
            return hero;
        }

        function getTeam() {
            return team;
        }

        function addTeam(team) {
            teamList.push(team);
        }

        function getTeams() {

            var deffered = $q.defer();

                $http.get(contextPath + "/team").success(function (data) {
                    teamList = data;
                    deffered.resolve();
                });

                return deffered.promise;

        }

        function getFilteredHeroes(teamId) {

            var deffered = $q.defer();

            $http.get(contextPath + "/team/hero/" + teamId).success(function (data) {
                heroFilter = data;
                deffered.resolve();
            });

            return deffered.promise;

        }

        function getHeroFilter() {
            return heroFilter;
        }

        function getTeamList() {
            return teamList;
        }

        function setHeroList(data){
            heroList = data;
        }

        function getHeroWithId(heroId) {
            var deffered = $q.defer();

            $http.get(contextPath + "/hero/" + heroId).success(function (data) {
                hero = data;
                deffered.resolve();
            });

            return deffered.promise;

        }

        function getTeamWithId(teamId) {
            var deffered = $q.defer();

            $http.get(contextPath + "/team/" + teamId).success(function (data) {
                team = data;
                deffered.resolve();
            });

            return deffered.promise;

        }

        function addHero(team) {
            teamList.push(team);
        }

        function getHeroes() {

            var deffered = $q.defer();

            $http.get(contextPath + "/hero").success(function (data) {
                heroList = data;
                deffered.resolve();
            });

            return deffered.promise;

        }

        function getHeroList() {
            return heroList;
        }


        return service;

    }
})();