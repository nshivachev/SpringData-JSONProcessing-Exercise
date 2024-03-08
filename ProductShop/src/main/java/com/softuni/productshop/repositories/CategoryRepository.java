package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto;
import com.softuni.productshop.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select * from `product_shop`.categories order by rand() limit 1", nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query("select new com.softuni.productshop.domain.dtos.categories.CategoryProductSummaryDto(c.name, count(p.id), avg(p.price), sum(p.price)) " +
            "from Product p " +
            "join p.categories c " +
            "group by c.id " +
            "order by count(p.id) desc")
    List<CategoryProductSummaryDto> getCategorySummary();
}
