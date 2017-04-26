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
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><sitemesh:write property="title" default="휴먼라이브러리 관리자 페이지" /></title>

    <!-- Bootstrap Core CSS -->
    <%--<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- MetisMenu CSS -->
    <%--<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">--%>

    <!-- Custom CSS -->
    <%--<link href="../dist/css/sb-admin-2.css" rel="stylesheet">--%>

    <!-- Custom Fonts -->
    <%--<link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">--%>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <%--<!--[if lt IE 9]>--%>
        <%--<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
        <%--<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>--%>
    <%--<![endif]-->--%>
    <sitemesh:write property="head" />
</head>

<body>

<div>Header------------------------------</div>
<div>Menu</div>

<sitemesh:write property="body"/>

<div>Footer</div>

</body>
</html>