package xyz.taoqz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.taoqz.entity.UserInfo;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    /** 通过username查找用户信息*/
    public UserInfo findByUsername(String username);
}
