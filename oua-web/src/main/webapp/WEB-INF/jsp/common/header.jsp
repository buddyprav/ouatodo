<%-- 
This is the header file included in all pages.

@author praveenkumar.a
--%>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>                        
			</button>
			<a class="navbar-brand" href="#"></a>
		</div>
	
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav visible-xs">
				<jsp:include page="/WEB-INF/jsp/common/menu.jsp" />
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon"></span>Logged User : OUA</a></li>
			</ul>
		</div>
	</div>
</nav>

<jsp:include page="/WEB-INF/jsp/common/common.jsp" />