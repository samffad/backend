<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="cust" tagdir="/WEB-INF/tags" %>
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
<div class="container text-center" style="margin-top:100px; width:95%">

  <div class="starter-template">
    <h1>Job Log</h1>
  </div>
  <form id="searchForm" class="navbar-form navbar-left" method="post">
    <input id="pageNo" type="hidden" name="pageNo" value="1"/>

    <div class="form-group">
      <select id="triggerName" name="triggerName" class="form-control">
        <option value="ALL">All</option>
        <c:forEach var="map" items="${nameList}" varStatus="index">
          <option value="${map}" <c:if test="${map==triggerName}"> selected="selected" </c:if> >${map}</option>
        </c:forEach>
      </select>
    </div>
    <div class="form-group">
      <select name="runType" class="form-control">
        <option value="">All</option>
        <option value="1" <c:if test="${dto.runType==1}"> selected="selected" </c:if> >自动</option>
        <option value="0" <c:if test="${dto.runType==0}"> selected="selected" </c:if>>手动</option>
      </select>
    </div>
    <div class="form-group">
      <select name="state" class="form-control">
        <option value="">All</option>
        <option value="1" <c:if test="${dto.state==1}"> selected="selected" </c:if> >成功</option>
        <option value="0" <c:if test="${dto.state==0}"> selected="selected" </c:if>>失败</option>
      </select>
    </div>
    <a href="javascript:void(0);" onclick="submitForm();" class="btn btn-default">Search</a>
  </form>
  <div class="bs-example">
    <table class="table table-hover table-bordered ">
      <thead>
      <tr>
        <th class="text-center">NO</th>
        <th class="text-center">
          ID
        </th>
        <th class="text-center">
          TRIGGER NAME
        </th>
        <th class="text-center">
          TRIGGER GROUP
        </th>
        <th class="text-center">
          JOB NAME
        </th>
        <th class="text-center">
          START TIME
        </th>
        <th class="text-center">
          END TIME
        </th>
        <th class="text-center">
          ENTRY ID
        </th>
        <th class="text-center">
          STATUS
        </th>
        <th class="text-center">
          TYPE
        </th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="map" items="${page.content}" varStatus="index">
        <tr>
          <td>
              ${index.index+1}
          </td>
          <td>
              ${map.pkid}
          </td>
          <td>
              ${map.triggerName}
          </td>
          <td>
              ${map.triggerGroup}
          </td>
          <td>
              ${map.jobName}
          </td>
          <td>
            <fmt:formatDate value="${map.startTime}" pattern="yyyyMMdd HH:mm:ss"/>
          </td>
          <td>
            <fmt:formatDate value="${map.endTime}" pattern="yyyyMMdd HH:mm:ss"/>
          </td>
          <td>
              ${map.entryId}
          </td>
          <td>
            <c:if test="${map.state==2}">
              <a href="${pageContext.request.contextPath}/admin/batch/failLog/${map.pkid}" target="_blank">warn</a>
            </c:if>
            <c:if test="${map.state==1}">success</c:if>
            <c:if test="${map.state==0}">
              <a href="${pageContext.request.contextPath}/admin/batch/failLog/${map.pkid}" target="_blank">failure</a>
            </c:if>
          </td>
          <td>
            <c:if test="${map.runType==1}">自动</c:if>
            <c:if test="${map.runType==0}">手动</c:if>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <ul class="pager">
      <li>共${page.totalCount}条记录</li>
      <li>共${page.totalPages}页</li>
      <li>当前第${dto.pageNo}页</li>
      <li <c:if test="${dto.pageNo==1}">class="disabled" </c:if>><a
        <c:if test="${dto.pageNo!=1}">onclick="goPage(${dto.pageNo}-1)" </c:if> href="#">Previous</a></li>
      <li <c:if test="${dto.pageNo==page.totalPages}">class="disabled" </c:if>><a
        <c:if test="${dto.pageNo!=page.totalPages}">onclick="goPage(${dto.pageNo}+1)" </c:if> href="#">Next</a></li>
    </ul>
  </div>
  <!-- /example -->
</div>
<!-- /.container -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/jquery.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/nav.active.js"></script>

<script type="text/javascript">

  function goPage(pageNo) {
    $("#pageNo").val(pageNo);
    submitForm();
  }

  function submitForm() {
    $("#searchForm").attr("action", "${pageContext.request.contextPath}/admin/batch/log/" + $("#triggerName").val());
    $("#searchForm").submit();
  }
</script>
</body>
</html>
