<%-- 
This is the common imports file responsible for importing the necessary scripts needed in all pages.

@author praveenkuamr.a
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="corert"%>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app/base.css">

<script>var mContextPath = "${pageContext.request.contextPath}"</script>

<script src="${pageContext.request.contextPath}/resources/js/lib/jquery-1.10.2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app/common/ActionConstants.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app/common/ApplicationMessages.js"></script>	
<script src="${pageContext.request.contextPath}/resources/js/app/common/ApplicationConstants.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app/common/ApplicationGeneralComponent.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/custom/jQConfirmDialogManager.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/custom/jQAjaxManager.js"></script>