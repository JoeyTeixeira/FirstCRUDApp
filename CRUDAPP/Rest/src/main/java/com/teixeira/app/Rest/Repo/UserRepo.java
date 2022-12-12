package com.teixeira.app.Rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teixeira.app.Rest.Models.User;
public interface UserRepo extends JpaRepository<User, Long> {
}
