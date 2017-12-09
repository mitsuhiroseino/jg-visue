/* */
package com.purejadeite.visue.response;

public abstract class AbstractResponse<D> {

	private D data;

	private boolean success;

	private String message;

	public void setData(D data) {
		this.data = data;
	}

	public D getData() {
		return data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
