(function() {
    'use strict';

    angular.module('app.heroes')
    .controller('HeroCtrl', HeroCtrl)
    .controller('HeroInitCtrl',HeroInitCtrl);

    function HeroCtrl($scope, $http, $route, dataService,$location) {

        $scope.hero = {};
        $scope.addHero = {};
        var heroId;

        $scope.init = function(){
            heroId = $route.current.params.heroId;
            dataService.getHeroWithId(heroId).then(function() {
                $scope.hero = dataService.getHero();
            });

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

        $scope.editHero = function(heroId) {
            console.log("hej");
            $http({
                method : 'PUT',
                url : contextPath + '/hero/edit/' + heroId,
                data : $scope.addHero
            }).success(function(result) {
                $scope.hero = result;
                dataService.addHero($scope.hero);
                $location.path('/hero/' + $scope.hero.id);

            });
        }


        $scope.show = function(){
            $("#edit").show();
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

