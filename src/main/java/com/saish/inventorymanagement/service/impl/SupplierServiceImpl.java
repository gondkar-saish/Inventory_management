package com.saish.inventorymanagement.service.impl;

import com.saish.inventorymanagement.dto.SupplierRequest;
import com.saish.inventorymanagement.entity.Supplier;
import com.saish.inventorymanagement.exception.ResourceNotFoundException;
import com.saish.inventorymanagement.repository.SupplierRepository;
import com.saish.inventorymanagement.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier addSupplier(SupplierRequest request) {
        Supplier supplier = new Supplier();

        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setAddress(request.getAddress());

        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplierById(int id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id: " + id));
    }

    @Override
    public Supplier updateSupplier(int id, SupplierRequest request) {
        Supplier supplier = getSupplierById(id);

        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setAddress(request.getAddress());

        return supplierRepository.save(supplier);
    }

    @Override
    public String deleteSupplier(int id) {
        Supplier supplier = getSupplierById(id);
        supplierRepository.delete(supplier);
        return "Supplier deleted successfully";
    }
}