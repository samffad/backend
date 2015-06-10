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
	<div style="margin:5px 10px 20px 30px;"><h4>权限管理</h4></div>
	
	<div style="margin:5px 10px 20px 30px;">
		<form action="<c:url value='/admin/userRolesAddOrUpdate'/>" method="post">
		<input type="hidden" name="userRoles4UpdateId" value="${userRoles4Update.id }">
		
		<table width="50%" border="1" class="t1">
			<c:choose>
					<c:when test="${userRoles4Update!=null}">
					<thead><h4>修改用户权限【${userRoles4Update.userName}】</h4></thead>
					</c:when>
					<c:otherwise>
					<thead><h4>添加用户权限</h4></thead>
					</c:otherwise>
			</c:choose>
			
			<tr>
			<td width="20%">用户系统号：</td>
			<td><input type="text" name="userCode" value="${userRoles4Update.userCode }" <c:if test="${userRoles4Update!=null}">readonly="readonly"</c:if> ></td>
			</tr>
			
			<tr >
			<td>选择权限</td>
			<td>
				<c:forEach items="${roles}" var="role" varStatus="status">
				<label><input name="roleSelected" type="checkbox" value="${role.id}"  <c:if test="${userRoles4Update!=null && userRoles4Update.roleEnums[role]!=null}">checked="checked"</c:if> >${role.desc} </label>
				</c:forEach>
			</td>
			</tr>
			
			<tr>
			<td>权限附加信息(已无效)：</td>
			<td><input type="text" name="rolesAddition" value="${userRoles4Update.rolesAddition }" ></td>
			</tr>
			
			<tr>
			<td>
			<c:choose>
				<c:when test="${userRoles4Update!=null}">
				<input type="submit" value="更新">
				</c:when>
				<c:otherwise>
				<input type="submit" value="添加">
				</c:otherwise>
			</c:choose>
				
			</td>
			<td>
			<span style="color:red">${userRolesAddOrUpRst }</span>
			</td>
			</tr>
		</table>
		</form>

	</div>
	<div style="margin:5px 10px 20px 30px;">
		<div><h4>用户角色列表</h4></div>
		<div>
		<form action="<c:url value='/admin/userRolesList'/>">
		<table>
			<tr> 
			<td>系统号：<input type="text" name="userCodeSearch"> </td>
			<td><input type="submit" value="搜索"> </td>
			</tr>
		</table>
		</form>
		</div>
		<div>
		<table  width="90%" border="1" class="t1">
		<thead>
				<th width="8%">用户名</th>
				<th width="8%">系统号</th>
				<th width="8%">简称</th>
				<th>所有角色</th>
				<th width="8%">操作人</th>
				<th width="10%">操作时间</th>
				<th width="6%">操作</th>
				<th width="6%">配置店组</td>
		</thead>
		<c:forEach items="${list}" var="userRole" varStatus="status">
		<tr>
			<td>${userRole.userName}</td>
			<td>${userRole.userCode}</td>
			<td>${userRole.userShort}</td>
			<td>
				<c:forEach items="${userRole.roleEnums}" var="roleEnum" varStatus="status">
					${roleEnum.key.desc }
					<c:if test="${!status.last}">;</c:if>
				</c:forEach>
			</td>
			<td>${userRole.operCode}</td>
			<td>${userRole.operDate}</td>
			<td>
			<a onclick="return confirm('确定将此记录删除?')" href="<c:url value='/admin/userRolesDelete?id=${userRole.id}'/>">删除</a>
			<a href="<c:url value='/admin/userRolesList?id4Update=${userRole.id}'/>">修改</a>
			
			</td>
			<td>
			<c:if test="${userRole.roleEnumsDB!=null && fn:length(userRole.roleEnumsDB)>0 }">
				<a href="<c:url value='/admin/orgPermissionList?userCode=${userRole.userCode}'/>">配置</a>
			</c:if> 
			</td>
		</tr>
		</c:forEach>
			
		</table>
		</div>
	</div>
	
</body>
</html>