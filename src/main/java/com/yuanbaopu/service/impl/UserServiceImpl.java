package com.yuanbaopu.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuanbaopu.domain.user.UserDomain;
import com.yuanbaopu.persistence.user.UserDomainMapper;
import com.yuanbaopu.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	public UserDomainMapper userDomainMapper;

	@Override
	public UserDomain login(String account, String password) {
		
		
		
		return userDomainMapper.login(account, password);
	}

}
