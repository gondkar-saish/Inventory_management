package com.saish.inventorymanagement.repository;

import com.saish.inventorymanagement.entity.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockTransactionRepository extends JpaRepository<StockTransaction, Integer> {

    List<StockTransaction> findByProductId(int productId);
}