package xyz.taoqz.service;

import xyz.taoqz.entity.UserInfo;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
public interface UserInfoService {
    /** 通过username查找用户信息；*/
    public UserInfo findByUsername(String username);
}
