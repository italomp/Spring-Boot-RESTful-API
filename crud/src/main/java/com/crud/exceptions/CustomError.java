package com.crud.exceptions;

import java.util.Date;

/**
 * This class represents a custom error.
 * @author Italo Modesto
 */
public class CustomError {
	private Date date;
	private String message;
	private String urlRequest;
	
	/**
	 * This is the CustomError constructor.
	 * @param date: It's the date on which the error occurred.
	 * @param message: It's the message error.
	 * @param urlRequest: It's the request url.
	 * @return a new customError instance.
	 */
	public CustomError(Date date, String message, String urlRequest) {
		this.date = date;
		this.message = message;
		this.urlRequest = urlRequest;
	}

	/**
	 * This method gets the this customError date.
	 * @return the this customError date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * This method sets the this customError date.
	 * @param date: the date on which this error occurred.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * This method gets the customError message.
	 * @return the customError message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * This method sets the customError message.
	 * @param message: It's the customError message.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * This method gets the urlRequest.
	 * @return the urlRequest.
	 */
	public String getUrlRequest() {
		return urlRequest;
	}

	/**
	 * This method sets the urlRequest.
	 * @param urlRequest: It's the urlRequest.
	 */
	public void setUrlRequest(String urlRequest) {
		this.urlRequest = urlRequest;
	}

}
