'use strict';
function ImportCtrl($scope, $window, $location, FileUploadService)
{
     $scope.mediaTags = [];
     $scope.tagColorMap = {};
     $scope.newTag = "";
    var showErrorMessage = function (content, cl, time) {
              $('<div/>')
                  .addClass('alert')
                  .addClass('alert-error')
                  .hide()
                  .fadeIn('slow')
                  .delay(time)
                  .appendTo('#error-alert')
                  .text(content);
     };

     $scope.upload = function(file, title, version, description, tags){
     console.log("Uploading " + title + " " +version +" "+ description + " "+ file + " " + tags);
     FileUploadService.post({
                 url: $scope.getUploadURL(),
                 file: file,
                 params:{ title: title, description: description || "", version: version || "", tags : tags}
             }).success(function () {
                 $location.path("#/list/videos");
             }).error(function (errorMessage) {
                 showErrorMessage(errorMessage);
             });

     };
     $scope.getUploadURL = function () {
         return 'video/upload.form';
     };
     $scope.hasFile = function () {
             return ($scope.file) ? true : false;
     };
     $scope.cancel = function () {
         if ($scope.clearFile) $scope.clearFile();
     };
     $scope.AddTag = function(newTag){

        $scope.mediaTags.push(newTag);
        $scope.newTag = "";
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
    $scope.removeTag = function(tag){
        $scope.mediaTags.pop(tag);
    };
    $scope.go = function(path){
        $location.path(path);
    }
}

