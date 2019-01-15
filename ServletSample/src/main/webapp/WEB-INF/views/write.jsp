<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>write</title>
    <style>
        .my-form {
            margin-top:20px;
        }
        #list > a {
            color:white;
            text-decoration:none;
        }
    </style>
    <%@include file="navbar.jsp"%>
    </head>
    <body>
    <main class="my-form">
    <div class="container">
        <div class="row justify-content-center" >
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-header">글쓰기</div>
                    <div class="card-body">
                        <div class="card-body-center">
                            <form name="my-form" action="/write" method="post">
                                <div class="form-group row">
                                    <label for="present_address" class="col-md-2 col-form-label text-md-right">아이디</label>
                                    <div class="col-md-9">
                                        <c:if test="${mode eq 'modify'}">
                                            <input type="hidden" name="mode" value="${mode}"/>
                                            <input type="hidden" name="seq" value="${seq}" />
                                            <input type="text" name="userID" id="present_address" value="${board.userID}" class="form-control" readonly>
                                        </c:if>
                                        <c:if test="${mode ne 'modify'}">
                                            <input type="hidden" name="mode" value="write"/>
                                            <input type="text" name="userID" id="present_address" value="${board.userID}" class="form-control">
                                        </c:if>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="title" class="col-md-2 col-form-label text-md-right">제목</label>
                                    <div class="col-md-9">
                                        <input type="text" name="title" id="title" value="<c:if test="${mode eq 'modify'}">${board.title}</c:if>" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="content" class="col-md-2 col-form-label text-md-right">내용</label>
                                    <div class="col-md-9">
                                        <textarea class="form-control" name="content" id="content" rows="8"><c:if test="${mode eq 'modify'}">${board.content}</c:if></textarea>
                                    </div>
                                </div>
                        <div class ="d-flex flex-row-reverse">
                            <div class="d-flex flex-row-reverse">
                                <button type="submit" class="btn btn-primary">
                                    등록
                                </button>
                                <button id="list" type="button" class="btn btn-primary">
                                    <a href="/list">목록</a>
                                </button>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
