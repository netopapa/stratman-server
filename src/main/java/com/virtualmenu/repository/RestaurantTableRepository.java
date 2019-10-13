package com.virtualmenu.repository;

import com.virtualmenu.model.RestaurantTable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantTableRepository extends BaseRepository<RestaurantTable, Long> {

    Optional<RestaurantTable> findByNumber(Integer id);
}
