<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css">
        <style>
            #keyword {
                display:inline-table;
            }
            @media (max-width: 768px)  {
                #keyword {
                    display:block;
                }
            }
            #submit > a {
                color:white;
                text-decoration:none;
            }
        </style>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <h4>게시판</h4>
                <div class="table-responsive">
                    <table id="mytable" class="table table-bordered table-hover col-sm-12">
                        <thead>
                        <th>번호</th>
                        <th>제목</th>
                        <th>글쓴이</th>
                        <th>등록일</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.list}" var="board">
                            <tr>
                                <td>${board.number}</td>
                                <td><a href="/board/view?id=${board.number}">${board.title}</a></td>
                                <td>${board.name}</td>
                                <td>${board.regdate}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div>
            <form class="form-inline" action="/board/list" method="get">
                <select name="search" class="form-control" id="inlineFormInput">
                    <option value="all">전체</option>
                    <option value="subject">제목</option>
                    <option value="content">내용</option>
                </select>

                <label class="sr-only" for="keyword">Username</label>
                <div class="input-group">
                    <input type="text" name="keyword" value="" class="form-control" id="keyword" placeholder="search...">
                </div>
                <button type="submit" class="btn btn-primary">검색</button>
                <div class="input-group">
                    <button id="submit" type="button" class="btn btn-primary">
                        <a href="/board/write">글쓰기</a>
                    </button>
                </div>
            </form>
            <ul class="pagination pull-right">
                <li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
                <li class="active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
            </ul>
        </div>
    </div>
    </div>
    </div>
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    </body>
</html>
