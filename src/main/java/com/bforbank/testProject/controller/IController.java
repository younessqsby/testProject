package com.bforbank.testProject.controller;


import java.util.List;

public interface IController<T> {

    T getById(int id);
    List<T> getAll();
    T create(T entity);
    void delete(int id);

}
