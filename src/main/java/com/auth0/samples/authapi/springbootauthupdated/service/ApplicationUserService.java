package com.auth0.samples.authapi.springbootauthupdated.service;

import com.auth0.samples.authapi.springbootauthupdated.model.ApplicationUser;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface ApplicationUserService extends UserDetailsService {
    void createUser(ApplicationUser user);
}
