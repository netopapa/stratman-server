package com.virtualmenu.controller;

import com.virtualmenu.DTO.RestaurantTableDTO;
import com.virtualmenu.mapper.RestaurantTableMapper;
import com.virtualmenu.model.RestaurantTable;
import com.virtualmenu.service.RestaurantTableService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/tables")
@RestController
public class RestaurantTableController extends RESTController<RestaurantTable, Long, RestaurantTableDTO> {

    private static final RestaurantTableMapper restaurantTableMapper = new RestaurantTableMapper();
    private RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        super(restaurantTableService, restaurantTableMapper);
        this.restaurantTableService = restaurantTableService;
    }

}
