/* @(#)Base.java 1.0 02/16
 * Copyright (c) Open Universities Australia 2016
 */
package com.oua.tm.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * Abstract Base represents common attributes to be inherited by all model Classes.
 */
@MappedSuperclass
public abstract class OUABase implements Serializable {
   
	/** Serial Version. */
	private static final long serialVersionUID = 1L;
  
	/**Id Field. It's automatically generate, when its created new record **/
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
    /** The active/inactive status. */
	@Column(name="status")
   	private boolean status;
   
	/** Delete flag to indicate logical delete. */
	@Column(name="delFlag")
   	private char delFlag;
      
	/** Modified User. */
	@Column(name="modifiedBy")	
   	private String modifiedBy;
   
   
	/** Modified Date. */   
	@Temporal(TemporalType.DATE)
	@Generated(GenerationTime.ALWAYS) 
	@Column(name="modifiedDate", insertable=false,updatable=false)
	private Date modifiedDate;
	
	/** Created User. */
	@Column(name="createdBy")	
	private String createdBy;
   
	/** Created Date. */
	@Temporal(TemporalType.DATE)
	@Generated(GenerationTime.ALWAYS)
	@Column(name="createdDate", insertable=false,updatable=false)
	private Date createdDate;

	/** @return Id,gets Id. */
	public Long getId() {
		return id;
	}
	
	/** @param id to sets id. */
	public void setId(Long id) {
		this.id = id;
	}
	
	/** @return the status. */
	public boolean getStatus(){
		return status;
	}

	/** @param status to set. */
	public void setStatus(int status){
		this.status = (status == 1) ? true : false;
	}
   
    /** @return the delFlag. */
	public char getDelFlag(){
      return delFlag;
	}

	/** @param pDelFlag to Sets Delete Flag. */
	public void setDelFlag(char pDelFlag){
		this.delFlag = pDelFlag;
	}
   
   
	/** @return modifiedBy, the user who modified. */
	public String getModifiedBy(){
		return modifiedBy;
	}
	
	/** @param pModifiedBy, sets the user who modified. */
	public void setModifiedBy(String pModifiedBy){
		this.modifiedBy = pModifiedBy;
	}

	/** @return modifiedDate,Gets the last modified date. */
	public Date getModifiedDate(){
		if (modifiedDate != null){
			modifiedDate = new Date(modifiedDate.getTime());
		}
		return modifiedDate;
	}	

	/** @param pModifiedDate, sets the last modified date. */
	public void setModifiedDate(Date pModifiedDate){
		if (pModifiedDate != null){
			this.modifiedDate = new Date(pModifiedDate.getTime());
		}
	}

	/** @return createdBy, gets the user who created. */
	public String getCreatedBy(){
		return createdBy;
	}

	/** @param pModifiedBy, sets the user who created. */
	public void setCreatedBy(String pCreatedBy){
		this.createdBy = pCreatedBy;
	}

	/** @return createdDate,gets the created date. */
	public Date getCreatedDate() {
		if (createdDate != null) {
			createdDate = new Date(createdDate.getTime());
		}
		return createdDate;
	}

	/** @param createdDate, sets the created date. */
	public void setCreatedDate(Date pCreatedDate){
		if (pCreatedDate != null){
			this.createdDate = new Date(pCreatedDate.getTime());
		}
	}
}
