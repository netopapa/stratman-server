package com.virtualmenu.repository;

import com.virtualmenu.model.Cenario;
import com.virtualmenu.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends BaseRepository<Item, Long> {
    List<Item> findAllByCenario_Id(Long id);
    List<Item> findFirst4ByCenario_IdOrderByValueDesc(Long cenarioId);
}
