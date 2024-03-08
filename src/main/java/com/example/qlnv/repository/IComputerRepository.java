package com.example.qlnv.repository;

import com.example.qlnv.model.Computer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends CrudRepository<Computer, Integer> {
}
