<%-- 
This is the menu page, which used to navigate to view.

@author praveenkuamr.a
--%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="sptgm"%>

<li><a href="${pageContext.request.contextPath}/home/dashboard.do"><sptgm:message code="menu.home.dashboard"/></a></li>
<li><a href="${pageContext.request.contextPath}/user/activity/view.do"><sptgm:message code="menu.user.activity"/></a></li>