package com.Sunbase.dev.service;

import java.util.List;
import com.Sunbase.dev.repository.User;

public interface IUserService {
    List<User> getAll();
    User getById(long id);
    User add(User user);
    boolean delete(long id);
    User update(User user, long id);
}
