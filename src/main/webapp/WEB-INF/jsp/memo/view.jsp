<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<title>Aide mémoire</title>
<body>
	<ng-include src="'${contextPath}/modules/quotations.jspf'"></ng-include>
	<article data-ng-show="global.endpointLibLoaded" data-ng-controller="ItemsCtrl">
		${memory.title}
	</article>
</body>