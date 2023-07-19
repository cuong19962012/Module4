<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Calculator
</h1>
<form method="post">
    <input type="number" name="input1"><br>
    <input type="number" name="input2"><br>
    <input type="submit" value="add" name="submit">
    <input type="submit" value="sub" name="submit">
    <input type="submit" value="mul" name="submit">
    <input type="submit" value="div" name="submit">
</form>
<c:if test="${result != null}">
    Result Division: ${result}
</c:if>
</body>
</html>