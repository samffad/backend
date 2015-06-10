<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-content">
  <div class="modal-dialog">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
        class="sr-only">Close</span></button>
      <h3 class="modal-title" id="myModalLabel">run job "${tirggerName}"</h3>
    </div>
    <div class="modal-body">
      <form id="runJobForm" class="form-horizontal">
        <c:forEach var="map" items="${def.fieldDefs}" varStatus="index">
          <div class="form-group">
            <label class="col-md-4 control-label" for="${map.name}">${map.cname}</label>
            <div class="col-sm-8">
              <div class="input-group">
                <input title="${map.description}" id="${map.name}" name="${map.name}" type="text" class="form-control">
                <c:if test="${map.multiple}">
                  <span class="input-group-addon glyphicon glyphicon-plus" aria-hidden="true" multipleName="${map.name}" onclick="plusField(this,'${map.name}','${map.description}');"></span>
                </c:if>
              </div>
              <p class="help-block">${map.description}</p>
            </div>
          </div>
        </c:forEach>
        <div class="form-group">
          <div class="col-sm-12">
            <a class="btn btn-success" href="javascript:void(0);" onclick="runjob('${tirggerName}');">run</a>
            <button type="reset" class="btn btn-danger">reset</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>