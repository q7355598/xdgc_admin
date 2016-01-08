package com.yuanbaopu.service;

import com.github.pagehelper.PageInfo;
import com.yuanbaopu.reqdomain.UserListDto;
import com.yuanbaopu.reqdomain.UserSearchNames;
import com.yuanbaopu.reqdomain.UserTokenDomain;

public interface UserService {
	UserTokenDomain login(String account, String password);
	PageInfo<UserListDto> queryUserList(UserSearchNames userSearchNames);
}
