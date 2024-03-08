package com.example.qlnv.service;

import com.example.qlnv.model.Employee;
import com.example.qlnv.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        iEmployeeRepository.deleteById(id);
    }
}
