package com.crudoperation.example.CrudDto.response;

public class CommonResponse {
  
	private String code;
	private String message;
	public CommonResponse() {
	}
	
	public CommonResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
