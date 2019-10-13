package com.virtualmenu.controller;

import com.virtualmenu.DTO.ItemDTO;
import com.virtualmenu.mapper.ItemMapper;
import com.virtualmenu.model.Item;
import com.virtualmenu.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/itens")
@RestController
public class ItemController extends RESTController<Item, Long, ItemDTO> {

    private static final ItemMapper itemMapper = new ItemMapper();
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        super(itemService, itemMapper);
        this.itemService = itemService;
    }

    @GetMapping("cenario/{id}")
    public ResponseEntity<List<ItemDTO>> getByCenarioId(@PathVariable Long id) {
        List<ItemDTO> items = itemService.getByCenarioId(id).stream().map(item -> itemMapper.convertToDTO(item)).collect(Collectors.toList());
        return ResponseEntity.ok(items);
    }

}
