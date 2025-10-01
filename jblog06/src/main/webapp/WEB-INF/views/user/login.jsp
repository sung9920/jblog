<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
<script>
$(function() {

});
</script>
</head>
<c:if test="${param.result == 'fail'}">
    <script>alert('아이디 또는 비밀번호가 잘못되었습니다.');</script>
</c:if>
<body>
	<div class="center-content">
		<h1 class="logo">
			<a href="${pageContext.request.contextPath}/">JBlog</a>
		</h1>
		<ul class="menu">
			<li><a href="${pageContext.request.contextPath}/user/join">회원가입</a></li>
		</ul>
		<form class="login-form" method="post" action="${pageContext.request.contextPath }/user/auth">
      		<label>아이디</label> <input type="text" name="id">
      		<label>패스워드</label> <input type="password" name="password">
      		<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>
