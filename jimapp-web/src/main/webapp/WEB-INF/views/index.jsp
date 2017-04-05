<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<html lang="en">
<head>
    <title>Jim's Web Applications</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Jim's app">
    <meta name="author" content="Jim liu">
    <spring:url value="/static/css/index.css" var="indexCss" />
    <spring:url value="/static/css/index.css" var="pageContext.request.contextPath" />
    <link href="${indexCss}" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/static/css/index.css" rel="stylesheet" />
</head>

<body>
<h3>You are welcome :)</h3>
<h2>My blog will be released soon... from 2017@China</h2>
    <script src="${pageContext.request.contextPath}/static/vendor/jquery/dist/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/static/app/index.js"></script>
</body>
</html>
