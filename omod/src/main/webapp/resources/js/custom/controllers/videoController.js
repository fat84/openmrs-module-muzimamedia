'use strict';
function videoCtrl($scope, $window, $location, MediaService, TagService)
{
    $scope.muzimaVideos;
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
    var caseInsensitiveFind = function (tags, newTag) {
            return _.find(tags, function (tag) {
                return angular.lowercase(tag.name) === angular.lowercase(newTag);
            });
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
    $scope.saveTag = function (muzimamedia) {
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
                 if (!tagToBeAdded.id)
                     getTags().then(setTags);
             });
        };
    $scope.removeTag = function (media, tagToRemove) {
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
    $scope.remove = function (muzimamedia) {
            muzimamedia.voided = true;
            MediaService.remove(muzimamedia)
                .then(function () { });
        };
    $scope.viewMedia = function(muzimamedia){
        $location.path("/list/view/"+muzimamedia.uuid);
    }

}

