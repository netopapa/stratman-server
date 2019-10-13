package com.virtualmenu.mapper;

import com.virtualmenu.DTO.ShoppingCartDTO;
import com.virtualmenu.model.ShoppingCart;

public class ShoppingCartMapper implements GenericMapper<ShoppingCart, ShoppingCartDTO> {

    private static final RestaurantTableMapper restaurantTableMapper = new RestaurantTableMapper();

    @Override
    public ShoppingCartDTO convertToDTO(ShoppingCart entity) {
        return ShoppingCartDTO.builder()
                .id(entity.getId())
                .closed(entity.getClosed())
                .total(entity.getTotal())
                .table(entity.getTable() != null ? restaurantTableMapper.convertToDTO(entity.getTable()) : null)
                .build();
    }

    @Override
    public ShoppingCart convertToEntity(ShoppingCartDTO dto) {
        return ShoppingCart.builder()
                .id(dto.getId())
                .closed(dto.getClosed())
                .total(dto.getTotal())
                .table(dto.getTable() != null ? restaurantTableMapper.convertToEntity(dto.getTable()) : null)
                .build();
    }
}
