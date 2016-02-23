<%-- 
It's activity page, which is used to add TODO item by the user.

@author praveenkumar.a
--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="sptg"%>

<html lang="en">
	<head>
		<title><sptg:message code="page.title.user.activity"/></title>
		<jsp:include page="/WEB-INF/jsp/common/imports.jsp" />
		<script src="${pageContext.request.contextPath}/resources/js/app/page/activityView.js"></script>		  
	</head>
	<script id="cActivityTmpl" type="text/html">
		{{#result}}
		 	<div class="radio list-group-item">
			<label><input type="radio" name="{{id}}">{{description}}</label>
			<label>{{createdBy}}</label>
		    <label>{{createdDate}}</label>
			</div>
		{{/result}}
	</script>	
	<body>	
		<jsp:include page="/WEB-INF/jsp/common/header.jsp" />
		
		<div class="modal fade" id="cActivityModalDialog" tabindex="-1" role="dialog">
		    <div class="modal-dialog">
		        <div class="modal-content">
		        
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal">&times;</button>
		                <h4 class="modal-title"><sptg:message code="popup.title.activity.form"/></h4>
		            </div>
		        
		            <div class="modal-body">
		            	<form role="form">
						  <div class="form-group">
						    <label for="cActivityDescription"><sptg:message code="label.input.desc"/></label>
						    <input type="text" class="form-control" id="cActivityDescription">
						  </div>
						</form>
		            </div>
		            
		            <div class="modal-footer">
						<button id="btnSaveActivity" type="button" class="btn btn-default btn-xs">
							<sptg:message code="label.btn.save"/>
						</button>               
		            </div>
		        </div>
		    </div>
		</div>
		
		<div class="container-fluid">
			<div class="row content">
				<div class="col-sm-3 col-md-2 sidebar">			     
					<ul class="nav nav-sidebar">
						<jsp:include page="/WEB-INF/jsp/common/menu.jsp" />
					</ul>					
				</div><br>			
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<h3 class="page-header"><sptg:message code="page.header.activity.todolist"/></h3>
					
					<button id="cAddActivity" type="button" class="btn btn-primary btn-xs" data-dismiss="modal" data-toggle="modal" data-target="#cActivityModalDialog">
						<sptg:message code="label.btn.add"/>
					</button>
					
					<button id="cDeleteActivity" type="button" class="btn btn-primary btn-xs">
						<sptg:message code="label.btn.delete"/>
					</button>

					<div class="list-group" id="cDivActivityList"></div>	
				</div>
			</div>
		</div>
	</body>
</html>
