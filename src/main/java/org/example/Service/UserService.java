package org.example.Service;

import org.example.Model.User;

import java.util.List;

public interface UserService {
    List<User> GetAllUsers();
    void SaveUsers(User user);
}
