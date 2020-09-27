package xyz.taoqz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import xyz.taoqz.entity.Teacher;
import xyz.taoqz.entity.UserInfo;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
public interface TeacherDao  extends JpaRepository<Teacher, Integer> , JpaSpecificationExecutor<Teacher> {
    Teacher findByName(String name);
}
