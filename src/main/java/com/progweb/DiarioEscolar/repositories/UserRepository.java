package com.progweb.DiarioEscolar.repositories;

import com.progweb.DiarioEscolar.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}