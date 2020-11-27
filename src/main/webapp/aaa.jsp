<%--
  Created by IntelliJ IDEA.
  User: 836365689
  Date: 2020/10/30
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



    <%
        String i = request.getParameter("i");
        out.print(i);
//        i = Integer.valueOf(i);
    %>

<%!
    int x = 7;
%>

    <%
        if (Integer.parseInt(i) % 2 == 0){
    %>

    <h1>偶数</h1>

    <%
    }else {
    %>

    <h1>奇数</h1>

    <%
        }
    %>


    <%
        do {

        }while (x > 10);


    %>





<%--    <jsp:forward page="index.jsp"></jsp:forward>--%>
</body>
</html>
