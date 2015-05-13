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

        $scope.findTeam = function (teamId) {
            $scope.init();
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

