<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculate" method="get">
    <label>USD</label>
    <input type="text" name="usd"/><br><br>
    <label>Percent</label>
    <input type="text" name="percent"/><br><br>
    <input type="submit" value="CAL"><br>
</form>
<c:if test="${result != null}">
    <span>${result}</span>
</c:if>
</body>
</html>