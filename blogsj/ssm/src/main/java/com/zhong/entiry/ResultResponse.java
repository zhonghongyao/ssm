package com.zhong.entiry;

import com.zhong.enums.ResponseCode;

public class ResultResponse<T> {

	/**
	 * 数据实体bean，可以为分页结果pager，也可以是任意实例对象
	 */
	private T result;

	/**
	 * 相应状态
	 */
	private int code;

	/**
	 * 返回消息
	 */
	private String message;

	/**
	 * 构建响应信息
	 * 
	 * @param code
	 *            编码
	 * @param message
	 *            消息
	 */
	public ResultResponse(int code, String message) {
		this(null, code, message);
	}
	/**
	 * 构建响应信息
	 * 
	 * @param result
	 *            数据实体
	 * @param response
	 *            消息枚举
	 */
	public ResultResponse(T result, ResponseCode response) {
		this(result, response.getCode(), response.getMsg());
	}

	/**
	 * 构建响应信息
	 * 
	 * @param result
	 *            数据实体
	 * @param response
	 *            消息枚举
	 */
	public ResultResponse(ResponseCode response) {
		this(null, response.getCode(), response.getMsg());
	}

	/**
	 * 构建响应信息bean
	 * 
	 * @param result
	 *            数据实体
	 * @param code
	 *            编码
	 * @param message
	 *            响应成功或失败结果
	 */
	public ResultResponse(T result, int code, String message) {
		this.result = result;
		this.code = code;
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
