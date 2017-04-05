<%--
  Created by IntelliJ IDEA.
  User: youngjinkim
  Date: 2017. 4. 5.
  Time: PM 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><sitemesh:write property="title" default="사이트메시 레이아웃" /></title>
    <sitemesh:write property="head" />
</head>
<body>

<div>Header------------------------------</div>
<div>Menu</div>

<sitemesh:write property="body"/>

<div>Footer</div>

</body>
</html>