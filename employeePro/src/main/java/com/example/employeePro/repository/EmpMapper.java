package com.example.employeePro.repository;



import com.example.employeePro.entity.Employee;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int i) throws SQLException {
        Employee e = new Employee();
        e.setId(rs.getLong("id"));
        e.setName(rs.getString("name"));
        e.setEmail(rs.getString("email"));
        e.setDesignation(rs.getString("designation"));
        e.setEducation(rs.getString("education"));
        e.setGender(rs.getString("gender"));
        e.setSalary(rs.getLong("salary"));
        e.setJoiningDate(rs.getString("joiningDate"));

        try {
            String line = rs.getString("education");
            String[] arr = line.split(" ");

            for (String st:arr
            ) {
                if(st.equals("HSC")){
                    e.setSsc(st);
                }
                if(st.equals("HSC")){
                    e.setHsc(st);
                }
                if(st.equals("BSc")){
                    e.setBsc(st);
                }
                if(st.equals("MSc")){
                    e.setMsc(st);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

}

