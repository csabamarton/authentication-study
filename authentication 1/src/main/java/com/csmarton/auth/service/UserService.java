package com.csmarton.auth.service;

import com.csmarton.auth.model.User;

public interface UserService {

    public Integer saveUser(User user);

    Integer validateCredential(String userName, String password);
}
