package com.yuanbaopu.common;

public class MessageResp {
	protected String code = "100200";
	protected String msg = "";
	protected Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public String getRespMsg() {
		return msg;
	}

	public void setRespMsg(String respMsg) {
		this.msg = respMsg;
	}

	public void setMessage(RespCode respCode) {
		code = respCode.getCode();
		msg = respCode.getContent();
	}

	public void setMessageWithAppend(RespCode respCode, String appendMsg) {
		code = respCode.getCode();
		msg = respCode.getContent() + "," + appendMsg;
	}
}
