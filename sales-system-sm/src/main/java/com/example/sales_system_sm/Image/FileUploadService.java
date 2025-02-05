package com.example.sales_system_sm.Image;

import com.example.sales_system_sm.Product.Model.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface FileUploadService {

    Product upload(Long id, MultipartFile file);
}
