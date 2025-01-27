package com.example.sales_system_sm.Category.Controller;

import com.example.sales_system_sm.Brand.DTO.DtoBrandAswer;
import com.example.sales_system_sm.Brand.DTO.DtoBrandSave;
import com.example.sales_system_sm.Brand.DTO.DtoUpdate;
import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Brand.Repository.RBrand;
import com.example.sales_system_sm.Brand.Service.SBrand;
import com.example.sales_system_sm.Category.DTO.DtoCategoryAswer;
import com.example.sales_system_sm.Category.DTO.DtoCategorySave;
import com.example.sales_system_sm.Category.DTO.DtoCategoryUpdate;
import com.example.sales_system_sm.Category.Model.Category;
import com.example.sales_system_sm.Category.Repository.RCategory;
import com.example.sales_system_sm.Category.Service.SCategory;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/category")
public class CCategory {

    //---Usando el Servicio de categoria----
    @Autowired
    private SCategory s;

    //-----Usando el repositorio de categoria----
    @Autowired
    private RCategory r;

    //----Controlador para listar todas las categoria----
    @GetMapping
    public List<Category> listcategory(){
        return s.searchCategory();
    }

    //---Controlador para listar por nombre de categoria----
    @GetMapping("/{name}")
    public Optional<Category> listByname(@PathVariable String name){
        return s.searchByName(name);
    }

    //----Controlador para registrar una nueva categoria------
    @PostMapping
    @Transactional
    public ResponseEntity<DtoCategoryAswer> saveCategory(@RequestBody @Valid DtoCategorySave dtoCategorySave, UriComponentsBuilder uriComponentsBuilder){
        Category category = s.saveCategory(dtoCategorySave);
        DtoCategoryAswer dtoCategoryAswer= new DtoCategoryAswer(category.getId(), category.getNameCategory(), category.getDeleted());

        URI url= uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(url).body(dtoCategoryAswer);
    }

    //-----Controlador para actualizar una categoria-----
    @PutMapping
    @Transactional
    public ResponseEntity updateCategory(@RequestBody @Valid DtoCategoryUpdate dtoCategoryUpdate){
        Category category = r.getReferenceById(dtoCategoryUpdate.id());
        category.updateData(dtoCategoryUpdate);
        return ResponseEntity.ok(new DtoBrandAswer(category.getId(), category.getNameCategory(), category.getDeleted()));
    }


    //----Controlador para hacer una eliminación lógica----
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity deletedCategory(@PathVariable Long id){
        s.deletedCategory(id);
        return ResponseEntity.noContent().build();
    }
}
