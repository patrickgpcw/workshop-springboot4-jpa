package com.patrick.workshopspringboot4jpa.repositories;

import com.patrick.workshopspringboot4jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
