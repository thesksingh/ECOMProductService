package com.scaler.EcomProductService.controller;

import com.scaler.EcomProductService.dto.ProductListResponseDTO;
import com.scaler.EcomProductService.dto.ProductResponseDTO;
import com.scaler.EcomProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("fakeStoreProductService")
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity getAllProducts(){
        /*
        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15 Pro Max");
        p1.setPrice(150000);
        p1.setCategory("Electronics");
        p1.setImage("www.google.com/images/iphone");
        p1.setDescription("Bahut hi mehanga phone");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Macbook Pro");
        p2.setPrice(250000);
        p2.setCategory("Electronics");
        p2.setImage("www.google.com/images/macbook");
        p2.setDescription("Bahut hi mehanga laptop");

        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);

        */
        ProductListResponseDTO response = productService.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/products/1")
    public ResponseEntity getProductFromId(){
        /*
        ProductResponseDTO p1 = new ProductResponseDTO();
        p1.setId(1);
        p1.setTitle("Iphone 15 Pro Max");
        p1.setPrice(150000);
        p1.setCategory("Electronics");
        p1.setImage("www.google.com/images/iphone");
        p1.setDescription("Bahut hi mehanga phone");

        ProductResponseDTO p2 = new ProductResponseDTO();
        p2.setId(2);
        p2.setTitle("Macbook Pro");
        p2.setPrice(250000);
        p2.setCategory("Electronics");
        p2.setImage("www.google.com/images/macbook");
        p2.setDescription("Bahut hi mehanga laptop");

        List<ProductResponseDTO> products = Arrays.asList(p1, p2);
        return ResponseEntity.ok(products);

        */
        ProductResponseDTO response = productService.getProductById(1);
        return ResponseEntity.ok(response);
    }
}
