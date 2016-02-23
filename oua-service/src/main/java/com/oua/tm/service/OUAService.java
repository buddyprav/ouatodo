/*
 *  Open Universities Australia 
 */

package com.oua.tm.service;

import java.util.List;

import com.oua.tm.persistence.model.Item;

/**
 * This service class is to perform the core business operations for the applications.
 * 
 * @author praveenkumar.a
 */

public interface OUAService {
	
	
	/**
	 * Method to get list of items from the database based on criteria.
	 * 
	 * @param item The item type
	 * @return List of items
	 * @throws Exception Throws Exception if any
	 */
	public List<Item> getItemList(Item item) throws Exception;
	
	
	/**
	 * Method to add the item to the database.
	 * 
	 * @param item The item object to be persisted.
	 * @return success or failure
	 * @throws Exception Throws Exception if any
	 */
	public boolean addItem(Item item) throws Exception;
	
	
	/**
	 * Method to add the item to the database.
	 * 
	 * @param item The item object to be persisted.
	 * @return success or failure
	 * @throws Exception Throws Exception if any
	 */
	public boolean deleteItem(Item item) throws Exception;
}
