package xyz.taoqz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.taoqz.dao.TeacherDao;
import xyz.taoqz.entity.Student;
import xyz.taoqz.entity.Teacher;
import xyz.taoqz.service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class ShiroStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void demo(){
        Teacher teacher = teacherDao.findByName("lm");
        System.out.println(teacher.getName());
        List<Student> students = teacher.getStudents();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    @Autowired
    private TeacherService teacherService;

    @Test
    public void demo2(){
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        List<Teacher> byIdIn = teacherService.findByIdIn(integers);
        List<String> collect = byIdIn.stream().map(Teacher::getName).map(String::valueOf).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
