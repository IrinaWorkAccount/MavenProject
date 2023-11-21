package org.example.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private Long productId;
    private String productName;
    private String category;
    private int quantityOnStock;

    @OneToMany//(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItem;

    public Product( String productName, String category, Integer quantityOnStock) {
        this.productName = productName;
        this.category = category;
        this.quantityOnStock = quantityOnStock;
    }

    public Product() {
      // Auto-generated constructor stub
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(Integer quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }
}
