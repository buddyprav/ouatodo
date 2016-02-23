/*
 * This is a confirmation dialog component that can be invoked confirmation dialogs.
 * 
 * @author praveenkumar.a
 */

(function($) {
	$.fn.jQConfirmDialogManager = function(pSettings) {
		
			var self = this;
			var mDefaultSettings = {
				header:"Confirm",
				onConfirm: function(){},
				onCancel: function(){}
			};

			mSettings = $.extend({}, mDefaultSettings, pSettings || {});	
			
			var mId = this.attr("id");
			var mDialogID = '#'+ mId+"_CONFIRM";
			var mDialogYesID = '#'+ mId+"_CONFIRM_YES";
			var mDialogNoID = '#'+ mId+"_CONFIRM_NO";
			
			if (!$(mDialogID).length) {
				 var mDialogInfo = {};
				 mDialogInfo.Id = mId;
				 mDialogInfo.Header = mSettings.header;
				 mDialogInfo.ConfirmationTxt = mSettings.confirmationTxt;
				 mDialogInfo.YesLabel = mSettings.confirmLabel;
				 mDialogInfo.NoLabel = mSettings.cancelLabel;
				 
				 var mModelTemplate = $("#cConfirmationTmpl").html();
				 var mHtml = Mustache.to_html(mModelTemplate,mDialogInfo);		
				 $('body').append(mHtml);			
			
				if(mSettings.confirmationTxt != undefined){
					$('#'+mSettings.uniqueId).on('show.bs.modal', function(e) {
					    $(this).find('.modal-body').text(mSettings.confirmationTxt);
					});
				}
				
				$(mDialogYesID).click(function(pEvent) {
				  	mSettings.onConfirm(self,pEvent);
				});
				
				$(mDialogNoID).click(function(pEvent) {
				  	mSettings.onCancel(self,pEvent);
				  	self.hide();
				});
			}
						
			self.open = function(){
				$(mDialogID).modal('show');
			};
			
			self.hide = function(){
				$(mDialogID).modal('hide');
			};
			
        return self;
	};
})(jQuery);
