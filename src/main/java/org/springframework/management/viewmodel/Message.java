package org.springframework.management.viewmodel;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Message<T extends Object> implements Serializable { 
	private static final long serialVersionUID = 1L;
	private String code; // http状态码
	private String errorCode; // 错误码 null表示返回正确结果
	private String msg;  
	private int count;
	private T data; 

	public Message(){
		this("200","操作成功");
	} 

	public Message(T data){
		this("200","操作成功");
		this.data = data; 
	} 
	
	public Message(String code, String msg){
		this(code,msg,0,(T) new ArrayList());
	}
	
	public Message(String code, String msg, int count, T data){
		 this.code = code;
		 this.msg = msg;
		 this.count = count;
		 this.data = data; 
	}
	
	public void error(String errorCode, String msg) {
		this.errorCode = errorCode;
		this.msg = msg;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}

 