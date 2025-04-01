<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<%@include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<body>
<div class="container">
    <h1>Welcome ${name}</h1>
    <a href="list-todos">Todos 확인하기</a>
</div>
</body>
</html>