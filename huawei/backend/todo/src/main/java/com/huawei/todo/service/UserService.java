package com.huawei.todo.service;

import com.huawei.todo.model.User;

public interface UserService {

    User save(User user);

    User findUserByUsernameAndPAssword(String username,String password);

    User findUserbyUsername(String username);
}
