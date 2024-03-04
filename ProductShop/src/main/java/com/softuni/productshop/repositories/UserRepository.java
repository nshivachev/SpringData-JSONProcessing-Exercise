package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
