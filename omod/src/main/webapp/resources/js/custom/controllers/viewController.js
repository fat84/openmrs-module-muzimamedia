'use strict';
function viewCtrl($scope, $window, $routeParams, MediaService, FileUploadService, $location){

    $scope.editHtml = false;
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
        var url = "../../moduleResources/muzimamedia/media/" + result.url;
        if(result.muzimaMediaType == 1){
            // setting video
            var HTMLvideo = document.getElementById("HTMLvideo");
            var source = document.createElement('source');
            source.setAttribute('src', url);
            HTMLvideo.appendChild(source);
            HTMLvideo.load();
        }
        if(result.muzimaMediaType == 2){
            // setting Image

            var HTMLimage = document.getElementById("HTMLimage");
            HTMLimage.src = url;
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
    $scope.getUpdateURL = function () {
             return 'video/update.form';
    };

    $scope.update = function(file,media)
    {
        console.log("Uploading " + file + " " + media.uuid);
         FileUploadService.post({
                     url: $scope.getUpdateURL(),
                     file: file,
                     params:{ uuid: media.uuid}
                 }).success(function () {
                    $scope.editHtml = false;
                    getMedia($scope.uuid).then(setMedia).then(setUrl);
                 }).error(function (errorMessage) {
                     alert(errorMessage);
                 });

     };
      $scope.save = function(muzimamedia)
         {
            MediaService.saveTag(muzimamedia)
                    .then(function (result) {
                        $location.path('/list/videos');
                     })
          };
     var caseInsensitiveFind = function (tags, newTag) {
                return _.find(tags, function (tag) {
                    return angular.lowercase(tag.name) === angular.lowercase(newTag);
                });
            };
    $scope.saveTag = function (muzimamedia)
    {
        if (muzimamedia.newTag == "") return;
        var newTag = muzimamedia.newTag;
        var tagToBeAdded = caseInsensitiveFind($scope.tags, newTag) || {"name": newTag};
        muzimamedia.newTag = "";

        if (caseInsensitiveFind(muzimamedia.tags, tagToBeAdded.name)) return;
        muzimamedia.tags.push(tagToBeAdded);
        MediaService.saveTag(muzimamedia)
        .then(function (result) {
             return MediaService.get(muzimamedia.uuid);
         })
         .then(function (savedMedia) {
             angular.extend(muzimamedia, savedMedia.data);
         });
    };
    $scope.removeTag = function (media, tagToRemove)
    {
        angular.forEach(media.tags, function (tag, index) {
            if (tag.name == tagToRemove.name) {
                media.tags.splice(index, 1);
                MediaService.saveTag(media)
                    .then(function (result) {
                        return MediaService.get(media.uuid);
                    })
                    .then(function (savedMedia) {
                        angular.extend(media, savedMedia.data);
                    });
            }
        });
    };
    $scope.go = function(path){
            $location.path(path);
        };

 };
