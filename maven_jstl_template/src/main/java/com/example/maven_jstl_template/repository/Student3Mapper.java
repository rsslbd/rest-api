package com.example.maven_jstl_template.repository;

import com.example.maven_jstl_template.entity.Student3;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Student3Mapper implements RowMapper<Student3> {
    @Override
    public Student3 mapRow(ResultSet rs, int i) throws SQLException {
        Student3 std = new Student3();
        std.setId(rs.getLong("id"));
        std.setName(rs.getString("name"));
        std.setGender(rs.getString("gender"));
        std.setDob(rs.getString("dob"));
        std.setEducation(rs.getString("education"));

        try {
             String line = rs.getString("education");
             String[] arr = line.split(" ");

             for (String st:arr
                  ) {
                 if(st.equals("JSC")){
                     std.setJsc(st);
                 }
                 if(st.equals("SSC")){
                     std.setSsc(st);
                 }
                 if(st.equals("HSC")){
                     std.setHsc(st);
                 }
             }

         } catch (Exception e) {
             e.printStackTrace();
         }
        std.setSubject(rs.getString("subject"));
        return std;
    }

}
