/* 
 * Open Universities Australia 
 */
package com.oua.tm.persistence.dao.impl;

import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oua.tm.common.constants.OUAConstants;
import com.oua.tm.common.exception.OUAException;
import com.oua.tm.persistence.dao.ItemDAO;
import com.oua.tm.persistence.model.Item;

/**
 * This is the implementation of {@link ItemDAO}. These methods has the required business logic for persistence.
 * 
 * @author praveenkumar.a
 */

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	private static final String LOGGING_CLASS_NAME = ItemDAOImpl.class.getName();

	/**
	 * Logger for this class.
	 */
	private static final Logger LOGGER = Logger.getLogger(LOGGING_CLASS_NAME);

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory mSessionFactory){
		this.sessionFactory = mSessionFactory;
	}
	
	

	@Override
	public boolean addItem(Item item) throws Exception{
		LOGGER.entering(LOGGING_CLASS_NAME, " : add");
		LOGGER.info("Request for add the activity from persistence");
		boolean mResult = false;
		Session mSession= null;
		Transaction mTransaction = null;
		try{
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();			
			Set<ConstraintViolation<Item>> mConstraintViolationList = validator.validate(item);			
			if(mConstraintViolationList.size() < 1){
				mSession = this.sessionFactory.openSession();
				mTransaction = mSession.beginTransaction();			
				item.setDelFlag(OUAConstants.NO_FLG);
				item.setCreatedBy(OUAConstants.OUA_USER);
				mSession.persist(item);			
				mTransaction.commit();		
				mResult = true;
			}else{
				throw new OUAException("fail.input.validation","", null);
			}
		}
		catch(OUAException pOUAException){
			if (mTransaction!=null) {
				mTransaction.rollback();
			}
			pOUAException.printStackTrace(); 
			LOGGER.log(Level.SEVERE, "OUAException from when add item", pOUAException);
			throw pOUAException;
		}
		catch(Exception pException){
			if (mTransaction!=null) {
				mTransaction.rollback();
			}
			pException.printStackTrace(); 
			LOGGER.log(Level.SEVERE, "Unknown exception from when add item", pException);
			throw pException;
		}		
		finally{
			if(mSession != null){
				mSession.close();	
			}	 
	    }
		LOGGER.exiting(LOGGING_CLASS_NAME, " : add");
		return mResult;
	}
	
	@Override
	public List<Item> getItemlist(Item item) throws Exception {
		LOGGER.entering(LOGGING_CLASS_NAME, " : list in persistence");
		LOGGER.info("Request for list the activity from persistence");			
		List<Item> itemList = null;
		StatelessSession mSession = null;
		try{
			mSession = this.sessionFactory.openStatelessSession();
			Criteria mCriteria = mSession.createCriteria(Item.class);			
			mCriteria.add(Restrictions.eq("delFlag", OUAConstants.NO_FLG));
			if(item.getDescription() !=null && !item.getDescription().isEmpty()){
				mCriteria.add(Restrictions.eq("description", item.getDescription()));
			}			
			itemList = mCriteria.list();
		}
		catch(OUAException pOUAException){
			LOGGER.log(Level.SEVERE, "There OUAException from "+ LOGGING_CLASS_NAME +" when list of items ", pOUAException);
			throw pOUAException;
		}
		catch(Exception pException){
			pException.printStackTrace(); 
			LOGGER.log(Level.SEVERE, "There is unknown exception from "+ LOGGING_CLASS_NAME +" when list of items", pException);
			throw pException;
		}
		finally{
			if(mSession != null){
				mSession.close();	
			}
		}
		LOGGER.exiting(LOGGING_CLASS_NAME, " : list in persistence");
		return itemList;
	}


	@Override
	public boolean deleteItem(Item item) throws Exception{
		LOGGER.entering(LOGGING_CLASS_NAME, " : delete in persistence");
		LOGGER.info("Request for delete the activity from persistence");
		boolean mResult = false;
		Session mSession= null;
		Transaction mTransaction = null;
		try{
			mSession = this.sessionFactory.openSession();
			mTransaction = mSession.beginTransaction();
			Item deleteItem = (Item)mSession.load(Item.class, item.getId());
			deleteItem.setDelFlag(OUAConstants.YES_FLG);
			mSession.update(deleteItem);
			mTransaction.commit();
			mResult = true;			
		}
		catch(OUAException pOUAException){
			if (mTransaction!=null) {
				mTransaction.rollback();
			}
			pOUAException.printStackTrace(); 
			LOGGER.log(Level.SEVERE, "There is OUAException from "+ LOGGING_CLASS_NAME +" when delete item", pOUAException);
		}
		catch(Exception pException){
			if (mTransaction!=null) {
				mTransaction.rollback();
			}
			pException.printStackTrace(); 
			LOGGER.log(Level.SEVERE, "There is unknown exception from "+ LOGGING_CLASS_NAME +" when delete item", pException);
			throw pException;
		}
		finally{
			if(mSession != null){
				mSession.close();	
			}
	    }
		LOGGER.exiting(LOGGING_CLASS_NAME, " : delete in persistence");
		return mResult;
	}
}
	
