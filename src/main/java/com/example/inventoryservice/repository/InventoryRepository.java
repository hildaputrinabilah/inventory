package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Product, Long> {
}