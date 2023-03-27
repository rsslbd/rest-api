package com.example.maven_jstl_template.repository;

import com.example.maven_jstl_template.entity.Student3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Student3Dao {

    private final JdbcTemplate jdbc;

    @Autowired
    public Student3Dao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final String SQL_insert = "insert into student3(name, gender, dob, education, subject) values(?,?,?,?,?)";
    private final String SQL_selectAll = "select * from student3";
    private final String SQL_findOne = "select * from student3 where id = ?";
    private final String SQL_update = "update student3 set name=?, gender=?, dob=?, education=?, subject=? where id=?";
    private final String SQL_delete = "delete from student3 where id=?";


    public boolean save(Student3 std) {
        String education="";


        try {

            if (std.getJsc()!=null){
                education = education+" "+std.getJsc();
            }
            if (std.getSsc()!=null){
                education = education+" "+std.getSsc();
            }
            if (std.getHsc()!=null){
                education = education+" "+std.getHsc();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        if(std.getId() == null) {

            return jdbc.update(SQL_insert, std.getName(), std.getGender(), std.getDob(),
                    education, std.getSubject()) > 0;
        } else {

            return jdbc.update(SQL_update, std.getName(), std.getGender(), std.getDob(), education, std.getSubject(), std.getId()) > 0;
        }
    }

    public Optional<Student3> getSingleStd(Long id) {
        return Optional.ofNullable(jdbc.queryForObject(SQL_findOne, new Object[]{id}, new Student3Mapper()));
    }

    public List<Student3> getAllStd() {
        return jdbc.query(SQL_selectAll, new Student3Mapper());
    }

    public boolean deleteStd(Long id) {
        return jdbc.update(SQL_delete, id) > 0;
    }

}
