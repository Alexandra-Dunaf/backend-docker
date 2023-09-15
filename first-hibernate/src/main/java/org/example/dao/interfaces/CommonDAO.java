package org.example.dao.interfaces;

import java.util.List;

public interface CommonDAO<T> {

    T get(long id);//найти по id

    void update(T obj);//обновить значение

    void delete(long id);//удалить по id

    void add(T obj);//добавить значение



}
