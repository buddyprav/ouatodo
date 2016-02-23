/**
 * Test Package
 */
package com.oua.tm.persistence.dao;

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
 * This test class is used to check the ItemDAO methods.
 * 
 * @author praveenkumar.a
 */
@Test
@ContextConfiguration(locations = { "/unit-dao-test-context.xml" })
public class ItemDAOTest extends AbstractTestNGSpringContextTests {
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
	private ItemDAO itemDAO;

	@Test()
	@Transactional
	public void test1AddActivity() throws Exception {
		Item item = (Item) mContext.getBean("createItemFromDAO");
		boolean mReturn = itemDAO.addItem(item);
		Assert.assertNotEquals(mProperties.getProperty("activity.dao.save"),
				mReturn == true);
	}

	@Test
	@Transactional
	public void test2List() throws Exception {
		Item item = (Item) mContext.getBean("createItemFromDAO");
		List<Item> mtActivityList = itemDAO.getItemlist(item);
		Assert.assertNotEquals(mProperties.getProperty("activity.dao.list"),
				mtActivityList.size() > 1);
	}

	@Test
	@Transactional
	public void test3Delete() throws Exception {
		Item item = (Item) mContext.getBean("createItemFromDAO");
		boolean mReturn = itemDAO.deleteItem(item);
		Assert.assertNotEquals(mProperties.getProperty("activity.dao.delete"),
				mReturn == true);
	}

	// TODO: This will extend a big list, need to add more positive and negative
	// cases
}
