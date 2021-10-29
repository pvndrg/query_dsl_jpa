package com.example.demo.response;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse<T>
{

	private HttpStatus status;
	private Boolean success;
	private String message;
	private T response;

	public ApiResponse(Boolean success, String message)
	{
		this.success = success;
		this.message = message;
	}

	public ApiResponse(Boolean success, String message, T response)
	{

		this.success = success;
		this.message = message;
		this.response = response;
	}

	public ApiResponse(Boolean success, T response)
	{

		this.success = success;
		this.response = response;
	}

	public ApiResponse(HttpStatus status, Boolean success, String message)
	{

		this.status = status;
		this.success = success;
		this.message = message;
	}
	
	public ApiResponse(HttpStatus status, Boolean success, T response)
	{

		this.status = status;
		this.success = success;
		this.response = response;
	}

	public ApiResponse()
	{
		super();
	}

	public HttpStatus getStatus()
	{
		return status;
	}

	public void setStatus(HttpStatus status)
	{
		this.status = status;
	}

	public Boolean getSuccess()
	{
		return success;
	}

	public void setSuccess(Boolean success)
	{
		this.success = success;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public T getResponse()
	{
		return response;
	}

	public void setResponse(T response)
	{
		this.response = response;
	}

}
