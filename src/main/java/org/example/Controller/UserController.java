package org.example.Controller;

import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> GetAllUsers()
    {
        System.out.println("Login");
        return userService.GetAllUsers();
    }
    @PostMapping("/new")
    public User SaveUser(@RequestBody User user)
    {
        return userService.SaveUsers(user);
    }
}
