package com.virtualmenu.mapper;

import com.virtualmenu.DTO.RestaurantTableDTO;
import com.virtualmenu.model.RestaurantTable;

public class RestaurantTableMapper implements GenericMapper<RestaurantTable, RestaurantTableDTO> {

    @Override
    public RestaurantTableDTO convertToDTO(RestaurantTable entity) {
        return RestaurantTableDTO.builder()
                .id(entity.getId())
                .busy(entity.getBusy())
                .number(entity.getNumber())
                .build();
    }

    @Override
    public RestaurantTable convertToEntity(RestaurantTableDTO dto) {
        return RestaurantTable.builder()
                .id(dto.getId())
                .busy(dto.getBusy())
                .number(dto.getNumber())
                .build();
    }
}
