package org.example.Service;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class DefaultUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    public DefaultUserService(){};

    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    @Override
    public List<User> GetAllUsers() {
        return userRepository.findAll();
    }

//    public String findByEmail(String email) {
//        List<User> users=userRepository.findAll();
//        for(User user: users)
//        {
//            if(user.getEmail().equals(email))
//                return user.getPassword();
//        }
//        return "";
//    }
//
//    @Override
//    public User SaveUsers(User user) {
//        return  userRepository.saveAndFlush(user);
//    }
}

