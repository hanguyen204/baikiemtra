package com.example.qlnv.service;


import com.example.qlnv.model.Computer;
import com.example.qlnv.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputersService {
    @Autowired
    private IComputerRepository iComputerRepository;
    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(int id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return iComputerRepository.save(computer);
    }

    @Override
    public void remove(int id) {
        iComputerRepository.deleteById(id);
    }
}
