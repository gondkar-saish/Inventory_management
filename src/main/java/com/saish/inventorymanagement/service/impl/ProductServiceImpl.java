package com.saish.inventorymanagement.service.impl;

import com.saish.inventorymanagement.dto.ProductRequest;
import com.saish.inventorymanagement.entity.Product;
import com.saish.inventorymanagement.entity.Supplier;
import com.saish.inventorymanagement.exception.ResourceNotFoundException;
import com.saish.inventorymanagement.repository.ProductRepository;
import com.saish.inventorymanagement.repository.SupplierRepository;
import com.saish.inventorymanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Product addProduct(ProductRequest request) {
        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + request.getSupplierId()));

        Product product = new Product();

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setQuantity(request.getQuantity());
        product.setLowStockLimit(request.getLowStockLimit());
        product.setPrice(request.getPrice());
        product.setSupplier(supplier);

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Override
    public Product updateProduct(int id, ProductRequest request) {
        Product product = getProductById(id);

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + request.getSupplierId()));

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setQuantity(request.getQuantity());
        product.setLowStockLimit(request.getLowStockLimit());
        product.setPrice(request.getPrice());
        product.setSupplier(supplier);

        return productRepository.save(product);
    }

    @Override
    public String deleteProduct(int id) {
        Product product = getProductById(id);
        productRepository.delete(product);
        return "Product deleted successfully";
    }

    @Override
    public List<Product> getLowStockProducts() {
        List<Product> allProducts = productRepository.findAll();
        List<Product> lowStockProducts = new ArrayList<>();

        for (Product product : allProducts) {
            if (product.getQuantity() <= product.getLowStockLimit()) {
                lowStockProducts.add(product);
            }
        }

        return lowStockProducts;
    }

}