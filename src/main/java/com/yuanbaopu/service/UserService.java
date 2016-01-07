package com.yuanbaopu.service;

import com.yuanbaopu.domain.user.UserDomain;

public interface UserService {
	UserDomain login(String account, String password);

}
