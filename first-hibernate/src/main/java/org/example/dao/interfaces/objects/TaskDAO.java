package org.example.dao.interfaces.objects;

import org.example.dao.interfaces.CommonDAO;
import org.example.dao.interfaces.FindDAO;
import org.example.entity.Task;

import java.util.List;

public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {

    List<Task> find(boolean completed, String email);
}
