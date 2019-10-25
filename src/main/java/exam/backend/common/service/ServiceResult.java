package exam.backend.common.service;

import org.springframework.http.HttpStatus;

public class ServiceResult<T> {

	private T value;

	private HttpStatus httpStatus = HttpStatus.OK;

	private String message = "";

	public ServiceResult() {
	}

	public ServiceResult(T value) {
		this.value = value;
	}

	public ServiceResult(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public ServiceResult(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public ServiceResult(HttpStatus httpStatus, T value) {
		this.httpStatus = httpStatus;
		this.value = value;
	}

	public ServiceResult(T value, HttpStatus httpStatus, String message) {
		this.value = value;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return httpStatus == HttpStatus.OK || httpStatus == HttpStatus.CREATED || httpStatus == HttpStatus.ACCEPTED;
	}

	public boolean isFailed() {
		return !isSuccess();
	}

}
