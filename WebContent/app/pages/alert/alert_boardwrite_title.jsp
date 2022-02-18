<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="post_subject" value="${requestScope.post_subject }"/>
	<c:set var="post_contents" value="${requestScope.post_contents }"/>
	<%
		System.out.println("post_subject: " + request.getAttribute("post_subject") 
		+ ", post_contents: " + request.getAttribute("post_contents"));
	%>
	<c:choose>
		<c:when test="${post_subject eq ' ' || empty post_subject }">
			<script>
			alert("제목");
			location.href="${pageContext.request.contextPath }/app/pages/csswrite.jsp";
			</script>
		</c:when>
		<c:when test="${post_contents eq ' ' || empty post_contents }">
			<script>
			alert("내용");
			location.href="${pageContext.request.contextPath }/app/pages/csswrite.jsp";
			</script>
		</c:when>
	</c:choose>
</body>	
</html>