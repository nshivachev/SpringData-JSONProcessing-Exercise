package com.softuni.cardealer.repositories;

import com.softuni.cardealer.domains.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from `car_dealer`.customers order by rand() limit 1", nativeQuery = true)
    Optional<Customer> getRandomEntity();
}
