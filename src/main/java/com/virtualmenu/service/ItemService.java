package com.virtualmenu.service;

import com.virtualmenu.model.Item;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService extends GenericService<Item, Long> {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(
            BaseRepository<Item, Long> repository,
            ItemRepository itemRepository
    ) {
        super(repository);
        this.itemRepository = itemRepository;
    }

}