package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from `product_shop`.users order by rand() limit 1", nativeQuery = true)
    Optional<User> getRandomEntity();
}
