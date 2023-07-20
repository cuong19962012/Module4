<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/20/2023
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${msg != null}">
    <span>${msg}</span>
</c:if>
<table>
    <thead>
    <th>ID</th>
    <th>LANGUAGE</th>
    <th>PAGE SIZE</th>
    <th>SPAMS FILTER</th>
    <th>SIGNATURE</th>
    </thead>
    <tbody>
    <c:forEach var="email" items="${list}">
        <tr>
            <td><a href="/showFormUpdate/${email.id}">${email.id}</a>
            </td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamsFilter}</td>
            <td>${email.signature}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
