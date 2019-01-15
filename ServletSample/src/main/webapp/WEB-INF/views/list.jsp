<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <title>Title</title>

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
            #pagenation {
                display: table;
                margin-left: auto;
                margin-right: auto;
            }
            #pagenation > ul {
                display:flex;
            }
            #point-btn {
                height:34px;
            }
            .page-link > a {
                height:34px;
            }
        </style>
        <%@include file="navbar.jsp"%>
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
                        <th>조회수</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.boards}" var="board">
                            <tr>
                                <td>${board.seq}</td>
                                <td><a href="/view?seq=${board.seq}&page=${page}">${board.title}</a></td>
                                <td>${board.userName}</td>
                                <td>${board.regDate}</td>
                                <td>${board.hit}</td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div>
            <form class="form-inline" action="/list" method="get">
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
                        <a href="/write">글쓰기</a>
                    </button>
                </div>
            </form>
            <nav id="pagenation" aria-label="Page navigation example">
                <ul style="display:flex;" class="pagination justify-content-end">
                    <li <c:if test="${page-1 eq 0}">class="page-item disabled"</c:if>>
                        <a id="point-btn" class="page-link" href="/list?page=${page-1}"><span class="glyphicon glyphicon-chevron-left"></span></a>
                    </li>

                    <c:forEach var="i" begin="1" end="${totalPage}">
                        <li <c:if test="${i eq page}">class="page-item active"</c:if>>
                            <a class="page-link" href="/list?page=${i}">${i}</a>
                        </li>
                    </c:forEach>
                    <li <c:if test="${page eq totalPage}">class="disabled"</c:if>>
                        <a id="point-btn" class="page-link" href="/list?page=${page+1}"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    </div>
    </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
