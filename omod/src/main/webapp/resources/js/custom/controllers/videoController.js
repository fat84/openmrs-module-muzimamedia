'use strict';
function videoCtrl($scope, $window, MediaService)
{
    $scope.muzimaVideos;
    $scope.init = function () {
        $scope.editMode = false;
        getMedia().then(setMedia)
    };

    var getMedia= function(){
        return MediaService.all();
    };
    var setMedia = function(result){
        console.log(result.data.results);
        $scope.muzimaVideos = result.data.results;
    };

    var caseInsensitiveFind = function (tags, newTag) {
            return _.find(tags, function (tag) {
                return angular.lowercase(tag.name) === angular.lowercase(newTag);
            });
        };

    $scope.saveTag = function (muzimamedia) {
            if (muzimamedia.newTag === "") return;
            var newTag = muzimaform.newTag;
            var tagToBeAdded = caseInsensitiveFind($scope.tags, newTag) || {"name": newTag};
            muzimamedia.newTag = "";

            if (caseInsensitiveFind(muzimamedia.tags, tagToBeAdded.name)) return;
            form.tags.push(tagToBeAdded);
            MediaService.save(muzimamedia);
        };
}

