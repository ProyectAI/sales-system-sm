package com.example.sales_system_sm.Brand.Model;


import com.example.sales_system_sm.Brand.DTO.DtoBrandSave;
import com.example.sales_system_sm.Brand.DTO.DtoUpdate;
import com.example.sales_system_sm.Product.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;

@Entity
//---Anotación para hacer la eliminación lógica-----
@SQLDelete(sql= "UPDATE brand SET deleted= true WHERE id= ?")
@Where(clause = "deleted = false")
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_brand")
    private String nameBrand;


    //---Columna para hacer la eliminación lógica----
    @Column(name ="deleted")
    private Boolean deleted=false;


    //---Relacionando con la clase producto----
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> product;


    //---Constructor con parámetros---
    public Brand(Long id, String nameBrand, Boolean deleted, List<Product> product) {
        this.id = id;
        this.nameBrand = nameBrand;
        this.deleted = deleted;
        this.product = product;
    }

    //---Constructor vacío----
    public Brand() {
    }

    //----Método para registrar una marca
    public Brand(DtoBrandSave dtoBrandSave) {
        this.nameBrand = dtoBrandSave.nameBrand();
        this.deleted=false;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    //---Creando un metodo para hacer la actualización de marca
    public void updateData(DtoUpdate dtoUpdate) {
        if (dtoUpdate.nameBrand()!=null){
            this.nameBrand = dtoUpdate.nameBrand();
        }

    }
}
