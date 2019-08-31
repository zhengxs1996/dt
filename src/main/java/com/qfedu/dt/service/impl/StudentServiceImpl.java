package com.qfedu.dt.service.impl;

import com.github.pagehelper.PageHelper;
import com.qfedu.dt.dao.StudentDao;
import com.qfedu.dt.entity.Student;
import com.qfedu.dt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired(required = false)
    private StudentDao studentDao;

    @Override
    public List<Student> findAllStudent(Integer page, Integer limit,String sname) {
        PageHelper.startPage(page,limit);
        List<Student> students = studentDao.findAllStudent(sname);
        return students;
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);

    }

    @Override
    public Student findStudentById(Integer sid) {
        return studentDao.findStudentById(sid);
    }

    @Override
    public void modifyStudent(Student student) {
        studentDao.modifyStudent(student);

    }

    @Override
    public void deleteStudent(Integer sid) {
        studentDao.deleteStudent(sid);

    }

    @Override
    public void deleteMany(Integer[] sids) {
        studentDao.deleteMany(sids);
    }
}
