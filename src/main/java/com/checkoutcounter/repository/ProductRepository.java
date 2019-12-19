package com.checkoutcounter.repository;

import com.checkoutcounter.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("SELECT t FROM Product t WHERE t.name = ?1")
    Product findProductByName(String productName);
}
