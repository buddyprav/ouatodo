/*
 * 
 *  Open Universities Australia 
 */

package com.oua.tm.common.domain;

/**
 * This class holds the response object status.
 * 
 * @author praveenkumar.a
 */
public class OUAResponse {

	/** Status. **/
	private String status = null;

	/** result. **/
	private Object result = null;

	/** message. **/
	private String message = null;

	/**
	 * Returns status.
	 * 
	 * @return String
	 */
	public final String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 * 
	 * @param pStatus
	 *            String
	 */
	public final void setStatus(final String pStatus) {
		this.status = pStatus;
	}

	/**
	 * Returns result.
	 * 
	 * @return result Object
	 */
	public final Object getResult() {
		return result;
	}

	/**
	 * Sets the Result.
	 * 
	 * @param pResult
	 *            Object
	 */
	public final void setResult(final Object pResult) {
		this.result = pResult;
	}

	/**
	 * Returns message.
	 * 
	 * @return String
	 */
	public final String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 * 
	 * @param pMessage
	 *            String
	 */
	public final void setMessage(final String pMessage) {
		this.message = pMessage;
	}
}
