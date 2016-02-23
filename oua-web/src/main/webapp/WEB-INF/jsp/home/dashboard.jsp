<%-- 
It's dashboard page, which is landing page for any user.

@author praveenkumar.a
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="sptg"%>

<html lang="en">
	<head>
		<title><sptg:message code="page.title.home.dashboard"/></title>
	
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
	  
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app/base.css">

		<script src="${pageContext.request.contextPath}/resources/js/lib/jquery-1.10.2.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/lib/mustache.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/lib/bootstrap.min.js"></script>		
	</head>
		
	<body>	
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		
		<div class="container-fluid">
			<div class="row content">
				<div class="col-sm-3 col-md-2 sidebar">			     
					<ul class="nav nav-sidebar">
						<jsp:include page="/WEB-INF/jsp/common/menu.jsp" />
					</ul>					
				</div><br>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h3 class="page-header"><sptg:message code="page.header.home.dashboard"/></h3>					
				</div>
			</div>
		</div>
	</body>
</html>
