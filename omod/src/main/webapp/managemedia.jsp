<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>


<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/animate/animate.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/bootstrap/css/bootstrap.min.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/openmrs2.0/index.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/openmrs2.0/openmrs.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/custom/custom.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/font-awesome/css/font-awesome.min.css"/>

<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/jquery/jquery.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/underscore/underscore-min.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/bootstrap/js/bootstrap.min.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/angular/angular.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/angular/angular-resource.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/angular/angular-sanitize.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/angular/ui-bootstrap-0.3.0.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/angular/angular-strap.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/filters.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/app.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/controllers/videoController.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/controllers/ImportController.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/directives/fileUpload.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/controllers/viewController.js"/>
<div ng-app="muzimamedia">
    <div class="row-fluid">
            <div class="col-lg-12">
                <div ng-view></div>
            </div>
    </div>
</div>
