package com.zhong.enums;

public enum ResponseCode {

	SUCCESS(0, "success"), 
	FAIL(-1, "服务内部错误"), //fail
	
	ERROR_PARAM(10,"参数错误"),
	
	NOT_RESULT(11,"无结果"),
	
	ERROR_UNIQUENESS(13,"违反唯一性约束"),
	
	OVER_TIME(14,"超过最晚时间"),
	
	PASSWORD(15,"用户名密码错误"),
	KEY(16,"当前Key错误"),
	MAC(17,"您所在主机Mac地址不正确"),
	NOEFFECT(18,"用户未生效"),
	SQLERROR(19,"请检查导入文件是否正确！"),
	AUDITNULL(20,"请联系管理员配置审核人！"),
	ADDFAIL(21,"添加失败！"),
	OLDPASSWORDFAIL(22,"旧密码输入错误！"),
	TABLENOTEXIST(23,"操作错误，修改内容不存在！"),
	TITLERENAME(24,"整编目录重名！"),
	ERROR_PARAM_1(25,"请检查输入的字段是否过长，类型是否匹配！"),
	AUDITNOTALL(26,"请联系管理员，完善审核人信息！"),
	TASKCLOSE(27,"任务已关闭，无法提交！"),
	NOFILE(28,"无文件！"),
	DATATOOLONG(29,"操作数据过多！"),

	NOUPDATE(1,"没有修改权限！"),
	NOSEARCH(2,"没有查询权限！"),
	NODOUBLE(3,"没有查询和修改条件！"),



	
	EXPTION_REQUEST(2000,"request handler error"), 
	SESSION_TIMEOUT(1000, "session timeout");

	private int code;
	private String msg;

	private ResponseCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
