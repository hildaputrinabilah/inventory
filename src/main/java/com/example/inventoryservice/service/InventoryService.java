package com.example.inventoryservice.service;

import com.example.inventoryservice.model.Product;

public interface InventoryService {
    Product addProduct(Product product);
    Product updateProductQuantity(Long id, Integer quantity);
    Integer getProductQuantity(Long id);
}