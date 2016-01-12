package com.yuanbaopu.service;

import com.github.pagehelper.PageInfo;
import com.yuanbaopu.domain.user.UserDomain;
import com.yuanbaopu.reqdomain.UserSearchNames;
import com.yuanbaopu.reqdomain.UserTokenDomain;

public interface UserService {
	
	UserTokenDomain login(String account, String password);

	PageInfo<UserDomain> queryUserList(UserSearchNames userSearchNames);
}
