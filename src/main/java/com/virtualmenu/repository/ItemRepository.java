package com.virtualmenu.repository;

import com.virtualmenu.model.Item;
import com.virtualmenu.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends BaseRepository<Item, Long> {
}
