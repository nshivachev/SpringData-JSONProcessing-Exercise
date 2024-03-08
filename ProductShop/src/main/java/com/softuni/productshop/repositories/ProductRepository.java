package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.dtos.products.ProductWithNamePriceSellerDto;
import com.softuni.productshop.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new com.softuni.productshop.domain.dtos.products.ProductWithNamePriceSellerDto(p.name, p.price, concat(p.seller.firstName, ' ', p.seller.lastName)) " +
            "from Product p " +
            "where p.price between :startPrice and :endPrice and p.buyer is null " +
            "order by p.price asc")
    List<ProductWithNamePriceSellerDto> findAllInPriceRangeBetween(BigDecimal startPrice, BigDecimal endPrice);
}
