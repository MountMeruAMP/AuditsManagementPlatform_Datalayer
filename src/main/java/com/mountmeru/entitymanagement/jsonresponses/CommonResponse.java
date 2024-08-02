package com.mountmeru.entitymanagement.jsonresponses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommonResponse {
    private Integer code;
    private String message;
    private Object body;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	public CommonResponse(Integer code, String message, Object body) {
		super();
		this.code = code;
		this.message = message;
		this.body = body;
	}
	
    
    
}