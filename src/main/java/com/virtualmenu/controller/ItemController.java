package com.virtualmenu.controller;

import com.virtualmenu.DTO.ItemDTO;
import com.virtualmenu.mapper.ItemMapper;
import com.virtualmenu.model.Item;
import com.virtualmenu.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/itens")
@RestController
public class ItemController extends RESTController<Item, Long, ItemDTO> {

    private static final ItemMapper itemMapper = new ItemMapper();
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        super(itemService, itemMapper);
        this.itemService = itemService;
    }

}
