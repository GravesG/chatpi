package com.im.chatpi.common.user.controller;

import com.im.chatpi.common.common.domain.vo.response.ApiResult;
import com.im.chatpi.common.user.domain.vo.response.user.UserInfoResp;
import com.im.chatpi.common.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chatpi/user")
@Api(tags = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    @ApiOperation("用户详情")
    public ApiResult<UserInfoResp> getUserInfo(@RequestParam Long userId) {
        return ApiResult.success(userService.getUserInfo(userId));
    }

}
