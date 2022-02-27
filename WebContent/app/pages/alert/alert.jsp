<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="url" value="${requestScope.url}"/>
<c:set var="msg" value="${requestScope.msg}"/>
<body>
<script>
    var url = "${url}";
    var msg = "${msg}";
    alert(msg);
    location.href = url;
</script>
</body>
</html>