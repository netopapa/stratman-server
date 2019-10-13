package com.virtualmenu.repository;

import com.virtualmenu.model.ShoppingCart;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends BaseRepository<ShoppingCart, Long> {
}
