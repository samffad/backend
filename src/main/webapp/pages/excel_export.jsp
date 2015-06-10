<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="zh">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>链家网-店面管理系统-利润、业绩、成本excel文件下载</title>
</head>
<body>
	<form action="/excelDown/perform" method="post" class="form-horizontal form">
	<input type="hidden" name="officeAddress" value="${orgSelected.officeAddress }">
		区/店组业绩、利润、负债excel文件下载<br/><br/>
		所选城市：${orgSelected.orgShortName } 
		<c:if test="${!enterSystemDirectly }">
			...<a href="login">[重新选择]</a>
		</c:if>
		<br/>
		选择类型：
		<input type="radio" name="type" value="1" checked="checked"/> 店组
		<input type="radio" name="type" value="2" /> 区<br/>
		<input type="radio" name="type" value="3" /> 店面详情<br/>
		请输入月份(格式：201501)： <input type="text" name="yearMonth" /><br/>
		<input type="submit" name="下载" />
	</form>
	<br/>
	财务上传后10分钟可以下载店组和区的表格。<br/>
	<br/>
	店面详情表需等待当天晚上系统跑数据后，第二天可以下载。当天下载的店面详情表，是依据前一天最后一次上传的成本数据而得出的。<br/>
</body>
</html>