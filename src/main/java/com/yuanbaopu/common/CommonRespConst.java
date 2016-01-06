package com.yuanbaopu.common;

public class CommonRespConst {
	public final static RespCode SUCCESS = new RespCode("100200", "成功"),
			FAIL = new RespCode("101400", "服务异常"), 
			FILE_UPLOAD = new RespCode("101402", "文件上传错误"),
			DB_ERROR = new RespCode("101403", "操作数据库异常"),
			ARGS_ERROR = new RespCode("101401", "参数错误");
}
