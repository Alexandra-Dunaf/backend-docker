package org.example.dao;

import java.util.List;

public interface CommonDAO<T> {

    List<T> findAll();//получить все значения

    List<T> findAll(String email);//получить все значения по емайл

    T get(long id);//найти по id

    void update(T obj);//обновить значение

    void delete(long id);//удалить по id

    void add(T obj);//добавить значение



}
