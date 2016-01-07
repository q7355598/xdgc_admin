package common;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.yuanbaopu.common.utils.MD5;

public class MD5Test {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String pwd1 = "000000";
		String pwd2 = "";
		System.out.println("未加密的密码:" + pwd1);
		// 将123加密
		pwd2 = MD5.encodeByMD5(pwd1, 16);
		System.out.println("加密后的密码:" + pwd2);

		System.out.print("验证密码是否下确:");
		if (MD5.validatePassword(pwd2, pwd1)) {
			System.out.println("正确");
		} else {
			System.out.println("错误");
		}
	}
}
