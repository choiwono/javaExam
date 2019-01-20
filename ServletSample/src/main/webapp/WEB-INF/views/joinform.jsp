<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>회원 가입 폼</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Passion+One' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
    <%@include file="navbar.jsp"%>
</head>
<style>

    body, html{
        height: 100%;
        font-family: 'Oxygen', sans-serif;
    }

    .main{
        margin-top: 25px;
        margin-bottom: 50px;
    }

    h1.title {
        font-size: 50px;
        font-weight: 400;
    }

    hr{
        width: 10%;
        color: #fff;
    }

    .form-group{
        margin-bottom: 15px;
    }

    label{
        margin-bottom: 15px;
    }

    input,
    input::-webkit-input-placeholder {
        font-size: 11px;
        padding-top: 3px;
    }

    .main-login{
        background-color: #fff;
        /* shadows and rounded borders */
        -moz-border-radius: 2px;
        -webkit-border-radius: 2px;
        border-radius: 2px;
        -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

    }

    .main-center{
        margin-top: 30px;
        margin-bottom: 40px;
        margin: 0 auto;
        max-width: 330px;
        padding: 40px 40px;

    }

    .login-button{
        margin-top: 5px;
    }

</style>
<body>
        <div class="container">
            <div class="row main">
                <div class="panel-heading">
                    <div class="panel-title text-center">
                        <h3 class="title">회원가입</h3>
                        <hr />
                    </div>
                </div>
                <div class="main-login main-center">
                    <form id="registerForm" class="form-horizontal" data-parsley-validate="true" method="post" action="/join">
                        <div class="form-group">
                            <label for="name" class="cols-sm-2 control-label">이름</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="name" id="name" minlength="2" placeholder="이름.." required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="nickname" class="cols-sm-2 control-label">닉네임</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="nickname" id="nickname" minlength="2" placeholder="닉네임" required/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="cols-sm-2 control-label">이메일</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                    <input type="text" class="form-control" name="email" id="email"  placeholder="이메일.." required/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="passwd1" class="cols-sm-2 control-label">비밀번호</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="passwd1" id="passwd1"  placeholder="비밀번호" required/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="passwd2" class="cols-sm-2 control-label">비밀번호 확인</label>
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                    <input type="password" class="form-control" name="passwd2" id="passwd2"  placeholder="비밀번호 확인" required/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group ">
                            <button type="submit" class="btn btn-primary btn-lg btn-block login-button">등록</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
</body>
<script type="text/javascript">
    $(function() {
        $("#registerForm").validate({
            rules: {
                nickname : {
                    required : true
                },
                email : {
                    required : true
                },
                passwd1 : {
                    required: "required"
                },
                passwd2 : {
                    required:true,
                    equalTo:'#passwd1'
                },
                name : {
                    required : true
                }
            }, messages: {
                name: {
                    required: "이름을 입력하세요"
                },
                nickname: {
                    required: "닉네임을 입력하세요"
                },
                email: {
                    required: "이메일을 입력하세요",
                    email:"올바른 이메일을 입력해주세요"
                },
                passwd1: {
                    required: "암호을 입력하세요"
                },
                passwd2: {
                    required: "암호 확인을 입력하세요",
                    equalTo:"암호가 일치하지 않습니다"
                }
            },
            submitHandler: function(frm) {
                alert("회원가입이 되었습니다.");
                frm.submit();
            },
            success: function(e) {

            }
        });
    });
</script>
<%@include file="footer.jsp"%>
</html>