package xyz.taoqz.entity;


import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author taoqz
 * Created by taoqz on 2020/9/27.
 */
@Entity
public class Teacher {
    private int id;
    private String name;

    private List<Student> students;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "teacher_student", joinColumns = {@JoinColumn(name = "teacherId")}, inverseJoinColumns = {@JoinColumn(name = "studentId")})
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id &&
                Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }



}
