<!-- 페이지 지시문 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
    <h1>hello</h1>
    <%
        for(int i=0; i<99; i++) {
            out.write("i는 : "+i+"<br/>");
        }
    %>
</body>
</html>
