package com.example.connectionjdbctemplate.service;

import com.example.connectionjdbctemplate.dao.EmployeeDao;
import com.example.connectionjdbctemplate.ds.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDao dao;

    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }
    @Transactional
    public void createEmployeeWithTransaction() throws InterruptedException {
        saveEmployee();
        throw new RuntimeException();
    }

    public void createEmployeeWithoutTransaction() throws  InterruptedException {
        saveEmployee();
    }

    public List<Employee> listAllEmployee() {
        return dao.listAllEmployees();
    }

    public void deleteAll() {
        dao.removeAll();
    }
    private void saveEmployee()  {
        dao.createEmployee(1, "Thaw", "Thaw", "thaw@gmail.com",
                1000);
        dao.createEmployee(2, "Thomas", "Hardy", "thomas@gmail.com",
                2000);
        dao.createEmployee(3, "Harkuri", "Murakami", "murakami@gmail.com",
                1000);
    }
}
