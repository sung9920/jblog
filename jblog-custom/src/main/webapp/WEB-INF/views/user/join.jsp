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
	$("#btn-checkid").click(function() {
		var id = $("#id").val();
		if(!id) {
			return;
		}

		$.ajax({
			url: "${pageContext.request.contextPath }/api/user/checkid?id=" + id,
			type: "get",
			dataType: "json",
			success: function(response) {
				console.log(response);

				if(response.result == "fail") {
					console.error(response.message);
					return;
				}

				if(response.data){
					alert("아이디가 존재합니다. 다른 아이디를 사용해 주세요.");
					$("#id").val("");
					$("#id").focus();
					return;
				}

				alert("사용가능한 아이디입니다.");
				$("#btn-checkid").hide();
				$("#id").prop("disabled", true);
			},
			error: function(xhr, status, err) {
				console.error(err);
			}
		});
	});
});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">
			<a href="${pageContext.request.contextPath}/">JBlog</a>
		</h1>
		<ul class="menu">
			<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
		</ul>
		<form class="join-form" id="join-form" method="post" action="">
			<label class="block-label" for="name">이름</label>
			<input id="name"name="name" type="text" value="">

			<label class="block-label" for="blog-id">아이디</label>
			<input id="id" name="id" type="text">
			<input id="btn-checkid" type="button" value="id 중복체크">
			<img id="img-checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<input id="password" name="password" type="password" />

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
</body>
</html>
