package com.fist.project.first_project.templateDao;

import com.fist.project.first_project.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDao_ {

//	JdbcTemplate jdbcTemplate;
//	@Autowired
//	public EmployeeDao_(DataSource dataSource) {
//		jdbcTemplate = new JdbcTemplate(dataSource);
//	}

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDao_(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	private final String SQL_FIND_EMPLOYEE = "select * from employee where id = ?";
	private final String SQL_DELETE_EMPLOYEE = "delete from employee where id = ?";
	private final String SQL_UPDATE_EMPLOYEE = "update employee set name = ?, address = ? where id = ?";
	private final String SQL_GET_ALL = "select * from employee";
	private final String SQL_INSERT_EMPLOYEE = "insert into employee( name, address ) values( ?,? )";


	public Optional<Employee> findById(Long id) {
		return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[]{id}, new EmployeeMapper()));
	}

	public Employee findById2(Long id) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[]{id}, new EmployeeMapper());
	}

	public List<Employee> findAll() {
		return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
	}

	public boolean deleteById(Long id) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, id) > 0;
	}

//	public boolean updatePerson(Employee employee) {
//		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getName(), employee.getAddress(),employee.getId()) > 0;
//	}

	public boolean save(Employee employee) {
		if(employee.getId()==null){
			return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getName(), employee.getAddress()) > 0;
		}else {
			return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getName(), employee.getAddress(),employee.getId()) > 0;
		}
	}
}
