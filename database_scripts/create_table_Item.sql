
/**
* Table creation script for 'ITEM' table.
*
* @author: praveenkumar.a
*
*/


-- Use database schema
USE OUA;

-- Drop table if already exists
DROP TABLE IF EXISTS ITEM;

-- Create 'ITEM' TABLE
CREATE TABLE ITEM(
	id int(11) unsigned NOT NULL AUTO_INCREMENT,
	description VARCHAR(100) NOT NULL,
	status VARCHAR(30) NULL,
	delFlag VARCHAR(30) NULL,
	modifiedBy VARCHAR(30) NULL, 
	modifiedDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	createdBy VARCHAR(30) NULL, 
	createdDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
