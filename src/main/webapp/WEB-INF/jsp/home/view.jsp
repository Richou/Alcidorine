<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Bienvenue</title>
<body>
	<ng-include src="'${contextPath}/modules/quotations.jspf'"></ng-include>
	<article data-ng-show="global.endpointLibLoaded">
		${article.title}
	</article>
</body>