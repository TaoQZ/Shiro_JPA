package xyz.taoqz.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;
import xyz.taoqz.entity.UserInfo;
import xyz.taoqz.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
@RestController
public class UserInfoController {

    @Resource
    UserInfoService userInfoService;

    /**
     * 按username账户从数据库中取出用户信息
     *
     * @param username 账户
     * @return
     */
    @GetMapping("/userList")
    @RequiresPermissions("userInfo:view") // 权限管理.
    public UserInfo findUserInfoByUsername(@RequestParam String username) {
        return userInfoService.findByUsername(username);
    }

    /**
     * 简单模拟从数据库添加用户信息成功
     *
     * @return
     */
    @PostMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String addUserInfo() {
        return "addUserInfo success!";
    }

    /**
     * 简单模拟从数据库删除用户成功
     *
     * @return
     */
    @DeleteMapping("/userDelete")
    @RequiresPermissions("userInfo:delete")
    public String deleteUserInfo() {
        return "deleteUserInfo success!";
    }
}
