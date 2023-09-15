package org.example.dao.interfaces;

import java.util.List;

public interface FindDAO<T> {

    List<T> findAll();//получить все значения

    List<T> findAll(String email);//получить все значения по емайл
}
