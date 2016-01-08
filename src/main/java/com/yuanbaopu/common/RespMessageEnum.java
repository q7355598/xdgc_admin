package com.yuanbaopu.common;

public class RespMessageEnum {
	public final static RespCode USER_NOT_EXIST = new RespCode("100300", "用户不存在");
	public final static RespCode PASSWORD_NOT_RIGHT = new RespCode("100301", "密码不正确");
	public final static RespCode ARGS_ERROR = new RespCode("100302", "参数错误");
}
