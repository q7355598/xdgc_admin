package com.yuanbaopu.reqdomain;

import com.yuanbaopu.domain.user.UserDomain;

public class UserTokenDomain {
	public UserDomain userDomain;

	public String token;

	public UserDomain getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(UserDomain userDomain) {
		this.userDomain = userDomain;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
