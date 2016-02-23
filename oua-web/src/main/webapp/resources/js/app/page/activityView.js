/**This script is responsible to populate the grid on maintenance page 
 * based on user search criteria and create and delete functionality from UI part has been implemented
 * 
 * @author praveenkumar.a
 */

$(document).ready(function () {
	
	// Delete on confirmation action ti performed.
	var mActivityTemplate = $("#cActivityTmpl").html();
	var mDelete = $("#cDeleteActivity").jQConfirmDialogManager({
		header:"Confirm Delete",
		confirmationTxt:"Are you really wish to delete the selected item...?",
		confirmLabel:"Delete",
		cancelLabel:"Cancel",
		onConfirm: function(pSelf,pEvent){
			var mId= $( "input[type=radio]:checked").attr("name");
			if(mId != undefined){
				var mDeleteActivity ={};
				mDeleteActivity.id = parseInt(mId);
				$.jQAjaxManager({
					successMessage:true,
					async:true,
					action: ACTION.USER_ACTIVITY_DELETE,
					data: JSON.stringify(mDeleteActivity),
					success: function (pResponse) {
						var mHtml = Mustache.to_html(mActivityTemplate,pResponse);		
						$('#cDivActivityList').html(mHtml);
					}
				});
				pSelf.hide();
			}else{
				$.ApplicationGeneralComponent.Alert(APPLICATION.ALERT_WARNING,APPLICATION_MSG.SELECT);
			}
		}
	});
	
	// On click of the delete it will show the confirmation with basic validation
	$('#cDeleteActivity').click(function(pEvent) {
		var mId= $( "input[type=radio]:checked").attr("name");
		if(mId != undefined){
			mDelete.open();
		}else{
			$.ApplicationGeneralComponent.Alert(APPLICATION.ALERT_WARNING,APPLICATION_MSG.SELECT);
		}
	});
	
	// Save the Item
	$('#btnSaveActivity').click(function(pEvent) {		    
		var mActivity = {};
		mActivity.description = $("#cActivityDescription").val();
		$.jQAjaxManager({
			successMessage:true,
			async:true,
			action: ACTION.USER_ACTIVITY_ADD,
			data: JSON.stringify(mActivity),
			success: function (pResponse) {
				var mHtml = Mustache.to_html(mActivityTemplate,pResponse);		
				$('#cDivActivityList').html(mHtml);
				$("#cActivityModalDialog").modal('hide');
			}
		});
	});
	
	// fetch the list
	var pActivity = {};
	$.jQAjaxManager({
		successMessage:true,
		async:true,
		action: ACTION.USER_ACTIVITY_LIST,
		data: JSON.stringify(pActivity),
		success: function (pResponse) {
			 var mHtml = Mustache.to_html(mActivityTemplate,pResponse);		
			 $('#cDivActivityList').html(mHtml);	
		}
	});
});