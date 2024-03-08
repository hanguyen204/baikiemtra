package com.example.qlnv.Service;

import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();
    Optional<T>findById(int id);
    T save(T t);
    void remove(int id);
}
