var muzimaformsModule = angular.module('muzimamedia', ['ui.bootstrap']);

muzimaformsModule.
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
            when('/list/videos', {templateUrl: '../../moduleResources/muzimamedia/partials/list/videos.html'}).
            otherwise({redirectTo: '/list/videos'});
    }]);
