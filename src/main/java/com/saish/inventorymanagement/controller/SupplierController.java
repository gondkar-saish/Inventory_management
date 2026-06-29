package com.saish.inventorymanagement.controller;

import com.saish.inventorymanagement.dto.SupplierRequest;
import com.saish.inventorymanagement.entity.Supplier;
import com.saish.inventorymanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public Supplier addSupplier(@RequestBody SupplierRequest request) {
        return supplierService.addSupplier(request);
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable int id) {
        return supplierService.getSupplierById(id);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable int id, @RequestBody SupplierRequest request) {
        return supplierService.updateSupplier(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable int id) {
        return supplierService.deleteSupplier(id);
    }
}