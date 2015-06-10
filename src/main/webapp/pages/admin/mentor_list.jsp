<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链家网-店面管理系统</title>
<script type="text/javascript" src="<c:url value="/resources/admin/js/jquery.min.js"/>"></script>

<style type="text/css">
body,table{
    font-size:15px;
}
table{
    table-layout:fixed;
    empty-cells:show; 
    border-collapse: collapse;
}
td{
    height:30px;
}

table.t1{
    border:1px solid #cad9ea;
    color:#666;
}
table.t1 th {
    background-repeat::repeat-x;
    height:40px;
}
table.t1 td,table.t1 th{
    border:1px solid #cad9ea;
    padding:0 1em 0;
}
</style>
</head>
<body>
	<div style="margin:5px 10px 20px 30px;"><h4>添加师徒关系</h4> <a href="<c:url value='/login'/>">返回</a></div>
	
	<div style="margin:5px 10px 20px 30px;">
		<form action="<c:url value='/admin/mentorAdd'/>" method="post">
	
		<table width="50%" border="1" class="t1">
			<tr>
			<td width="20%">选择分公司：</td>
			<td>
			<select name="officeAddress">
				<c:forEach items="${orgs4Select}" var="org" varStatus="status">
					<option value="${org.officeAddress }">${org.orgShortName }</option>
				</c:forEach>
			</select>
			</td>
			</tr>
										
			<tr>
			<td width="20%">师傅系统号：</td>
			<td><input type="text" name="mentor" ></td>
			</tr>
			
			<tr>
			<td width="20%">徒弟系统号：</td>
			<td><input type="text" name="apprentice" ></td>
			</tr>
			
			<tr>
			<td>
				<input type="submit" value="添加">
			</td>
			<td>
			<span style="color:red">${addRst}</span>
			</td>
			</tr>
		</table>
		</form>

	</div>
	
</body>
</html>