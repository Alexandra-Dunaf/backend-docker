package org.example.dao.interfaces.objects;

import org.example.entity.Stat;
import org.example.entity.User;

public interface StatDAO<Stat> {

    Stat getByUser(String email);
    Stat getByUser(User user);
}
