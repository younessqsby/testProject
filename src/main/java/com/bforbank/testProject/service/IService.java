package com.bforbank.testProject.service;

import java.util.List;

public interface IService<T>{

    T findById(int id);
    List<T> findAll();
    T save(T entity);
    void deleteById(int id);
}
