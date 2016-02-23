/* @(#)Activity.java 1.0 02/16
 * Copyright (c) Open Universities Australia 2016
 */
package com.oua.tm.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 * Represents the details of the activity table.
 */
@Entity
@Table(name="Item")
public class Item extends OUABase implements Serializable {

	/** Default Serial version ID. */
	private static final long serialVersionUID = 1L;
	
	/** Description Field. **/
	@Column(name = "description")
	@Length(min = 3, max = 100)
	private String description;
	
	/** @return description,gets description. */
	public String getDescription() {
		return description;
	}

	/** @param description to sets description. */
	public void setDescription(String description) {
		this.description = description;
	}
}