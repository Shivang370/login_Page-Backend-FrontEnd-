package org.example.Controller;
import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    private String name;

    @GetMapping
    public List<User> GetAllUsers() {
        System.out.println(userService.GetAllUsers());
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
                    name = user1.getName();
                    System.out.println(name);
                    modelAndView.setViewName("Success");
                    modelAndView.addObject("user", user);
                    return modelAndView;
                }
            }
        }

        return new ModelAndView();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String SaveUserDB(@ModelAttribute User user) {
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

    @RequestMapping("/Success")
    public ModelAndView Log_I() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Success");
            return modelAndView;
    }
}

