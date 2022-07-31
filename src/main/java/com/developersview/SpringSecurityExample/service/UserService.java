package com.developersview.SpringSecurityExample.service;

import com.developersview.SpringSecurityExample.model.User;

/**
 * @author pranoy.chakraborty
 * @Date 31/07/22
 */
public interface UserService {
    void save(User user);
    User findByUserName(String username);
}
