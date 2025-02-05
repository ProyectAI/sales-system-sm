package com.example.sales_system_sm.Image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.sales_system_sm.Exceptions.BodyNotValidException;
import com.example.sales_system_sm.Exceptions.InternalServerErrorException;
import com.example.sales_system_sm.Product.Model.Product;
import com.example.sales_system_sm.Product.Repository.SProductImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class FileUploadServiceImpl implements FileUploadService{

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private SProductImpl s;

    @Override
    public Product upload(Long id, MultipartFile file) {

        List<String> allowedExtensions = Arrays.asList("jpg","jpeg","png","webp", "avif");

        Product product= s.findById(id);
        String extensions = null;
        if (file.getOriginalFilename() != null){
            String[] splitName = file.getOriginalFilename().split("\\.");
            extensions = splitName[splitName.length -1];
        }
        if (!allowedExtensions.contains(extensions))throw new BodyNotValidException(
            String.format("Extendion %s not allowed. ", extensions)
                );

        try{
            Map<String, Object> resultUpload = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("folder", "library"));
            String imageUrl = resultUpload.get("secure_url").toString();

            product.setImage(imageUrl);

            s.update(id, product);
            return  product;

        }catch (Exception e){
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
