<%@ tag import="java.util.Date" %>
<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag import="org.apache.commons.lang.StringUtils" %>
<%@tag pageEncoding="UTF-8" %>
<%@ attribute name="timestamp" type="java.lang.Long" required="true" %>
<%@ attribute name="pattern" type="java.lang.String" required="false" %>
<%
  if(timestamp <0)
    return;
  Date date = new Date(timestamp);
  String ptn = pattern;
  if(StringUtils.isBlank(ptn))
    ptn = "yyyy-MM-dd HH:mm:ss";
  SimpleDateFormat formatter = new SimpleDateFormat(ptn);
%><%=formatter.format(date)%>