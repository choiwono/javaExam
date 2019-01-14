<%--
  Created by IntelliJ IDEA.
  User: 최원오
  Date: 2019-01-09
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>write</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <style>
        .my-form {
            margin-top:20px;
        }
        #list > a {
            color:white;
            text-decoration:none;
        }
    </style>
    </head>
    <body>
    <main class="my-form">
    <div class="container">
        <div class="row justify-content-center" >
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">글쓰기</div>
                    <div class="card-body">
                        <div class="card-body-center">
                            <form name="my-form" action="/board/write" method="post">
                                <div class="form-group row">
                                    <label for="name" class="col-md-2 col-form-label text-md-right">이름</label>
                                    <div class="col-md-9">
                                        <input type="text" id="name" name="name" value="" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="present_address" class="col-md-2 col-form-label text-md-right">암호</label>
                                    <div class="col-md-9">
                                        <input type="password" name="password" id="present_address" value="" class="form-control">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="title" class="col-md-2 col-form-label text-md-right">제목</label>
                                    <div class="col-md-9">
                                        <input type="text" name="title" id="title" class="form-control">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="name" class="col-md-2 col-form-label text-md-right">내용</label>
                                    <textarea class="col-md-9" name="content" id="exampleFormControlTextarea1" rows="8"></textarea>
                                </div>
                        <div class ="d-flex flex-row-reverse">
                            <div class="d-flex flex-row-reverse">
                                <div class="p-2">
                                    <button type="submit" class="btn btn-primary">
                                        등록
                                    </button>
                                </div>
                                <div class="p-2">
                                    <button id="list" type="button" class="btn btn-primary">
                                        <a href="/board/list">목록</a>
                                    </button>
                                </div>
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
