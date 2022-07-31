package com.developersview.SpringSecurityExample.service;

import com.developersview.SpringSecurityExample.model.User;

/**
 * @author pranoy.chakraborty
 * @Date 31/07/22
 */
public interface UserService {
    void User(User user);
    User findByUserName(String username);
}
