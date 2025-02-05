package com.example.sales_system_sm.Category.Model;


import com.example.sales_system_sm.Category.DTO.DtoCategorySave;
import com.example.sales_system_sm.Category.DTO.DtoCategoryUpdate;
import com.example.sales_system_sm.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
@SQLDelete(sql= "UPDATE category SET deleted= true WHERE id= ?")
@Where(clause = "deleted = false")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_category")
    private String nameCategory;

    @Column(name = "deleted")
    private Boolean deleted= false;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> product;

    public Category(Long id, String nameCategory, boolean deleted, List<Product> product) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.deleted = deleted;
        this.product = product;
    }

    public Category() {
    }

    public Category(DtoCategorySave dtoCategorySave) {
        this.nameCategory= dtoCategorySave.nameCategory();
        this.deleted= false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void updateData(DtoCategoryUpdate dtoCategoryUpdate) {
        if (dtoCategoryUpdate.nameCategory()!= null){
            this.nameCategory= dtoCategoryUpdate.nameCategory();
        }
    }
}
