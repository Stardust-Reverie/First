<%--
  Created by IntelliJ IDEA.
  User: 836365689
  Date: 2020/10/23
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
<%--<%@ include file="header.jsp"%>--%>
<h1>
    <%!
        String name = "朱晓东";
    %>
    <%
        out.print("<h1>我小弟是 "+name+"</h1>");
    %>
</h1>
<a href="http://www.baidu.com">
    <img src="a.jpg"/>
</a>
<jsp:include page="footer.jsp" flush="true"/>
<%--<%@ include file="footer.jsp"%>--%>
</body>
</html>
