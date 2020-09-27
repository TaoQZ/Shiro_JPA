package xyz.taoqz.service;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import xyz.taoqz.dao.TeacherDao;
import xyz.taoqz.entity.Teacher;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
@Service
public class TeacherService {

    private final TeacherDao teacherDao;

    public TeacherService(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public List<Teacher> findByIdIn(List<Integer> ids) {
        return teacherDao.findAll(createSpecification(null,ids));
    }

    private Specification<Teacher> createSpecification(Teacher teacher,List<Integer> ids) {
        return (Specification<Teacher>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            predicateList.add(root.get("id").in(ids));
            if (null != teacher){
                if (StrUtil.isNotBlank(teacher.getName())) {
                    predicateList.add(criteriaBuilder.like(root.get("name").as(String.class), teacher.getName()));
                }
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        };
    }



}
