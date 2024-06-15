package com.example.inventoryservice.service;

import com.example.inventoryservice.model.Product;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Product addProduct(Product product) {
        return inventoryRepository.save(product);
    }

    @Override
    public Product updateProductQuantity(Long id, Integer quantity) {
        Product product = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setQuantity(quantity);
        return inventoryRepository.save(product);
    }

    @Override
    public Integer getProductQuantity(Long id) {
        Product product = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return product.getQuantity();
    }
}