<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Quartz Job</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul id="navBar" class="nav navbar-nav">
                <li id="nav_list" class="active"><a href="${pageContext.request.contextPath}/admin/batch/list">Home</a></li>
                <li id="nav_log"><a href="${pageContext.request.contextPath}/admin/batch/log/ALL">Logs</a></li>
            </ul>
        </div>
    </div>
</div>


