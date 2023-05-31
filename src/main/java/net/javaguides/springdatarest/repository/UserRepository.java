package net.javaguides.springdatarest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springdatarest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
