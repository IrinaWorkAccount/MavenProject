package org.example.service;

import org.example.dao.ProductRepository;
import org.example.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void save(Product product){
        if (productRepository != null) {
        productRepository.save(product);
    }else {
            throw new RuntimeException("ProductRepository is null");
        }
    }

}
