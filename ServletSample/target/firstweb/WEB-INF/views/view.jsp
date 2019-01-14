<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>write</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <style>
        #article-heading {
            padding:24px; border-bottom:1px solid #ddd;
        }
        .article-subject {
            margin:0px;
            padding:5px;
        }
        .article-name {
            text-align:right;
        }
        .article-name > span {
            padding:0px 5px 0px 5px;
        }
        .article-footer {
            float:right;
        }
        #main-content {
            line-height:25px;
            border:none;
        }
    </style>
</head>
<body>
<div class="container" style="margin-top:20px;">
    <div class="row-fluid">
        <div class="col-sm-12 col-sm-offset-0 toppad" >
            <div class="panel panel-default">
                <div id="article-heading">
                    <h3 class="article-subject">${list.title}</h3>
                    <div class="article-name">
                        <span>${list.name}</span>
                        <span>${list.regdate}</span>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td id="main-content">
                                        ${list.content}
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="article-footer">
                                <a href="/board/list" class="btn btn-primary">목록</a>
                                <a href="/board/modify" class="btn btn-primary">수정</a>
                                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#check">삭제</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="check" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                <h3 class="modal-title" id="lineModalLabel">확인</h3>
            </div>
            <div class="modal-body">

                <!-- content goes here -->
                <form>
                    <div class="form-group">
                        <label for="InputName">이름</label>
                        <input type="text" class="form-control" id="InputName" placeholder="이름">
                    </div>
                    <div class="form-group">
                        <label for="InputPassword">비밀번호</label>
                        <input type="password" class="form-control" id="inputPassword" placeholder="비밀번호">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="btn-group btn-group-justified" role="group" aria-label="group button">
                    <div class="btn-group" role="group">
                        <button type="button" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">전송</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>