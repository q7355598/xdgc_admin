package com.yuanbaopu.common;

public class CommonController {
	protected static MessageResp success(Object data) {
		return buildResp(data, CommonRespConst.SUCCESS);
	}

	protected static MessageResp buildResp(Object data) {
		return buildResp(data, CommonRespConst.FAIL);
	}

	protected static MessageResp buildResp(Object data, RespCode respEnum) {
		MessageResp resp = new MessageResp();
		resp.setMessage(respEnum);
		resp.setData(data);
		return resp;
	}

	protected static MessageResp success() {
		return buildResp(null, CommonRespConst.SUCCESS);
	}

	protected static MessageResp buildResp() {
		return buildResp(null, CommonRespConst.FAIL);
	}

	protected static MessageResp buildResp(RespCode respEnum) {
		return buildResp(null, respEnum);
	}
}
