package com.yuanbaopu.service;


import com.yuanbaopu.domain.User;

public interface UserService {
	User login(String account, String password);

}
