package com.auth0.samples.authapi.springbootauthupdated.controller;

import com.auth0.samples.authapi.springbootauthupdated.model.ApplicationUser;
import com.auth0.samples.authapi.springbootauthupdated.service.ApplicationUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {

    private ApplicationUserService service;

    public ApplicationUserController(ApplicationUserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody ApplicationUser user) {
        service.createUser(user);
    }
}
