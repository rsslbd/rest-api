package com.example.maven_jstl_template.service;

import com.example.maven_jstl_template.entity.Student3;
import com.example.maven_jstl_template.repository.Student3Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student3Service {

    @Autowired
    Student3Dao stdDao;

    public void saveStudent(Student3 std){
        stdDao.save(std);
    }

    public List<Student3> getAll(){


        return stdDao.getAllStd();
    }

    public Student3 getStd(Long id) {
        return stdDao.getSingleStd(id).orElse(new Student3());
    }

    public void deleteStdById(Long id) {
        stdDao.deleteStd(id);
    }

}
