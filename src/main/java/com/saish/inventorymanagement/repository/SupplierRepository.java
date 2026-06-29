package com.saish.inventorymanagement.repository;

import com.saish.inventorymanagement.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}