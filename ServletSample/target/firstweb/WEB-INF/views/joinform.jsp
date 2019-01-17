<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>회원 가입 폼</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h1>회원가입폼</h1>
<form method="post" action="/join">
    name : <input type="text" name="name" size="20"><br>
    nickname : <input type="text" name="nickname" size="20"><br>
    email : <input type="text" name="email" size="20"><br>
    password : <input type="password" name="passwd1" size="20"><br>
    password 확인 : <input type="password" name="passwd2" size="20"><br>
    <input type="submit">
</form>
<h3>${error}</h3>
</body>
</html>