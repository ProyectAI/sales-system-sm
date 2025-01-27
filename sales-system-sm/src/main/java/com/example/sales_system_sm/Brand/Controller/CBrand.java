package com.example.sales_system_sm.Brand.Controller;

import com.example.sales_system_sm.Brand.DTO.DtoBrandAswer;
import com.example.sales_system_sm.Brand.DTO.DtoBrandSave;
import com.example.sales_system_sm.Brand.DTO.DtoUpdate;
import com.example.sales_system_sm.Brand.Model.Brand;
import com.example.sales_system_sm.Brand.Repository.RBrand;
import com.example.sales_system_sm.Brand.Service.SBrand;
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
@RequestMapping(path = "/brand")
public class CBrand {

    //---Usando el Servicio de marca----
    @Autowired
    private SBrand s;

    //-----Usando el repositorio de marca----
    @Autowired
    private RBrand r;

    //----Controlador para listar todas las marcas----
    @GetMapping
    public List<Brand> listbrand(){
        return s.searchBrand();
    }

    //---Controlador para listar por nombre de marca----
    @GetMapping("/{name}")
    public Optional<Brand> listByname(@PathVariable String name){
        return s.searchByName(name);
    }

    //----Controlador para registrar una nueva marca------
    @PostMapping
    @Transactional
    public ResponseEntity<DtoBrandAswer> saveBrand(@RequestBody @Valid DtoBrandSave dtoBrandSave, UriComponentsBuilder uriComponentsBuilder){
        Brand brand = s.saveBrand(dtoBrandSave);
        DtoBrandAswer dtoBrandAswer= new DtoBrandAswer(brand.getId(), brand.getNameBrand(), brand.getDeleted());

        URI url= uriComponentsBuilder.path("/brand/{id}").buildAndExpand(brand.getId()).toUri();
        return ResponseEntity.created(url).body(dtoBrandAswer);
    }

    //-----Controlador para actualizar una marca-----
    @PutMapping
    @Transactional
    public ResponseEntity updateBrand(@RequestBody @Valid DtoUpdate dtoUpdate){
        Brand brand = r.getReferenceById(dtoUpdate.id());
        brand.updateData(dtoUpdate);
        return ResponseEntity.ok(new DtoBrandAswer(brand.getId(), brand.getNameBrand(), brand.getDeleted()));
    }


    //----Controlador para hacer una eliminación lógica----
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity deletedBrand(@PathVariable Long id){
        s.deletedBrand(id);
        return ResponseEntity.noContent().build();
    }
}
