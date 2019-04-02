package com.zhong.entiry;

import com.zhong.enums.ResponseCode;

public class CustomException extends Exception {
	private Integer code;

	public CustomException() {
	}

	public CustomException(ResponseCode resultEnum) {
		super((resultEnum.getMsg()));
		this.code = resultEnum.getCode();
	}

	public CustomException(Integer code, String msg) {
		super(msg);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
