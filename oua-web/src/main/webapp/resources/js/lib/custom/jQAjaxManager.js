/*
* This wrapper is responsible for making asynchronous calls to the url
* specified by the user and the response is received in the format of json.
* On Success, a custom message dialog is shown with status from the server.
* 
* @author praveenkumar.a
*/

$.jQAjaxManager = function(pSettings) {
    var mSettings;

    var mDefaultSettings = {
        async: false,
        dataType: "json",
        successMessage:false,
        contentType : 'application/json',
		mimeType : 'application/json'
    };

    mSettings = $.extend({}, mDefaultSettings, pSettings || {});
        
    $.ajax({
    	contentType : mSettings.contentType,
		mimeType : mSettings.mimeType,
        async: mSettings.async,
        type: "POST",
        complete: function () { },
        url: mSettings.action,
        data: mSettings.data,
        dataType: mSettings.dataType,
        success: function (pResponse) {        	
        	if(pResponse.status == APPLICATION.FAILURE) {
        		if(pResponse.message != undefined && pResponse.message != ""){
        			$.ApplicationGeneralComponent.Alert(APPLICATION.ALERT_WARNING,pResponse.message);
        		}else{
        			$.ApplicationGeneralComponent.Alert(APPLICATION.ALERT_DANGER,"There is unknown exception, Please contact administrator.");
        		}        		
        	}else{
        		if(mSettings.successMessage && pResponse.message != undefined && pResponse.message != "") {
        			$.ApplicationGeneralComponent.Alert(APPLICATION.ALERT_SUCCESS,pResponse.message);
        		}else {
        			if(mSettings.customSuccessMessage != undefined){
        			  $(mSettings.customSuccessMessage).text(pResponse.message);
        			   setTimeout(function(){
        				   $(mSettings.customSuccessMessage).text("");
      			      },5000);
        			}        			
        		}
        		mSettings.success(pResponse);
        	}
        }
    });
};
