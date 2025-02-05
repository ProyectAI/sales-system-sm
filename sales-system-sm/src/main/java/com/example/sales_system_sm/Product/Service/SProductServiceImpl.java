package com.example.sales_system_sm.Product.Service;

import com.example.sales_system_sm.Product.Model.Product;
import com.example.sales_system_sm.Product.Repository.RProduct;
import com.example.sales_system_sm.Product.Repository.SProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SProductServiceImpl implements SProductImpl {


        @Autowired
        private RProduct productRepository;

        @Override
        public Product findById(Long id) {
            return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        }

        @Override
        public Product update(Long id, Product product) {
            Product existingProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            existingProduct.setPrice(product.getPrice());
            existingProduct.setNameProduct(product.getNameProduct());
            existingProduct.setStock(product.getStock());
            existingProduct.setImage(product.getImage());
            existingProduct.setDeleted(product.getDeleted());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setBrand(product.getBrand());
            return productRepository.save(existingProduct);
        }
    }

