<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page isELIgnored ="false" %>
<!doctype html>
<html lang="fr" data-ng-app="alcidorineApp">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${contextPath}/styles/alcidorine.css" />
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.0/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="${contextPath}/js/alcidorine/Core.js"></script>
<title><decorator:title /> - heanoria</title>
<decorator:head></decorator:head>
</head>

<body>
<div class="container">
<decorator:body></decorator:body>
</div>
</body>
</html>