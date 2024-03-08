package com.example.qlnv.controller;

import com.example.qlnv.service.IEmployeeService;
import com.example.qlnv.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping
    public ResponseEntity<Iterable<Employee>> findAllEmployees() {
        List<Employee> employees = (List<Employee>) iEmployeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        Optional<Employee> employee = iEmployeeService.findById(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee) {
        return new ResponseEntity<>(iEmployeeService.save(employee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateCustomer(@PathVariable int id, @RequestBody Employee customer) {
        Optional<Employee> customerOptional = iEmployeeService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iEmployeeService.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployees(@PathVariable int id) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);
        if (!employeeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iEmployeeService.remove(id);
        return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
    }
}
