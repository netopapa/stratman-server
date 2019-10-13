package com.virtualmenu.mapper;

import com.virtualmenu.DTO.ItemDTO;
import com.virtualmenu.model.Item;

public class ItemMapper implements GenericMapper<Item, ItemDTO> {

    private static final CenarioMapper cenarioMapper = new CenarioMapper();

    @Override
    public ItemDTO convertToDTO(Item entity) {
        return ItemDTO.builder()
                .id(entity.getId())
                .cenario(cenarioMapper.convertToDTO(entity.getCenario()))
                .name(entity.getName())
                .value(entity.getValue())
                .build();
    }

    @Override
    public Item convertToEntity(ItemDTO dto) {
        return Item.builder()
                .id(dto.getId())
                .cenario(cenarioMapper.convertToEntity(dto.getCenario()))
                .name(dto.getName())
                .value(dto.getValue())
                .build();
    }
}
