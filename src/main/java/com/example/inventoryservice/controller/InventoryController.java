package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Product;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/products")
    public ResponseEntity<Product> addProductToInventory(@RequestBody Product product) {
        Product savedProduct = inventoryService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/products/{id}/quantity")
    public ResponseEntity<Product> updateProductQuantity(@PathVariable Long id, @RequestBody Integer quantity) {
        Product updatedProduct = inventoryService.updateProductQuantity(id, quantity);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/products/{id}/quantity")
    public ResponseEntity<Integer> getProductQuantity(@PathVariable Long id) {
        Integer quantity = inventoryService.getProductQuantity(id);
        return ResponseEntity.ok(quantity);
    }
}