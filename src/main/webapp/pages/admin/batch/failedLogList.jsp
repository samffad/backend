<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="activebar" content="log">
  <title>Job Log List</title>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/admin/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="title.jsp" %>
<div class="container" style="margin-top:100px; width:95%">

  <div class="starter-template">
    <h1>Job Failed Log</h1>
  </div>
  <div class="bs-example">
    <c:forEach var="map" items="${list}" varStatus="index">
      <blockquote>
        <h2>error info ${index.index+1}</h2>
        <p><strong>id</strong></p>
        <pre>${map.pkid}</pre>
        <p><strong>logId</strong></p>
        <pre>${map.logId}</pre>
        <p><strong>parameter</strong></p>
        <pre>${map.objectId}</pre>
        <p><strong>createdTime</strong></p>
        <pre><fmt:formatDate value="${map.createdTime}" pattern="yyyyMMdd HH:mm:ss"></fmt:formatDate></pre>
        <p><strong>info</strong></p>
        <pre>${map.info}</pre>
        <p><strong>triggerName</strong></p>
        <pre>${map.triggerName}</pre>
        <p><strong>jobName</strong></p>
        <pre>${map.jobName}</pre>
      </blockquote>
    </c:forEach>
  </div>
  <!-- /example -->
</div>
<!-- /.container -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/jquery.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/nav.active.js"></script>
</body>
</html>
