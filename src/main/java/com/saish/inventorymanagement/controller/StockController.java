package com.saish.inventorymanagement.controller;

import com.saish.inventorymanagement.dto.StockUpdateRequest;
import com.saish.inventorymanagement.entity.StockTransaction;
import com.saish.inventorymanagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping("/in")
    public StockTransaction stockIn(@RequestBody StockUpdateRequest request) {
        return stockService.stockIn(request);
    }

    @PostMapping("/out")
    public StockTransaction stockOut(@RequestBody StockUpdateRequest request) {
        return stockService.stockOut(request);
    }

    @GetMapping("/transactions")
    public List<StockTransaction> getAllTransactions() {
        return stockService.getAllTransactions();
    }

    @GetMapping("/transactions/product/{productId}")
    public List<StockTransaction> getTransactionsByProductId(@PathVariable int productId) {
        return stockService.getTransactionsByProductId(productId);
    }
}