package com.softuni.cardealer.repositories;

import com.softuni.cardealer.domains.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query(value = "select * from `car_dealer`.suppliers order by rand() limit 1", nativeQuery = true)
    Optional<Supplier> getRandomEntity();

    @Query("select s from Supplier s where s.isImporter is false")
    List<Supplier> findAllByImporterIsFalse();
}

