package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from `product_shop`.users order by rand() limit 1", nativeQuery = true)
    Optional<User> getRandomEntity();

    @Query("select u from User u join Product p on u.id = p.seller.id where p.buyer is not null order by u.lastName, u.firstName")
    List<User> findAllBySellingProductsBuyerIsNotNullOrderByLastName();
}
