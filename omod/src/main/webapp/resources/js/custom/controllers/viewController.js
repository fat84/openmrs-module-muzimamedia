'use strict';
function viewCtrl($scope, $window, $routeParams, MediaService){

    $scope.uuid = $routeParams.uuid;
    $scope.tagColorMap = {};
    $scope.init = function(){
        getMedia($scope.uuid).then(setMedia).then(setUrl);
    }
    var getMedia= function(uuid){
            return MediaService.get(uuid);
        };
    var setMedia = function(result){
        console.log(result.data);
        $scope.media = result.data;
        return $scope.media
    };
    var setUrl = function(result){
        console.log("in set url "+ result);
        result.url = "../../moduleResources/muzimamedia/media/" + result.url;
        if(result.muzimaMediaType == 1){
            // setting video
            var HTMLvideo = document.getElementById("HTMLvideo");
            var source = document.createElement('source');
            source.setAttribute('src', result.url);
            HTMLvideo.appendChild(source);
            HTMLvideo.load();
        }
        if(result.muzimaMediaType == 2){
            // setting Image

            var HTMLimage = document.getElementById("HTMLimage");
            HTMLimage.src = result.url;
        }

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