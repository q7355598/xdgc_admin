package com.yuanbaopu.common;

public class XdgcRException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private RespCode respMessage;
	
	private Throwable e;

	public XdgcRException(RespCode respMessage){
		this.respMessage = respMessage;
	}
	
	public XdgcRException(RespCode respMessage,Throwable e){
		this.respMessage = respMessage;
		this.e = e;
	}
	
	public Throwable getThrowable() {
		return e;
	}
	
	public RespCode getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(RespCode respMessage) {
		this.respMessage = respMessage;
	}

	/**
	 * 返回异常提示信息
	 */
	@Override
	public String getMessage(){
		return this.getRespMessage().getCode();
		
	}

}
