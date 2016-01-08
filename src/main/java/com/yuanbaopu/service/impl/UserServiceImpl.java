package com.yuanbaopu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.yuanbaopu.common.RespMessageEnum;
import com.yuanbaopu.common.XdgcRException;
import com.yuanbaopu.common.utils.MD5;
import com.yuanbaopu.domain.user.UserDomain;
import com.yuanbaopu.persistence.user.UserDomainMapper;
import com.yuanbaopu.reqdomain.UserListDto;
import com.yuanbaopu.reqdomain.UserSearchNames;
import com.yuanbaopu.reqdomain.UserTokenDomain;
import com.yuanbaopu.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	public final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Resource
	private UserDomainMapper userDomainMapper;

	/**
	 * 用户登录
	 */
	@Override
	public UserTokenDomain login(String account, String password) {
		logger.info("Uservice method:login start params:account{}", account);
		UserTokenDomain userTokenDomain = new UserTokenDomain();
		// 查看用户是否存在
		UserDomain userDomain = userDomainMapper.selectByAccount(account);
		if (userDomain == null) {
			throw new XdgcRException(RespMessageEnum.USER_NOT_EXIST);
		}
		try {
			if (!MD5.validatePassword(userDomain.getPassword(), password)) {
				throw new XdgcRException(RespMessageEnum.PASSWORD_NOT_RIGHT);
			}
			userTokenDomain.setToken(userDomain.getUserUuid());
			userTokenDomain.setUserDomain(userDomain);
		} catch (Exception e) {
			throw new XdgcRException(RespMessageEnum.PASSWORD_NOT_RIGHT);
		}
		return userTokenDomain;
	}

	/**
	 * 查询用户列表
	 */
	@Override
	public PageInfo<UserListDto> queryUserList(UserSearchNames userSearchNames) {

		List<UserDomain> userDomains = userDomainMapper.queryUserList(userSearchNames);
		if (userDomains != null && userDomains.size() > 0) {
			for (UserDomain userDomain : userDomains) {
				UserListDto userListDto = new UserListDto();
				userListDto.setUserDomain(userDomain);
			}
		}

		return null;
	}

}
