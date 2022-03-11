package org.example.Service;
import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class DefaultUserService implements UserService{


    private UserRepository userRepository;

   public DefaultUserService(){};

    @Autowired
    public void setUserRepository(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
//    public DefaultUserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public List<User> GetAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User SaveUsers(User user) {
        return  userRepository.saveAndFlush(user);
    }
}

