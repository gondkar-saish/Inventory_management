package com.saish.inventorymanagement.repository;

import com.saish.inventorymanagement.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByQuantityLessThanEqual(int quantity);
}