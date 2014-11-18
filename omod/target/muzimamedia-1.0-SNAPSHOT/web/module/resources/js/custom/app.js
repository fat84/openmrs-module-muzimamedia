var muzimamediaModule = angular.module('muzimamedia', ['ui.bootstrap']);

muzimamediaModule.
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.
            when('/list/videos', {templateUrl: '../../moduleResources/muzimamedia/partials/list/videos.html'}).
            when('/import/video', {templateUrl: '../../moduleResources/muzimamedia/partials/import/video.html'}).
            otherwise({redirectTo: '/list/videos'});
    }]);


muzimamediaModule.factory('FileUploadService', function ($http) {
    return {
        post: function (options) {
            return $http({
                method: 'POST',
                url: options.url,
                headers: { 'Content-Type': false },
                transformRequest: function (data) {
                    var formData = new FormData();
                    angular.forEach(data.params, function (key, value) {
                        formData.append(value, key);
                    });
                    formData.append("file", data.file);
                    return formData;
                },
                data: {file: options.file, params: options.params}
            })
        }
    };

});

muzimamediaModule.factory('MediaService', function ($http) {

    var all = function () {
        return $http.get('../../ws/rest/v1/muzimamedia/media', {cache: false});
    };
    var saveTag = function (media) {
           return $http.post('video/tag.form', media);
        };
    return {
        all: all
        }
});


