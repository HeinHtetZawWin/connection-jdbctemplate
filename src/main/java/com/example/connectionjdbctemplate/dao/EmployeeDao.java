package com.example.connectionjdbctemplate.dao;

import com.example.connectionjdbctemplate.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public void createEmployee(int id, String firstName, String lastName, String email,
                               double salary) {
//        if (id < 0) {
//            throw new IllegalArgumentException(
//                    String.format("id %s cannot be minus", id)
//            );
//        }

        jdbcTemplate.update("insert into employee(id, first_name, last_name, email, salary)" +
                "values (?,?,?,?,?)",
                id,
                firstName,
                lastName,
                email,
                salary
        );

    }

    public List<Employee> listAllEmployees() {
        return jdbcTemplate.query("select * from employee",
                this::employeeMapRow);
    }
    public void removeAll() {
        jdbcTemplate.execute("delete from employee");
    }

    @SneakyThrows
    public Employee employeeMapRow(ResultSet rs, int i) {
        return new Employee(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getDouble("salary")
        );
    }
}
