package com.virtualmenu.service;

import com.virtualmenu.model.Product;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product, Long> {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(
            BaseRepository<Product, Long> repository,
            ProductRepository productRepository
    ) {
        super(repository);
        this.productRepository = productRepository;
    }

}
