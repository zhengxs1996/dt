package com.qfedu.dt.dao;

import com.qfedu.dt.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查询所有的学生信息
    public List<Student> findAllStudent(@Param("sname") String sname);

    //添加学生信息
    public void addStudent(Student student);

    //通过id查找学生信息
    public Student findStudentById(Integer sid);

    //修改学生信息
    public void modifyStudent(Student student);
    //删除学生信息
    public void deleteStudent(Integer sid);
    //批量删除
    public void deleteMany(Integer[] sids);
}
