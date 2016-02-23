<%-- 
This is the common dialog and template page  that is used for 
alert, warning and error messages that require user confirmation

@author praveenkumar.a
--%>
<script id="cConfirmationTmpl" type="text/html">
	<div class="modal fade" id="{{Id}}_CONFIRM" tabindex="-1" role="dialog">
	    <div class="modal-dialog">
	        <div class="modal-content">
	        
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal">&times;</button>
	                <h4 class="modal-title">{{Header}}</h4>
	            </div>
	        
	            <div class="modal-body">
	                <p>{{ConfirmationTxt}}</p>
	            </div>
	            
	            <div class="modal-footer">
					<button id="{{Id}}_CONFIRM_YES" type="button" class="btn btn-danger btn-ok btn-xs">{{YesLabel}}</button>
	                <button id="{{Id}}_CONFIRM_NO" type="button" class="btn btn-default btn-xs">{{NoLabel}}</button>	                
	            </div>
	        </div>
	    </div>
	</div>
</script>


<!-- Alert -->
<div class="modal fade" id="cDivAlert" role="dialog">
	<div id="cDivAlertHolder" class="modal-dialog alert">
		<strong id="cDivAlertHeader"></strong>
		<span id="cDivAlertTxt"></span>
	</div>
</div>
<!-- Alert -->