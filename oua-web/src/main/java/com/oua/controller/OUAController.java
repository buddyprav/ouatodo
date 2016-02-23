package com.oua.controller;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oua.tm.common.constants.OUAConstants;
import com.oua.tm.common.constants.OUAMappingConstants;
import com.oua.tm.common.domain.OUAResponse;
import com.oua.tm.common.exception.OUAException;
import com.oua.tm.persistence.model.Item;
import com.oua.tm.service.OUAService;

/**
 * This Controller is responsible to handle TODO items. 
 * OUAservice will be injected into controller.
 * 
 * @author praveenkumar.a
 * 
 */

@Controller
public class OUAController {

   /**
    * Logger Name for this class.
    */
   private static final String LOGGING_CLASS_NAME = OUAController.class.getName();
   /**
    * Logger for this class.
    */
   private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);
   /**
    * Resource Bundle.
    */
   @Autowired
   private transient ReloadableResourceBundleMessageSource messageSource;

   @Autowired
   private transient OUAService ouaService;
   
   @Autowired
   private transient OUAMappingConstants ouaMappingConstants;
	
  
	@RequestMapping("/user/activity/view")
	public final ModelAndView view(){
		LOGGER.info("Request for view page");
		
		final ModelAndView mModelAndView = new ModelAndView();
		try{
			mModelAndView.setViewName(ouaMappingConstants.ACTIVITY_VIEW);
			LOGGER.exiting(LOGGING_CLASS_NAME, " : view");
			return mModelAndView;
		}
		catch (Exception mException) {
			LOGGER.log(Level.SEVERE, "Unknown exception from OUAController when getting the items view", mException);
			return mModelAndView;
		}
	}   
   
	
	/**
	* This method is invoked when a list of activity is requested by user. Activity model object specified as parameter,
	* which is used for filter the activity. if all attributes are null, it returns all activities, otherwise it will be fetch
	* the record based on the filter.
	* 
	* @param item
	* @return List of items.
	*/
	@RequestMapping(value = "/user/activity/list", method = RequestMethod.POST)
	@ResponseBody
	public final OUAResponse list(Item item){
		LOGGER.entering(LOGGING_CLASS_NAME, " : list");
		LOGGER.info("Request for list page");
		final OUAResponse ouaResponse = new OUAResponse();
		List<Item> itemList = null;
		try{
			itemList = ouaService.getItemList(item);
			ouaResponse.setMessage(messageSource.getMessage("general.list.success", null, Locale.getDefault()));
			ouaResponse.setResult(itemList);
			ouaResponse.setStatus(OUAConstants.SUCCESS);
			LOGGER.exiting(LOGGING_CLASS_NAME, " : list");
		}
		catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Unable to retrieve search results for items", exception);
			LOGGER.logrb(Level.SEVERE, LOGGING_CLASS_NAME, "list", "errorMessages", "general.search.errorMessage");
			ouaResponse.setStatus(OUAConstants.FAILURE);
			ouaResponse.setMessage(messageSource.getMessage("general.search.errorMessage", null, Locale.getDefault()));
			ouaResponse.setResult(null);
		}
		return ouaResponse;
	}   
	   
   	/**
	* This method is invoked when add item requested by user. activity model object specified as parameter, which is used
	* for input the activity information for create. It returns created activity.
	* 
	* @param activity {@link activity}
	* @param request HttpServletRequest
	* 
	* @return JSON data {@link OUAResponse}
	*/
	@RequestMapping(value = "/user/activity/add", method = RequestMethod.POST)
	@ResponseBody
	public final OUAResponse addItem(HttpServletRequest request, HttpSession session, @RequestBody final Item item, final BindingResult pResults) {
		final OUAResponse ouaResponse = new OUAResponse();
		try {
			LOGGER.entering(LOGGING_CLASS_NAME, " : add");
			LOGGER.info("Request for add item");
			
			ValidationUtils.rejectIfEmptyOrWhitespace(pResults, "description",messageSource.getMessage("mandatory.activity.description", null, request.getLocale()));
	        if (pResults.hasErrors()){
	        	ouaResponse.setStatus(OUAConstants.FAILURE);
	        	ouaResponse.setMessage(messageSource.getMessage("fail.input.validation", null, request.getLocale()));
	        	ouaResponse.setResult(pResults.getAllErrors());
	        }
	        else{
				ouaService.addItem(item);			
				List<Item> itemList = ouaService.getItemList(item);			
				ouaResponse.setMessage(messageSource.getMessage("general.save.success", null, Locale.getDefault()));
				ouaResponse.setResult(itemList);
				ouaResponse.setStatus(OUAConstants.SUCCESS);
	        }
		}
		catch (OUAException mOUAException) {
			ouaResponse.setResult(null);
			LOGGER.log(Level.SEVERE, "Unable to save activity", mOUAException);
			LOGGER.logrb(Level.SEVERE, LOGGING_CLASS_NAME, "Add", "errorMessages", mOUAException.getMessage());
			ouaResponse.setStatus(OUAConstants.FAILURE);
			ouaResponse.setMessage(messageSource.getMessage(mOUAException.getKey(), null, Locale.getDefault()));			
			return ouaResponse;
		}
		catch (Exception mException) {
			ouaResponse.setResult(null);
			LOGGER.log(Level.SEVERE, "Unable to save activity", mException);
			LOGGER.logrb(Level.SEVERE, LOGGING_CLASS_NAME, "Add", "errorMessages", "general.save.errorMessage");
			ouaResponse.setStatus(OUAConstants.FAILURE);
			ouaResponse.setMessage(messageSource.getMessage("general.save.errorMessage", null, Locale.getDefault()));			
			return ouaResponse;
		}
		return ouaResponse;
	}
	
	
	
	
	/**
	* This method is invoked when delete TODO item requested by user. activity model object specified as parameter, which is used
	* for input the activity information for delete. It returns once it's deleted activity.
	* 
	* @param activity {@link Item}
	* @param request HttpServletRequest
	* 
	* @return JSON data {@link OUAResponse}
	*/
	@RequestMapping(value = "/user/activity/delete", method = RequestMethod.POST)
	@ResponseBody
	public final OUAResponse deleteItem(HttpServletRequest request, HttpSession session, @RequestBody final Item item) {
		final OUAResponse ouaResponse = new OUAResponse();
		try {
			LOGGER.entering(LOGGING_CLASS_NAME, " : delete");
			LOGGER.info("Request for add item");
			ouaService.deleteItem(item);
			List<Item> mActivityList = ouaService.getItemList(item);			
			ouaResponse.setMessage(messageSource.getMessage("general.delete.success", null, Locale.getDefault()));
			ouaResponse.setResult(mActivityList);
			ouaResponse.setStatus(OUAConstants.SUCCESS);
		} 
		catch (Exception exception) {
			ouaResponse.setResult(null);
			LOGGER.log(Level.SEVERE, "Unable to delete item", exception);
			LOGGER.logrb(Level.SEVERE, LOGGING_CLASS_NAME, "delete", "errorMessages", "general.delete.errorMessage");
			ouaResponse.setStatus(OUAConstants.FAILURE);
			ouaResponse.setMessage(messageSource.getMessage("general.delete.errorMessage", null, Locale.getDefault()));	
			return ouaResponse;
		}
		return ouaResponse;
	}
}
