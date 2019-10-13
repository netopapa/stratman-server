package com.virtualmenu.service;

import com.virtualmenu.exception.NotFoundException;
import com.virtualmenu.model.RestaurantTable;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantTableService extends GenericService<RestaurantTable, Long> {

    private RestaurantTableRepository restaurantTableRepository;

    @Autowired
    public RestaurantTableService(
            BaseRepository<RestaurantTable, Long> repository,
            RestaurantTableRepository restaurantTableRepository
    ) {
        super(repository);
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public RestaurantTable startTable(Long id) {
        Optional<RestaurantTable> restaurantTable = restaurantTableRepository.findById(id);
        if (restaurantTable.isPresent()) {
            restaurantTable.get().setBusy(true);
            return super.update(restaurantTable.get());
        } else {
            throw new NotFoundException("Mesa não encontrada");
        }
    }

}
