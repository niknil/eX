(function() {
    'use strict';

    angular.module('core.routing')
        .config(routeProvider);

        function routeProvider($routeProvider) {

        $routeProvider.
        when('/team', {
            templateUrl: 'eX/team/teams.html',
            controller: 'TeamInitCtrl'
        }).
        when('/team/new', {
            templateUrl: 'eX/team/addTeam.html',
            controller: 'TeamCtrl'
        }).
        when('/team/:teamId', {
            templateUrl: 'eX/team/team.html',
            controller: 'TeamCtrl'
        }).
            when('/hero/new', {
                templateUrl: 'eX/heroes/addHero.html',
                controller: 'HeroCtrl'
            }).
        when('/hero', {
            templateUrl: 'eX/heroes/heroes.html',
            controller: 'HeroInitCtrl'
        }).
        when('/hero/:heroId', {
            templateUrl: 'eX/heroes/hero.html',
            controller: 'HeroCtrl'
        }).
        otherwise({
            redirectTo: '/'
        });

        }
})();