package com.dev.product.Coffee.implement;

import com.dev.product.Coffee.entity.ProductEntity;
import com.dev.product.Coffee.entity.ProductImagesEntity;
import com.dev.product.Coffee.repository.ProductRepository;
import com.dev.product.Coffee.service.ProductImagesService;
import com.dev.product.Coffee.service.ProductService;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    public String UPLOAD_FOLDER_ROOT = "D:/apiImage/";

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private ProductImagesService productImagesService;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductEntity createProduct(ProductEntity product, MultipartFile productAvatar) throws IOException {
//        if(!productImagesService.isEmptyUploadFile(productAvatar)){
//            String pathToFile = UPLOAD_FOLDER_ROOT + "product/avatar/" + productAvatar.getOriginalFilename();
//
//            productAvatar.transferTo(new File(pathToFile));
//
//            product.setFileImage("product/avatar/" + productAvatar.getOriginalFilename());
//        }

//        if(!productImagesService.isEmptyUploadFile(productPictures)){
//
//            for (MultipartFile pic:
//                    productPictures) {
//                pic.transferTo(new File(UPLOAD_FOLDER_ROOT + "product/pictures" + pic.getOriginalFilename()));
//
//                ProductImagesEntity pi = new ProductImagesEntity();
//                pi.setDownloadURL("product/pictures/" + pic.getOriginalFilename());
//                pi.setPathName(pic.getOriginalFilename());
//
//
//                product.addProductImage(pi);
//            }
//
//        }

//        product.setCreated_date(new Date());
//        product.setSeo(new Slugify().slugify(product.getTitle()));
//        productRepository.save(product);

        return product;
    }

    @Override
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }


}
