'use strict';
function ImportCtrl($scope, $window, $location, FileUploadService)
{
     $scope.upload = function(file, title, version, description){
     console.log("Uploading " + title + " " +version +" "+ description + " "+ file);
     FileUploadService.post({
                 url: $scope.getUploadURL(),
                 file: file,
                 params:{ title: title, description: description || "", version: version }
             }).success(function () {
                 $location.path("#/list/videos");
             }).error(function (errorMessage) {
                 alert(errorMessage);
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
}

