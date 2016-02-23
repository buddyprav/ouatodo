/*
 * This is a generic dialog component that can be invoked to show error, alert
 *  and confirmation dialog.
 *  
 *  @author praveenkumar.a
 *   */

$.ApplicationGeneralComponent = $.ApplicationGeneralComponent ? $.ApplicationGeneralComponent : {};

(function($){
	$.extend(true,$.ApplicationGeneralComponent, {
		
		Alert : function(pType,pText){
			if(pType == APPLICATION.ALERT_SUCCESS){
				$("#cDivAlertHeader").text(APPLICATION.ALERT_SUCCESS_HEADER);
			}else if(pType == APPLICATION.ALERT_DANGER){
				$("#cDivAlertHeader").text(APPLICATION.ALERT_DANGER_HEADER);
			}else if(pType == APPLICATION.ALERT_INFO){
				$("#cDivAlertHeader").text(APPLICATION.ALERT_INFO_HEADER);
			}else if(pType == APPLICATION.ALERT_WARNING){
				$("#cDivAlertHeader").text(APPLICATION.ALERT_WARNING_HEADER);
			}		
			$("#cDivAlertHolder").addClass(pType);	
			$("#cDivAlertTxt").text(pText);			
			$("#cDivAlert").modal('show');
		}
	});
})(jQuery);
