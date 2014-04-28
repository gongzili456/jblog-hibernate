package org.jblog.util;

public class AjaxResult {

	public static final int SUCCESS = 1;
	public static final int FAILED = 0;

	public static final String MESS_OK = "ok";
	public static final String MESS_ERROR = "error";
	private int status;
	private String message;

	
	
	public AjaxResult(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "AjaxResult [status=" + status + ", message=" + message + "]";
	}

}
