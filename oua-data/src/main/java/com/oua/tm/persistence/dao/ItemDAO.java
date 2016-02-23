/* 
 * Open Universities Australia 
 */
package com.oua.tm.persistence.dao;

import java.util.List;

import com.oua.tm.common.exception.OUAException;
import com.oua.tm.persistence.model.Item;

/**
 * This interface is for DAO layer on Items operation
 * 
 * @author praveenkumar.a
 * 
 */
public interface ItemDAO {
	
	
	/**
	 * Method to get the list of items from the database
	 * 
	 * @param item The item criteria
	 * @return List of items 
	 * @throws Exception If any exception
	 */
	public List<Item> getItemlist(Item item) throws Exception;
	

	/**
	 * Method to add new item object to database
	 * 
	 * @param item The item object to persist
	 * @return success or failure 
	 * @throws Exception If any exception
	 */
	public boolean addItem(Item item) throws Exception;
	
	/**
	 * Method to delete the selected item object from database
	 * 
	 * @param item The item to be deleted
	 * @return success or failure value
	 * @throws Exception If any exception
	 */
	public boolean deleteItem(Item item) throws Exception;
}
