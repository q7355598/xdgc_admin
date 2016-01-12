package com.yuanbaopu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuanbaopu.common.RespMessageEnum;
import com.yuanbaopu.common.XdgcRException;
import com.yuanbaopu.common.utils.MD5;
import com.yuanbaopu.domain.user.UserDomain;
import com.yuanbaopu.persistence.user.UserDomainMapper;
import com.yuanbaopu.reqdomain.UserSearchNames;
import com.yuanbaopu.reqdomain.UserTokenDomain;
import com.yuanbaopu.service.UserService;

@Service
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
	public PageInfo<UserDomain> queryUserList(UserSearchNames userSearchNames) {
		if (StringUtils.isEmpty(userSearchNames.getName())) {
			userSearchNames.setName(null);
		}
		if (StringUtils.isEmpty(userSearchNames.getMobile())) {
			userSearchNames.setMobile(null);
		}
		if (StringUtils.isEmpty(userSearchNames.getEmail())) {
			userSearchNames.setEmail(null);
		}
		List<UserDomain> list = null;
		PageHelper.startPage(userSearchNames.getPageNum(), userSearchNames.getPageSize());
		list = userDomainMapper.queryUserList(userSearchNames);
		 return new PageInfo<UserDomain>(list);
	}

}
