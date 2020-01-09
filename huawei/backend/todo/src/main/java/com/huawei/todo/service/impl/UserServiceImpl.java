package com.huawei.todo.service.impl;

import com.huawei.todo.doa.UserRepository;
import com.huawei.todo.model.User;
import com.huawei.todo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {
        return (User) userRepository.save(user);
    }

    @Override
    public User findUserByUsernameAndPAssword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User findUserbyUsername(String username) {
        return userRepository.findUserbyUsername(username);
    }
}
