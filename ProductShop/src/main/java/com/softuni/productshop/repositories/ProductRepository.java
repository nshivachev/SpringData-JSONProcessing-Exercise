package com.softuni.productshop.repositories;

import com.softuni.productshop.domain.dtos.products.ProductPriceNameSellerDto;
import com.softuni.productshop.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new com.softuni.productshop.domain.dtos.products.ProductPriceNameSellerDto(p.name, p.price, p.seller) " +
            "from Product p " +
            "where p.price between :startPrice and :endPrice and p.buyer is null " +
            "order by p.price asc")
    List<ProductPriceNameSellerDto> findAllInPriceRangeBetween(BigDecimal startPrice, BigDecimal endPrice);
}
