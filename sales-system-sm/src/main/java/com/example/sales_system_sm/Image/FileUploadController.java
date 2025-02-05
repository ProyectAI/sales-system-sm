package com.example.sales_system_sm.Image;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;
    @PatchMapping("/{id}")
    public ResponseEntity<?> upload(@PathVariable Long id, @RequestParam("image") MultipartFile file){
        return ResponseEntity.ok(fileUploadService.upload(id, file));
    }

}
