/*
 *  Open Universities Australia 
 */

package com.oua.tm.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oua.tm.common.exception.OUAException;
import com.oua.tm.persistence.dao.ItemDAO;
import com.oua.tm.persistence.model.Item;
import com.oua.tm.service.OUAService;

/**
 * This is the implementation of {@link OUAService}.This interacts to the
 * Persistence layer to get the relevant data based on the operation requested.
 * 
 * @author praveenkumar.a
 * 
 */

@Service("ouaService")
public class OUAServiceImpl implements OUAService {

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(OUAServiceImpl.class.getName());

	@Autowired
	private ItemDAO itemDAO;


	@Override
	public List<Item> getItemList(Item item) throws Exception {
		LOGGER.info("Request for list the activity from service");
		List<Item> itemList = null;

		try {

			itemList = this.itemDAO.getItemlist(item);
			LOGGER.info("itemList.size : " + itemList.size());

		} catch (OUAException ouaException) {
			LOGGER.log(Level.SEVERE, "OUAException while getting list of items", ouaException);
			throw ouaException;
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE,
					"Unknown exception while getting list of items", exception);
			throw exception;
		}
		return itemList;
	}

	
	@Override
	public boolean addItem(Item item) throws Exception {
		
		LOGGER.info("adding item object to database");		
		boolean result = false;

		try {

			result = itemDAO.addItem(item);
		} catch (OUAException ouaException) {
			LOGGER.log(Level.SEVERE, "OUAException from when saving item", ouaException);
			throw ouaException;
		} catch (Exception mException) {
			LOGGER.log(Level.SEVERE, "Unknown exception from when saving item", mException);
			throw mException;
		}
		return result;
	}


	@Override
	public boolean deleteItem(Item item) throws Exception {
		LOGGER.info("Request for delete activity from service");

		boolean result = false;
		
		try {

			result = this.itemDAO.deleteItem(item);
			
		} catch (OUAException ouaException) {
			LOGGER.log(Level.SEVERE, "OUAException when delete object is performed",
					ouaException);
			throw ouaException;
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Unknown exception from  when saving item", exception);
			throw exception;
		}
		return result;
	}
}
