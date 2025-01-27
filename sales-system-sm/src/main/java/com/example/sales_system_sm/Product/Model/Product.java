package com.example.sales_system_sm.Product.Model;


import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Category.Model.Category;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String price;

    @Column(name = "name_product")
    private String nameProduct;
    private String stock;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

}
