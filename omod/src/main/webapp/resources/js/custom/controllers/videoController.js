'use strict';
function videoCtrl($scope, $window, $location, MediaService, TagService, TypeService)
{
    $scope.muzimaVideos;
    $scope.isToggleOn = false;
    $scope.toggleFilter ={'voided':false};

    $scope.init = function () {
        $scope.editMode = false;
        $scope.tagColorMap = {};
        getMedia().then(setMedia)
    };

    var getMedia= function(){
        return MediaService.all();
    };
    var setMedia = function(result){
        console.log(result.data.results);
        $scope.muzimaVideos = result.data.results;
    };
    var getTags = function () {
            return TagService.all();
        };
    var setTags = function (result) {
            $scope.tags = result.data.results;
        };
    $scope.getType = function(id){
        return TypeService.get(id);
     };
    $scope.setType = function(result){
            return result.data.name;
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
    $scope.remove = function (muzimamedia) {
            muzimamedia.voided = true;
            MediaService.remove(muzimamedia)
                .then(function () { });
        };
    $scope.viewMedia = function(muzimamedia){
        $location.path("/list/view/"+muzimamedia.uuid);
    };
    $scope.go = function(path){
        $location.path(path);
    };
    $scope.toggleRetired = function(){
            if($scope.isToggleOn){
                $scope.isToggleOn = false;
                $scope.toggleFilter ={'voided':false};
            }else{
                $scope.isToggleOn = true;
                $scope.toggleFilter ="";
            }

        };
}

