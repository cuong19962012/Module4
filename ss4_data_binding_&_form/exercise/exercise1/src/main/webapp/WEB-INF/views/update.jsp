<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 7/20/2023
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Settings</h3>
<form:form action="/update" method="post" modelAttribute="emailInfo">
    <table>
        <tr>
            <td>
                <form:hidden path="id"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="language"> Language</form:label></td>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page size</form:label></td>
            <td>
                Show
                <form:select path="pageSize">
                    <form:options items="${pageSize}"></form:options>
                </form:select>
                email per page
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams filter</form:label></td>
            <td>
                <form:checkbox path="spamsFilter"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature</form:label></td>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><form:button>Save</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
