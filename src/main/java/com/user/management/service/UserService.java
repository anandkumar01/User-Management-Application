package com.user.management.service;

import com.user.management.model.UserDetails;

public interface UserService {

    UserDetails createUser(UserDetails user);

    boolean checkEmail(String email);

    UserDetails validateUser(String email, String password);

}
