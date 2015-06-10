<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div style="margin:5px 10px 20px 30px;"><h4>配置组织</h4>  <a href="userRolesList">返回</a> </div>
	
	<div style="margin:5px 10px 20px 30px;">
		<form action="<c:url value='/admin/orgPermissionAdd'/>" method="post">
		<input type="hidden" name="userCode" value="${userCode }">
		
		<table width="40%"  border="1" class="t1">
			<thead><h4>为用户[${userCode }] 配置组织</h4></thead>
			<tbody>
				<tr>
					<td width="30%">选择权限</td>
					<td>
						<select name="roleSelected">
							<c:forEach items="${rolesNeedSetDB}" var="role" varStatus="status">
								<option value="${role.id }">${role.desc }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>选择或输入组织编码</td>
					<td>
					<c:forEach items="${rolesNeedSetDB}" var="role" varStatus="status">
						<div name="rolesNeedSetDBDiv" id="rolesNeedSetDBDiv_${role.id }" <c:if test="${!status.first}">style="display: none;"</c:if> >
							<c:choose>
									<c:when test="${roleOrgs4Select!=null && roleOrgs4Select[role]!=null && roleOrgs4Select[role].size()>0}">
										<select name="orgCodeSelect">
											<c:forEach items="${roleOrgs4Select[role]}" var="org" varStatus="status">
												<option value="${org.orgCode }">${org.orgShortName }</option>
											</c:forEach>
										</select>
									</c:when>
									<c:otherwise>
										<input type="text" name="orgCodeInput">
									</c:otherwise>
							</c:choose>
						</div>
					</c:forEach>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" value="添加">
					</td>
					<td>
					<span style="color:red">${orgPermissionAddRst }</span>
					</td>
				</tr>
			</tbody>
		</table>
		</form>

	</div>
	<div style="margin:5px 10px 20px 30px;">
		<div><h4>为用户[${userCode }] 配置的店组列表</h4></div>
		<div>
		<table  width="70%" border="1" class="t1">
		<thead>
			<th width="15%">配置角色</th>
			<th>店组名称</th>
			<th width="8%">店组编码</th>
			<th width="8%">操作人</th>
			<th width="15%">操作时间</th>
			<th width="8%">操作</th>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item" varStatus="status">
			<tr>
				<td>${item.roleEnum.desc}</td>
				<td>${item.orgName}</td>
				<td>${item.orgCode}</td>
				<td>${item.operCode}</td>
				<td>${item.operDate}</td>
				<td><a onclick="return confirm('确定将此记录删除?')" href="<c:url value='/admin/orgPermissionDelete?id=${item.id}&userCode=${userCode }'/>">删除</a></td>
			</tr>
			</c:forEach>
			
		</tbody>
		</table>
		</div>
	</div>
	
<script type="text/javascript">
$(function(){
	$("select[name='roleSelected']").bind('change',function(e){
     	var id = $(this).val();
     	var divShowId = "rolesNeedSetDBDiv_"+id;
     	$("div[name='rolesNeedSetDBDiv']").hide();
     	$("div[name='rolesNeedSetDBDiv'] input").attr("disabled",true);
     	$("div[name='rolesNeedSetDBDiv'] select").attr("disabled",true);
     	
     	$("#"+divShowId).show();
     	$("#"+divShowId+" input").attr("disabled",false);
     	$("#"+divShowId+" select").attr("disabled",false);
    });
});
</script>
</body>
</html>