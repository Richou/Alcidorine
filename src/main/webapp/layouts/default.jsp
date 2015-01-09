<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page isELIgnored ="false" %>
<!doctype html>
<html lang="fr" data-ng-app="alcidorineApp" data-ng-controller="AppCtrl">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=no;"/>
<link rel="stylesheet" type="text/css" href="${contextPath}/styles/alcidorine.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
<title><decorator:title /> - heanoria</title>
<decorator:head></decorator:head>
</head>

<body>
<script src="${contextPath}/js/alcidorine.js" ></script>
<script type="text/javascript">
	alcidorine.constant('ROOT_URL', '${contextPath}');
</script>
<script src="//apis.google.com/js/client.js?onload=init"></script>
<nav id="docked_menu" data-resize data-ng-controller="NavigationCtrl" data-ng-class="global.menuClass">
	<header>
		<span data-ng-show="global.isOnMobileDevice" class="small_menu_show" data-ng-click="showHideMenu()"></span>
		<div>heanoria</div>
	</header>
	<ul data-ng-class="menuShowClass ? 'show' : ''">
		<li data-ng-click="navigateTo('${contextPath}/')">
			<div class="article_item_icon"></div>
			<span>Articles</span>
		</li>
		<li data-ng-click="navigateTo('${contextPath}/aide-memoire')">
			<div class="memo_item_icon"></div>
			<span>Aide mémoire</span>
		</li>
		<li data-ng-click="navigateTo('${contextPath}/campagnes')">
			<div class="campaign_item_icon"></div>
			<span>Campagnes</span>
		</li>
	</ul>
</nav>
<div id="container" data-ng-class="global.menuClass">
<decorator:body></decorator:body>
</div>
<div id="throbber"></div>
</body>
</html>