/* */
package com.purejadeite.visue.request;

import javax.validation.Valid;


public abstract class AbstractRequest<D> {

	@Valid
	private D data;

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

}
