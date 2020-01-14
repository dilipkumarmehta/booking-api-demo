package com.booking.beans;

import java.io.Serializable;

public class Status implements Serializable {

	private static final long serialVersionUID = 1048100897069274297L;

	private String error_code;
	private String success_code;
	private String error_message;
	private String success_message;

	public Status() {

	}

	public Status(String error_code, String success_code, String error_message, String success_message) {
		super();
		this.error_code = error_code;
		this.success_code = success_code;
		this.error_message = error_message;
		this.success_message = success_message;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getSuccess_code() {
		return success_code;
	}

	public void setSuccess_code(String success_code) {
		this.success_code = success_code;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public String getSuccess_message() {
		return success_message;
	}

	public void setSuccess_message(String success_message) {
		this.success_message = success_message;
	}

}
