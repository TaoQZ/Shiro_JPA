package xyz.taoqz.service.impl;

import org.springframework.stereotype.Service;
import xyz.taoqz.dao.UserInfoDao;
import xyz.taoqz.entity.UserInfo;
import xyz.taoqz.service.UserInfoService;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
@Service
//@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
