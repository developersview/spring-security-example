package com.developersview.SpringSecurityExample.service;

/**
 * @author pranoy.chakraborty
 * @Date 31/07/22
 */
public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
