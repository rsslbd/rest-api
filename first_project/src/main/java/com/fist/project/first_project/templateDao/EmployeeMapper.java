package com.fist.project.first_project.templateDao;

import com.fist.project.first_project.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setId(resultSet.getLong("id"));
		employee.setName(resultSet.getString("name"));
		employee.setAddress(resultSet.getString("address"));
		return employee;
	}
}
