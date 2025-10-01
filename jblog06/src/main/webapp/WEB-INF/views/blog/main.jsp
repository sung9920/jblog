<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div class="blog-content">
				<c:if test="${post == null}">
					<img src="${pageContext.request.contextPath}/assets/images/teong.png" style="width:400px; height:200px">
				</c:if>
					<h4>${post.title }</h4>
					<p style="white-space: pre-wrap;">${post.contents }</p>
				</div>
				<ul class="blog-list">
					<c:forEach items="${postList }" var="postVo">
					<li><a href="${pageContext.request.contextPath}/${blogVo.blogId }/${postVo.categoryId }/${postVo.id}">${postVo.title }</a> <span>${postVo.regDate }</span>	</li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img src="${pageContext.request.contextPath}${blogVo.profile }" style="width:150px; height:150px">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${categoryList }" var="categoryVo">
				<li><a href="${pageContext.request.contextPath}/${blogVo.blogId }/${categoryVo.id }">${categoryVo.name }</a></li>
				</c:forEach>
			</ul>
		</div>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>