package com.saish.inventorymanagement.service;

import com.saish.inventorymanagement.dto.SupplierRequest;
import com.saish.inventorymanagement.entity.Supplier;
import java.util.List;

public interface SupplierService {

    Supplier addSupplier(SupplierRequest request);

    List<Supplier> getAllSuppliers();

    Supplier getSupplierById(int id);

    Supplier updateSupplier(int id, SupplierRequest request);

    String deleteSupplier(int id);
}