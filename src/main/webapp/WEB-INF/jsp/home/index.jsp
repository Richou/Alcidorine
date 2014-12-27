<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Bienvenue</title>
<body>
	<ng-include src="'${contextPath}/modules/quotations.jspf'"></ng-include>
	<section data-ng-controller="ArticleCtrl">
		<div class="thumbnail" data-ng-repeat="article in articles" data-ng-click="view(article.id, article.title)">
			<img data-ng-src="{{article.image}}" alt="image" />
			<footer title="{{article.title}}">{{article.title | truncate:20}}</footer>
		</div>
	</section>
</body>