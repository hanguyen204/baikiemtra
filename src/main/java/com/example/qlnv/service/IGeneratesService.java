package com.example.qlnv.service;

import java.util.Optional;

public interface IGeneratesService<T> {
    Iterable<T> findAll();
    Optional<T>findById(int id);
    T save(T t);
    void remove(int id);
}
