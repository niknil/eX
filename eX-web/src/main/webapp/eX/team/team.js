(function () {
    'use strict';

    angular.module('app.teams')
        .controller('TeamCtrl', TeamCtrl)
        .controller('TeamInitCtrl', TeamInitCtrl);

    function TeamCtrl($scope, $http, dataService, $location, $route,$timeout) {

        $scope.searchContext = "";
        $scope.team = {};
        $scope.addHeroes = [];
        $scope.addHeroesSelection = [];

        var teamId;

        $scope.init = function(){
            teamId = $route.current.params.teamId;
            dataService.getTeamWithId(teamId).then(function() {
                $scope.team = dataService.getTeam();
            });
        }

        $scope.createTeam = function() {
            $http({
                method : 'POST',
                url : contextPath + '/team/',
                data : $scope.team
            }).success(function(result) {
                    $scope.team = result;
                    dataService.addTeam($scope.team);
                    $location.path('/team/' + $scope.team.id);

                });
        }

        $scope.getHeroes = function(teamId){
            $scope.addHeroes = [];
            dataService.getFilteredHeroes(teamId).then(function() {
                $scope.addHeroes = dataService.getHeroFilter();
                $("#addHeroes").show();
            });

        }

        $scope.findTeam = function (teamId) {
            $scope.init();
        }

        $scope.submitHeroes = function(){

            $scope.addHeroes = $scope.addHeroesSelection;

            $http({
                method : 'PUT',
                url : contextPath + '/team/hero/' + $scope.team.id,
                data : $scope.addHeroes
            }).success(function(data, status, headers, config) {
                $scope.addHeroes = data;
                $("#addHeroes").hide();
                $scope.addHeroesSelection.length = 0;
                $scope.findTeam();

            }).error(function(data) {
                $("#addHeroes").hide();
                var start = data.indexOf("Error");
                var end = data.indexOf("</title>");
                alert(data.slice(start,end));
            });


        }

        $scope.toggleSelection = function(addHeroes) {
            var idx = $scope.addHeroesSelection.indexOf(addHeroes);

            if (idx > -1) {
                $scope.addHeroesSelection.splice(idx, 1);
            }

            else {
                $scope.addHeroesSelection.push(addHeroes);
            }
        }

        $scope.init();

    }

    function TeamInitCtrl($scope,dataService,$http){

        $scope.teams = [];

        $scope.init = function(){
            dataService.getTeams().then(function() {
            $scope.teams = dataService.getTeamList();
            $("#teams").show();
        });
        }

        $scope.removeTeam = function(teamId){
            $http.delete(contextPath + "/team/" + teamId).success(function (response) {
                console.log("team removed");
                $scope.init();
            });
        }

        $scope.init();
    }

})();

