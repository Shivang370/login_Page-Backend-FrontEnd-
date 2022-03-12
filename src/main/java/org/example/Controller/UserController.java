package org.example.Controller;

import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> GetAllUsers()
    {
        System.out.println(userService.GetAllUsers());
        return userService.GetAllUsers();
    }
//    @PostMapping("/new")
//    public User SaveUser(@RequestBody User user)
//    {
//        return userService.SaveUsers(user);
//    }
//    @RequestMapping(value ="/login",method =RequestMethod.POST)
//    public String login(@RequestParam("email") String email,@RequestParam("password") String password)
//    {
//        String user=userService.findByEmail(email);
//        if(user.equals(password))
//            return " Login Successful !!";
//        else
//            return "Invalid Username or Password. Please try again !!";
//    }
//    @RequestMapping(value="/register",method =RequestMethod.POST)
//    public String SaveUser(@ModelAttribute User user)
//    {
//         userService.SaveUsers(user);
//         return "/login";
//    }

}
