package org.example.Service;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
        System.out.println("hello to Users -DB");
        return userRepository.findAll();
    }

    @Override
    public void SaveUsers(User user) {
        userRepository.saveAndFlush(user);
    }
}

