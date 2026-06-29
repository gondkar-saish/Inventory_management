package com.saish.inventorymanagement.service;

import com.saish.inventorymanagement.dto.ProductRequest;
import com.saish.inventorymanagement.entity.Product;
import java.util.List;

public interface ProductService {

    Product addProduct(ProductRequest request);

    List<Product> getAllProducts();

    Product getProductById(int id);

    Product updateProduct(int id, ProductRequest request);

    String deleteProduct(int id);

    List<Product> getLowStockProducts();

}