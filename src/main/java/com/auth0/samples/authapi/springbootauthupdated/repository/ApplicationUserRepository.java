package com.auth0.samples.authapi.springbootauthupdated.repository;

import com.auth0.samples.authapi.springbootauthupdated.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
}
