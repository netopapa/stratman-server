package com.virtualmenu.controller;

import com.virtualmenu.DTO.ProductDTO;
import com.virtualmenu.mapper.ProductMapper;
import com.virtualmenu.model.Product;
import com.virtualmenu.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products")
@RestController
public class ProductController extends RESTController<Product, Long, ProductDTO> {

    private static final ProductMapper productMapper = new ProductMapper();
    private ProductService productService;

    public ProductController(ProductService productService) {
        super(productService, productMapper);
        this.productService = productService;
    }

}
