<%@ include file="/WEB-INF/template/include.jsp"%>
<%@ include file="/WEB-INF/template/header.jsp"%>

<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/font-awesome/css/font-awesome.min.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/animate/animate.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/bootstrap/css/bootstrap.min.css"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/styles/custom/custom.css"/>

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
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/controllers/XFormsController.js"/>
<openmrs:htmlInclude file="/moduleResources/muzimamedia/js/custom/directives/fileUpload.js"/>

<div ng-app="muzimamedia">
    <div class="navbar navbar-inverse navbar-custom">
            <div>
                <a class="navbar-brand" href="#/list/videos" style="color: #ffffff; font-size: 20px"><i class="icon-home"></i></a>
                <a href="#/import/video" class="pull-right">
                        <button type="button" class="btn btn-success navbar-btn"> Upload </button>
                </a>
            </div>
        </div>
    <div class="row-fluid">
            <div class="col-lg-12">
                <div ng-view></div>
            </div>
    </div>
</div>

<%@ include file="/WEB-INF/template/footer.jsp"%>