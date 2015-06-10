<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>链家网-店面管理系统</title>
<link href="<c:url value="/resources/sms/dep/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet" media="screen">
<script type="text/javascript" src="<c:url value="/resources/admin/js/jquery.min.js"/>"></script>
<style type="text/css">
.form{
	width:500px;
	margin:0 auto;
	padding:30px 0;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${roles==null || roles.size()==0}">
			<p class="text-center"> 对不起，您没有权限登录。
			<a href="${logoutUrl}">重新登录</a>,
			<a href="http://se.homelink.com.cn"> 登录SE</a>
			<p>
		</c:when>
		<c:otherwise>
			<form action="login" method="post" class="form-horizontal form">
			<fieldset>
				<legend>请选择登录角色</legend>
				<p>
					<c:forEach items="${roles}" var="role" varStatus="status">
					<label class="radio inline">
						<input type="radio" name="roleIdSelected" value="${role.id}" <c:if test="${status.first}">checked="checked"</c:if> >${role.desc}
				    </label>
					</c:forEach>
				</p>
				<c:forEach items="${roles}" var="role" varStatus="status">
					<p name="orgDivName" id="orgDivId_${role.id}" <c:if test="${!status.first}">style="display: none;"</c:if> >
						<c:choose>
							<c:when test="${couldSelectOrg[role]}">
					 			输入组织编码: <input type="text" name="orgCodeInput" class="input-medium"  <c:if test="${!status.first}">disabled="disabled"</c:if> ><br/>
					 			或输入组织ID: <input type="text" name="orgIdInput" class="input-medium" <c:if test="${!status.first}">disabled="disabled"</c:if>>
							</c:when>
							<c:when test="${roleOrgs[role]!=null && roleOrgs[role].size()>0}">
								请选择作业范围：
					 			<c:forEach items="${roleOrgs[role]}" var="org" varStatus="orgStatus">
									<label class="radio">
									<input type="radio" name="orgIdSelected" value="${org.orgId}" <c:if test="${orgStatus.first}">checked="checked"</c:if> <c:if test="${!status.first}">disabled="disabled"</c:if>> ${org.orgShortName}
									</label>
								</c:forEach>
							</c:when>
							<c:when test="${role.id==0}">
								<%-- <a href="admin/userRolesList">角色与权限管理</a><br/> --%>
								<a href="admin/toMentorAdd">添加师徒关系</a><br/>
								<%-- 输入组织编码: <input type="text" name="orgCodeInput" class="input-medium" <c:if test="${!status.first}">disabled="disabled"</c:if>><br/>
					 			或输入组织ID: <input type="text" name="orgIdInput" class="input-medium" <c:if test="${!status.first}">disabled="disabled"</c:if>> --%>
							</c:when>
						</c:choose>
					</p>
				</c:forEach>
				<p class="text-center"><input type="submit" class="btn" value="提交"></p>
			</fieldset>
			</form>
		</c:otherwise>
	</c:choose>
<script type="text/javascript">
$(function(){
	$("input[name='roleIdSelected']").bind('click',function(e){
     	var id = $(this).val();
     	var divShowId = "orgDivId_"+id;
     	$("p[name='orgDivName']").hide();
     	$("p[name='orgDivName'] input").attr("disabled",true);
     	
     	$("#"+divShowId).show();
     	$("#"+divShowId+" input").attr("disabled",false);
    });
});
</script>
</body>
</html>