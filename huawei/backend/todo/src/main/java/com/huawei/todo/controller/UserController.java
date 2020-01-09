package com.huawei.todo.controller;

import com.huawei.todo.doa.UserRepository;
import com.huawei.todo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/sign-up")
    public ResponseEntity<User> createUser(@RequestBody User user){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encodedPassword = encoder.encode(user.getPassword());

        user.setPassword(encodedPassword);

        User newUser = userRepository.save(user);

        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }
}
