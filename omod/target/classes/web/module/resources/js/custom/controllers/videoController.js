'use strict';
function videoCtrl($scope, $window, MediaService)
{
    $scope.muzimaVideos;
    $scope.init = function () {
        getMedia().then(setMedia)
    };

    var getMedia= function(){
        return MediaService.all();
    };
    var setMedia = function(result){
        console.log(result);
        $scope.muzimaVideos = [{"Title" : "First", "Description" : "testing", "version":"1.0.0"}, {"Title" : "Second", "Description" : "testing 2", "version":"2.0.0"}];
    };
}

