package com.yuanbaopu.persistence.user;

import java.util.List;

import com.yuanbaopu.domain.user.UserDomain;
import com.yuanbaopu.reqdomain.UserSearchNames;

public interface UserDomainMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserDomain record);

    int insertSelective(UserDomain record);

    UserDomain selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserDomain record);

    int updateByPrimaryKey(UserDomain record);
    
    UserDomain selectByAccount(String account);
    
    List<UserDomain> queryUserList(UserSearchNames userSearchNames);
}