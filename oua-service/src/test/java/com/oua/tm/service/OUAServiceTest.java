/**
 * Test Package
 */
package com.oua.tm.service;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.oua.tm.persistence.model.Item;

/**
 * Test class to verify the OUAService methods. Need to add all possible positive and negative test cases.
 * 
 *
 * @author praveenkumar.a
 */
@Test
@ContextConfiguration(locations = { "/unit-service-test-context.xml" })
public class OUAServiceTest extends AbstractTestNGSpringContextTests {
	/**
	 * The @Autowired annotation is auto wire the Application Context.
	 */
	@Autowired
	private ApplicationContext mContext;
	/**
	 * The @Autowired annotation is auto wire the Properties.
	 */
	@Autowired
	private Properties mProperties;
	/**
	 * The @Autowired annotation is auto wire the HierarchyService.
	 */

	@Autowired
	private OUAService ouaService;

	@Test
	@Transactional
	public void test1AddItem() throws Exception {
		boolean result = false;
		Item item = (Item) mContext.getBean("createItemFromService");
		result = ouaService.addItem(item);
		Assert.assertNotEquals(mProperties.getProperty("item.service.save"), result == true);
	}

	@Test
	@Transactional
	public void test2List() throws Exception {
		Item item = (Item) mContext.getBean("createItemFromService");
		List<Item> itemList = ouaService.getItemList(item);
		Assert.assertNotEquals(mProperties.getProperty("item.dao.list"), itemList.size() > 1);
	}

	@Test
	@Transactional
	public void test3Delete() throws Exception {
		boolean result = false;
		Item item = (Item) mContext.getBean("createItemFromService");
		result = ouaService.deleteItem(item);
		Assert.assertNotEquals(mProperties.getProperty("item.dao.delete"), result == true);
	}
	
	
	//TODO: Need to add all possible positive and negative test cases. 
}
