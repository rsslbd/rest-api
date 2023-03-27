package com.example.employeePro.repository;

import com.example.employeePro.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;

@Component
public class Empdao{

    private final JdbcTemplate jdbc;

    @Autowired
    public Empdao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final String SQL_insert = "insert into student3(name,email,designation,education, gender, salary, joiningdate) values(?,?,?,?,?,?,?)";
    private final String SQL_selectAll = "select * from employee";
    private final String SQL_findOne = "select * from employee where id = ?";
    private final String SQL_update = "update employee set name=?,email=?,designation=?,education=?, gender=?, salary=?, joiningdate=? where id=?";
    private final String SQL_delete = "delete from employee where id=?";


    public boolean save(Employee e) {
        String education="";


        try {

            if (e.getSsc()!=null){
                education = education+" "+e.getSsc();
            }
            if (e.getHsc()!=null){
                education = education+" "+e.getHsc();
            }
            if (e.getBsc()!=null){
                education = education+" "+e.getBsc();
            }
            if (e.getMsc()!=null){
                education = education+" "+e.getMsc();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        if(e.getId() == null) {

            return jdbc.update(SQL_insert, e.getName(),e.getEmail(), e.getDesignation(), education, e.getGender(),e.getSalary(), e.getJoiningDate()) > 0;
        } else {

            return jdbc.update(SQL_update,  e.getName(),e.getEmail(), e.getDesignation(), education, e.getGender(),e.getSalary(), e.getJoiningDate()) > 0;
        }
    }

    public Optional<Employee> getSingleEmp(Long id) {
        return Optional.ofNullable(jdbc.queryForObject(SQL_findOne, new Object[]{id}, new EmpMapper()));
    }

    public List<Employee> getAllEmp()  {
        return jdbc.query(SQL_selectAll, new EmpMapper());
    }

    public boolean deleteEmp(Long id) {
        return jdbc.update(SQL_delete, id) > 0;
    }

}