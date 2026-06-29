package com.saish.inventorymanagement.service;

import com.saish.inventorymanagement.dto.StockUpdateRequest;
import com.saish.inventorymanagement.entity.StockTransaction;
import java.util.List;

public interface StockService {

    StockTransaction stockIn(StockUpdateRequest request);

    StockTransaction stockOut(StockUpdateRequest request);

    List<StockTransaction> getAllTransactions();

    List<StockTransaction> getTransactionsByProductId(int productId);
}