package com.saish.inventorymanagement.service.impl;

import com.saish.inventorymanagement.dto.StockUpdateRequest;
import com.saish.inventorymanagement.entity.Product;
import com.saish.inventorymanagement.entity.StockTransaction;
import com.saish.inventorymanagement.exception.ResourceNotFoundException;
import com.saish.inventorymanagement.repository.ProductRepository;
import com.saish.inventorymanagement.repository.StockTransactionRepository;
import com.saish.inventorymanagement.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockTransactionRepository stockTransactionRepository;

    @Override
    public StockTransaction stockIn(StockUpdateRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + request.getProductId()));

        if (request.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        product.setQuantity(product.getQuantity() + request.getQuantity());
        productRepository.save(product);

        StockTransaction transaction = new StockTransaction();
        transaction.setProduct(product);
        transaction.setType("IN");
        transaction.setQuantity(request.getQuantity());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setNote(request.getNote());

        return stockTransactionRepository.save(transaction);
    }

    @Override
    public StockTransaction stockOut(StockUpdateRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + request.getProductId()));

        if (request.getQuantity() <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        if (product.getQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock available");
        }

        product.setQuantity(product.getQuantity() - request.getQuantity());
        productRepository.save(product);

        StockTransaction transaction = new StockTransaction();
        transaction.setProduct(product);
        transaction.setType("OUT");
        transaction.setQuantity(request.getQuantity());
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setNote(request.getNote());

        return stockTransactionRepository.save(transaction);
    }

    @Override
    public List<StockTransaction> getAllTransactions() {
        return stockTransactionRepository.findAll();
    }

    @Override
    public List<StockTransaction> getTransactionsByProductId(int productId) {
        return stockTransactionRepository.findByProductId(productId);
    }
}