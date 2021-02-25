package com.auth0.samples.authapi.springbootauthupdated.service;

import com.auth0.samples.authapi.springbootauthupdated.model.ApplicationUser;
import com.auth0.samples.authapi.springbootauthupdated.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private ApplicationUserRepository repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public ApplicationUserServiceImpl(ApplicationUserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public void createUser(ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = repository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());
    }
}
