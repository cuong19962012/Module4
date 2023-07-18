<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/translate" method="get">
    <label for="english"></label>
    <input type="text" id="english" name="input">
    <input type="submit">
</form>
<c:if test="${output != null}">
    <span>${output}</span>
</c:if>
</body>
</html>