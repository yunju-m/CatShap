<%@page import="catshap.butler.bean.Users"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	Users user = (Users)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="initial-scale=1, width=device-width" />
    <link rel="stylesheet" href="./css/user.css" />
    <link rel="stylesheet" href="./css/global.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="./js/user_regex.js"></script>
	<script src="./js/user.js"></script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div class="login-desktop">
        <section class="login">
            <div class="login-form">
                <div class="login-header">
                    <div class="login-title">
                        <div class="title">
                            <div class="strong-login-wrapper">
                                <h3 class="strong-login">Account Exit</h3>
                            </div>
                            <div class="changePwTitle">회원 탈퇴</div>
                        </div>
                        <div class="horizontal-divider-frame">
                            <div class="horizontal-divider"></div>
                        </div>
                    </div>
                </div>
                <form action="/user-exit-pass-confirm" method="post">
                 	<div id="user-data" data-user-no="<%=user.getUserNo() %>"></div>
                    <div class="input-fields-parent">
                        <div class="input-fields">
                            <div class="find-input">
                                <div class="input-title-container">
                                    <div class="loginDetailTitle">회원 탈퇴</div>
                                </div>
                                <div class="user-input">
                                    <label for="upass">비밀번호</label>
                                    <input id="upass" class="label-input-upass" placeholder="비밀번호를 입력해주세요." type="text" />
                                    <p id="upass-error" class="error-message" style="display: none;"></p>
                                    <label for="upassConfirm">비밀번호 확인</label>
                                    <input id="upassConfirm" class="label-input-upassConfirm" placeholder="다시 비밀번호를 입력해주세요." type="password" />
                                    <p id="upassConfirm-error" class="error-message" style="display: none;"></p>  
                                </div>
                                <div class="account-exit-div">
                                    <input id="accountExit" class="label-input-accountExit" type="checkbox" />
                                    <p class="account-exit-agree">동의함</p><p> / 탈퇴동의</p>
                                </div>
                            </div>
                        </div>
                        <div class="changePwBtnDiv">
                            <button id="accountExitBtn" class="accountExitBtn" type="submit">탈퇴 동의</button>
                            <button id="userExitCancelBtn" class="accountExitCancleBtn" type="button">취소</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>