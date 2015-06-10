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
  <meta name="activebar" content="list">
  <title>Trigger List</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/admin/bootstrap/dist/css/bootstrap.min.css"
        rel="stylesheet">
  <script type="text/javascript">

  </script>
</head>

<body>
<%@include file="title.jsp" %>
<div class="container text-center" style="margin-top:100px; width:95%">
  <div class="starter-template">
    <h1>Trigger List</h1>
  </div>
  <div class="bs-example">
    <table class="table table-hover table-bordered ">
      <thead>
      <tr>
        <th class="text-center">序号</th>
        <th class="text-center">
          Trigger 名称
        </th>
        <th class="text-center">
          名称
        </th>
        <th class="text-center">
          下次执行时间
        </th>
        <th class="text-center">
          优先级
        </th>
        <th class="text-center">
          Trigger 状态
        </th>
        <th class="text-center">
          Trigger 类型
        </th>
        <th class="text-center">
          开始时间
        </th>
        <th class="text-center">
          结束时间
        </th>
        <th class="text-center">
          动作命令
        </th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="map" items="${list}" varStatus="index">
        <tr>
          <td>
              ${index.index+1}
          </td>
          <td>
            <a href="${pageContext.request.contextPath}/admin/batch/log/${map.trigger_name}">
                ${map.trigger_name}
            </a>
          </td>
          <td>
              ${map.description}
          </td>
          <td>
            <cust:timestamp timestamp="${map.next_fire_time}"/>
          </td>
          <td>
              ${map.priority}
          </td>
          <td>
              ${map.trigger_state}
          </td>
          <td>
              ${map.trigger_type}
          </td>
          <td>
            <cust:timestamp timestamp="${map.start_time}"/>
          </td>
          <td>
            <c:if test="${map.end_time!=null && map.end_time > 0}">
              <cust:timestamp timestamp="${map.end_time}"/>
            </c:if>
          </td>
          <td>
            <a
              <c:choose>
              <c:when test="${map.trigger_state eq 'PAUSED'}">href="javascript:void(0);"
              class="btn btn-info btn-sm disabled"</c:when>
              <c:otherwise>href="/admin/batch/pause/${map.trigger_name}" class="btn btn-primary btn-sm"</c:otherwise>
            </c:choose>
              >暂停</a>
            <a
              <c:choose>
              <c:when test="${!(map.trigger_state eq 'PAUSED')}">href="javascript:void(0);"
              class="btn btn-info btn-sm disabled"</c:when>
              <c:otherwise>href="/admin/batch/resume/${map.trigger_name}" class="btn btn-primary btn-sm"</c:otherwise>
            </c:choose>
              >恢复</a>
            <input id="a_${index.index+1}" type="button" id="run" value="手动"
                   class="btn btn-primary btn-sm"
                   onclick="openjob('${map.trigger_name}')">
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" aria-hidden="true"></div>
<!-- /.container -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/jquery.min.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/resources/admin/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/jquery.blockUI.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/admin/js/nav.active.js"></script>

<script type="text/javascript">
  (function($){
    $.fn.serializeJson=function(){
      var serializeObj={};
      var array=this.serializeArray();
      $(array).each(function(){
        if(serializeObj[this.name]){
          if($.isArray(serializeObj[this.name])){
            serializeObj[this.name].push(this.value);
          }else{
            serializeObj[this.name]=[serializeObj[this.name],this.value];
          }
        }else{
          serializeObj[this.name]=this.value;
        }
      });
      return serializeObj;
    };
  })(jQuery);

  function openjob(triggerName) {
    $('#myModal').data("triggerName", triggerName);
    $('#myModal').modal("show");
  }

  function plusField(field,fieldName,desc){
    var tmp = '<div class="input-group"><input title="'+desc+'" name="'+fieldName+'" type="text" class="form-control">'+
    '<span class="input-group-addon glyphicon glyphicon-minus" aria-hidden="true" onclick="minusField(this);"></span></div>';

    $(field).parent().parent().append(tmp);
  }

  function minusField(field){
    $(field).parent().remove();
  }


  $(function () {
    $('#myModal').on("hidden.bs.modal", function () {
      $("#myModal").html("");
    });
    $('#myModal').on("show.bs.modal", function () {
      $.ajax({
        type: "POST",
        cache: false,
        url: "${pageContext.request.contextPath}/admin/batch/openJob/" + $('#myModal').data("triggerName"),
        success: function (data) {
          $("#myModal").html(data);
        }
      });

    });
  });

  function runjob(triggerName) {
    $("#myModal").modal('hide');

    var data = $("#runJobForm").serializeJson();
    $("#runJobForm span.glyphicon-plus").each(function(){
      var fieldName = $(this).attr("multipleName");
      if(!data[fieldName] || !$.isArray(data[fieldName])){
        var val = data[fieldName];
        data[fieldName] = [];
        if(val){
          data[fieldName].push(val);
        }
      }
    });

    $.ajax({
      type: "POST",
      cache: false,
      url: "${pageContext.request.contextPath}/admin/batch/runjob/" + triggerName,
      data: {
        json: JSON.stringify(data)
      },
      beforeSend: function () {
        $.blockUI({message: "job running ..."});
      },
      complete: function () {
        $.unblockUI();
      },
      success: function (data) {
        alert(data.msg);
      }
    });
  }
</script>
</body>
</html>
