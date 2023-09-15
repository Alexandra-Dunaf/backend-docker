package org.example.dao.interfaces.objects;

import org.example.dao.interfaces.CommonDAO;
import org.example.entity.Activity;
import org.example.entity.User;

public interface ActivityDAO extends CommonDAO<Activity> {

    Activity getByUser(String email);
    Activity getByUser(User user);
}
