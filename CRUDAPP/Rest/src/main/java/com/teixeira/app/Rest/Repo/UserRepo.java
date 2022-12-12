package com.teixeira.app.Rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teixeira.app.Rest.Models.User;
public interface UserRepo extends JpaRepository<User, Long> {
    /*creates a user repository from the JPA repository,
    Angle brackets indicates we are keeping track of "Users" 
    that are uniquely identifed by "Long" variable

    */
}
