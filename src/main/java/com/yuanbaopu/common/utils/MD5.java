package com.yuanbaopu.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static final int LENGTH_16 = 16;
	public static final int LENGTH_32 = 32;

	// md5加密(16位)
	public static String encode(String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return encodeByMD5(s, LENGTH_16);
	}

	public static String encodeByMD5(String s, int length)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		StringBuffer hexVlaue = new StringBuffer();
		byte[] md5Bytes = md.digest(s.getBytes("utf-8"));
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = md5Bytes[i] & 0xFF;
			if (val < 16) {
				hexVlaue.append("0");
			}
			hexVlaue.append(Integer.toHexString(val));
		}
		if (length == 32) {
			return hexVlaue.toString();
		}
		return hexVlaue.toString().substring(8, 24);
	}

	// 验证密码是否正确
	public static boolean validatePassword(String password, String inputString)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (password.equals(encode(inputString))) {
			return true;
		} else {
			return false;
		}
	}
}
