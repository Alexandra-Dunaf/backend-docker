package org.example.dao.interfaces.objects;

import org.example.dao.interfaces.CommonDAO;
import org.example.entity.User;
import org.example.dao.interfaces.FindDAO;

public interface UserDAO extends CommonDAO<User>, FindDAO<User> {

    User getByEmail(String email);
}
