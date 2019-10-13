package com.virtualmenu.mapper;

import com.virtualmenu.DTO.CookingRequestDTO;
import com.virtualmenu.model.CookingRequest;

public class CookingRequestMapper implements GenericMapper<CookingRequest, CookingRequestDTO> {

    private static final ShoppingCartMapper shoppingCartMapper = new ShoppingCartMapper();
    private static final ProductMapper productMapper = new ProductMapper();

    @Override
    public CookingRequestDTO convertToDTO(CookingRequest entity) {
        return CookingRequestDTO.builder()
                .id(entity.getId())
                .isCooking(entity.getIsCooking())
                .product(entity.getProduct() != null ? productMapper.convertToDTO(entity.getProduct()) : null)
                .shoppingCart(entity.getShoppingCart() != null ? shoppingCartMapper.convertToDTO(entity.getShoppingCart()) : null)
                .build();
    }

    @Override
    public CookingRequest convertToEntity(CookingRequestDTO dto) {
        return CookingRequest.builder()
                .id(dto.getId())
                .isCooking(dto.getIsCooking())
                .product(dto.getProduct() != null ? productMapper.convertToEntity(dto.getProduct()) : null)
                .shoppingCart(dto.getShoppingCart() != null ? shoppingCartMapper.convertToEntity(dto.getShoppingCart()) : null)
                .build();
    }
}
