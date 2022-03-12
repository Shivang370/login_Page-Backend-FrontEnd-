package org.example.Controller;

import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> GetAllUsers() {
        System.out.println(userService.GetAllUsers());
        return userService.GetAllUsers();
    }

    @RequestMapping("/")
    public String Viewhomepage() {
        return "index";
    }

//    @RequestMapping(value ="/login",method =RequestMethod.POST)
//    public String login(@ModelAttribute User user)
//    {
//        System.out.println("hhh");
//        String userpassword=userService.findByEmail(user.getEmail());
//        if(userpassword.equals(user.getPassword()))
//            return "homepage";
//        else
//            return "Invalid Username or Password. Please try again !!";
//    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView logedIn(@ModelAttribute User user) {

        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.GetAllUsers();
        for (User user1 : users) {
            if (user1.getEmail().equals(user.getEmail())) {
                if (user1.getPassword().equals(user.getPassword())) {
                    user.setName(user1.getName());
                    modelAndView.setViewName("Success");
                    modelAndView.addObject("user", user);
                    return modelAndView;
                }
            }
        }

        return new ModelAndView();
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String SaveUser(@ModelAttribute User user) {
        userService.SaveUsers(user);
        return "signup";
    }

    @RequestMapping("/AddUser")
    public String AddUserPage() {
        return "signup";
    }

    @RequestMapping("/Logout")
    public String Logout() {
        return "index";
    }
}
