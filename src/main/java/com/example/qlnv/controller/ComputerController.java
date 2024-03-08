package com.example.qlnv.controller;

import com.example.qlnv.service.IComputersService;
import com.example.qlnv.model.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {
    @Autowired
    private IComputersService iComputerService;

    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllComputers() {
        List<Computer> computers = (List<Computer>) iComputerService.findAll();
        if (computers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(computers,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> findComputerById(@PathVariable int id) {
        Optional<Computer> employee = iComputerService.findById(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Computer> saveComputer(@RequestBody Computer computer) {
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable int id, @RequestBody Computer computer) {
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.setId(computerOptional.get().getId());
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteComputer(@PathVariable int id) {
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iComputerService.remove(id);
        return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
    }
}
