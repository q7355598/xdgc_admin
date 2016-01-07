package com.yuanbaopu.persistence.user;

import com.yuanbaopu.domain.user.UserDomain;

public interface UserDomainMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);
    
    UserDomain login(String account, String password);
}