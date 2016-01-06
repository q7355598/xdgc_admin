package com.yuanbaopu.common;

public class RespCode {

	protected String mCode;
	protected String mContent;
	
	public String getCode() {
		return mCode;
	}
	public void setCode(String code) {
		this.mCode = code;
	}
	public String getContent() {
		return mContent;
	}
	public void setContent(String content) {
		this.mContent = content;
	}
	public RespCode(String code, String msg) {
		this.mCode = code;
		this.mContent = msg;
	}
	
}
