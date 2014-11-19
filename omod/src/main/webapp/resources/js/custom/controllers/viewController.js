'use strict';
function viewCtrl($scope, $window, $routeParams, MediaService){

    $scope.uuid = $routeParams.uuid;
    $scope.tagColorMap = {};
    $scope.init = function(){
        getMedia($scope.uuid).then(setMedia);
    }
    var getMedia= function(uuid){
            return MediaService.get(uuid);
        };
    var setMedia = function(result){
        console.log(result.data);
        $scope.media = result.data;
        setUrl($scope.media.url);

    };
    var setUrl = function(url){
        url = "../../moduleResources/muzimamedia/media/" + url;
        var HTMLvideo = document.getElementById("HTMLvideo");
        var source = document.createElement('source');
        source.setAttribute('src', url);
        HTMLvideo.appendChild(source);
        HTMLvideo.load();
    };
    var tagColor = function (tagId) {
        var tag = $scope.tagColorMap[tagId];
        if (!tag) {
            $scope.tagColorMap[tagId] = {};
            $scope.tagColorMap[tagId].color =
                'rgb(' + (50 + Math.floor(Math.random() * 150))
                + ',' + (50 + Math.floor(Math.random() * 150))
                + ',' + (50 + Math.floor(Math.random() * 150)) + ')';
        }
        return $scope.tagColorMap[tagId].color;
    };
    $scope.tagStyle = function (tagId) {
        return  {'background-color': tagColor(tagId)};
    };
}