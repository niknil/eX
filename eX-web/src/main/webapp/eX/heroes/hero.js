(function() {
    'use strict';

    angular.module('app.heroes')
    .controller('HeroCtrl', HeroCtrl)
    .controller('HeroInitCtrl',HeroInitCtrl);

    function HeroCtrl($scope, $http, $route, dataService,$location) {

        $scope.hero = {};
        $scope.addHero = {};
        $scope.selectedTeam = {};
        var heroId;

        $scope.init = function(){
            heroId = $route.current.params.heroId;
            dataService.getHeroWithId(heroId).then(function() {
                $scope.hero = dataService.getHero();
            });

        }

        $scope.changedValue=function(team){
            console.log( $scope.selectedTeam);
            $scope.selectedTeam = team;
        }


        $scope.createHero = function() {
            $http({
                method : 'POST',
                url : contextPath + '/hero/',
                data : $scope.hero
            }).success(function(result) {
                $scope.hero = result;
                dataService.addHero($scope.hero);
                $location.path('/hero/' + $scope.hero.id);

            });
        }

        $scope.getTeams = function(heroId){

            dataService.getFilteredTeams(heroId).then(function() {
                $scope.addTeams = dataService.getTeamFilter();
                $("#addHeroes").show();
            });

        }

        $scope.toggleSelection = function(team) {

      $scope.selectedTeam = team;
        }
        $scope.submitTeam = function(heroId) {
            $http({
                method : 'PUT',
                url : contextPath + '/hero/team/' + heroId,
                data : $scope.selectedTeam
            }).success(function(result) {
                $scope.hero = result;
                dataService.addHero($scope.hero);
                $location.path('/hero/' + $scope.hero.id);

            });
        }

        $scope.removeHeroFromTeam = function(teamId) {


            $http({
                method : 'DELETE',
                url : 'http://localhost:8080/hero/edit/' + teamId,
                data : $scope.hero,
                headers: {
                    'Content-Type': 'application/json'

                }}).success(function() {

                    $location.path('/hero/' + $scope.hero.id);


                });
        }


        $scope.init();
    }

    function HeroInitCtrl($scope, dataService,$http,$location) {

        $scope.heroes = [];
        $scope.itemsPerPage = 5;
        $scope.currentPage = 1;
        $scope.filteredHeroes = [];
        $scope.addHero = {};

        $scope.init = function(){
        dataService.getHeroes().then(function() {
            $scope.heroes = dataService.getHeroList();
            $scope.pagination();
            $("#hero").show();
        });

        }


        $scope.pagination = function() {
            var begin = (($scope.currentPage - 1) * $scope.itemsPerPage);
            var end = begin + $scope.itemsPerPage;
            $scope.filteredHeroes = $scope.heroes.slice(begin, end);
        };

        $scope.pageChanged = function() {
            $scope.pagination();
        };



        $scope.init();

    }

})();

