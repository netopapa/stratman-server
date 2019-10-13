package com.virtualmenu.mapper;

import com.virtualmenu.DTO.ProductDTO;
import com.virtualmenu.model.Product;

public class ProductMapper implements GenericMapper<Product, ProductDTO> {

    @Override
    public ProductDTO convertToDTO(Product entity) {
        return ProductDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .name(entity.getName())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public Product convertToEntity(ProductDTO dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }
}
