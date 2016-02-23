/*
 * 
 *  Open Universities Australia 
 */

package com.oua.tm.common.exception;

/**
 * This is used defined exception for OUA application, which extends the base Exception class.
 *
 * @author praveenkumar.a 
 */
@SuppressWarnings("serial")
public class OUAException extends RuntimeException {
	

	private String key;


	private String message;

	/**
	 * Constructor method to create the exception
	 *  
	 * @param key The key value 
	 * @param message The message 
	 * @param throweable The throweable object
	 */
	public OUAException(final String key, final String message, final Throwable throweable){
		super(message);
		this.key = key;
		this.message = message;
		this.initCause(throweable);
	}

	/**
	* Create OUAException instance with a description.
	* 
	* @param newMessage
	*           description of the message
	* @param newThroweable
	*           Throwable original exception.
	*/
	public OUAException(final String newMessage, final Throwable newThroweable){
	  super(newMessage);
	  this.message = newMessage;
	  this.initCause(newThroweable);
	}

	
	/**
	* Get the key.
	* @return key the key value
	*/
	public final String getKey(){
		return key;
	}

	/**
	* Sets the Key.
	* @param newKey
	*           the Key value as a string
	*/
	public final void setKey(final String newKey){
		this.key = newKey;
	}

	/**
	* Gets the message.
	* @return message the message
	*/
	public final String getMessage(){
		return message;
	}

	/**
	* Set the new message. 
	* @param newMessage
	*           the message
	*/
	public final void setMessage(final String newMessage){
		this.message = newMessage;
	}
}
