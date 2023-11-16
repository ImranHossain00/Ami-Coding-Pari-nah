<%--
  Created by IntelliJ IDEA.
  User: peripatetic
  Date: 11/16/23
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Temperature Converter</title>
</head>
<body>

    <h1>Celsius to Fahrenheit conversion</h1>
    <form method="post" action="/convert">
        <input type="number" name="temperature">
        <input type="submit" value="Submit">
    </form>
</body>
</html>
