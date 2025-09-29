<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<%@ taglib uri="jakarta.tags.functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="header">
	<h1>${blogVo.title }</h1>
	<ul>
		<sec:authorize access="!isAuthenticated()">
			<li><a href="${pageContext.request.contextPath}/user/login">로그인</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<sec:authentication property="principal.username" var="userId"/>
			<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			<li><a href="${pageContext.request.contextPath}/${userId }/admin/basic">블로그 관리</a></li>
		</sec:authorize>
		<li><a href="${pageContext.request.contextPath}/">JBLOG</a></li>
	</ul>
</div>
