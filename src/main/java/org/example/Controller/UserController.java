package org.example.Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@SecurityRequirement(name = "ShivangAPI")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/api")
    @Cacheable(value ="apis")
    public List<User> GetAllUsers() {
        return userService.GetAllUsers();
    }

    @RequestMapping("/")
    public String Viewhomepage() {
        return "index";
    }

    @RequestMapping(value = "/logins", method = RequestMethod.POST)
    public ModelAndView Log_IN(@ModelAttribute User user) {

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
    public  void SaveUserDB(@ModelAttribute User user) {
        userService.SaveUsers(user);

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

