package com.yuanbaopu.controller.customer;

import com.github.pagehelper.PageInfo;
import com.yuanbaopu.common.CommonController;
import com.yuanbaopu.common.MessageResp;
import com.yuanbaopu.common.RespMessageEnum;
import com.yuanbaopu.common.utils.LogInfo;
import com.yuanbaopu.domain.user.UserDomain;
import com.yuanbaopu.reqdomain.UserSearchNames;
import com.yuanbaopu.reqdomain.UserTokenDomain;
import com.yuanbaopu.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends CommonController {
    public final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 用户登录
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public MessageResp login(String name, String password) {
        logger.info(LogInfo.OPTLOGTPL, "", "登录");
        Map<String, String> errorMap = new HashMap<String, String>();
        if (StringUtils.isEmpty(password)) {
            errorMap.put("password", password);
            return buildResp(errorMap, RespMessageEnum.ARGS_ERROR);
        }
        UserTokenDomain userToken = null;
        userToken = userService.login(name, password);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("token", userToken.getToken());
        data.put("userDomain", userToken.getUserDomain());
        return success(data);
    }

    /**
     * 查询用户列表
     *
     * @param token
     * @param userSearchNames
     * @return
     */
    @RequestMapping(value = "/queryUserList", method = RequestMethod.POST)
    @ResponseBody
    public MessageResp queryUserList(String token, UserSearchNames userSearchNames) {
        logger.info(LogInfo.OPTLOGTPL, token, "查询用户列表");
        logger.info("userSearchNames={}", LogInfo.toJson(userSearchNames));
        PageInfo<UserDomain> userList = userService.queryUserList(userSearchNames);
        return success(userList);
    }

}
