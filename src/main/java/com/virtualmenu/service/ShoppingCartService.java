package com.virtualmenu.service;

import com.virtualmenu.model.RestaurantTable;
import com.virtualmenu.model.ShoppingCart;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.ShoppingCartRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService extends GenericService<ShoppingCart, Long> {

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private RestaurantTableService restaurantTableService;

    private ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartService(
            BaseRepository<ShoppingCart, Long> repository,
            RestaurantTableService restaurantTableService,
            ShoppingCartRepository shoppingCartRepository
    ) {
        super(repository);
        this.shoppingCartRepository = shoppingCartRepository;
        setRestaurantTableService(restaurantTableService);
    }

    @Override
    public ShoppingCart add(ShoppingCart cart) {
        RestaurantTable restaurantTable = restaurantTableService.startTable(cart.getTable().getId());
        cart.setTable(restaurantTable);
        cart.setClosed(false);
        cart.setPayd(false);
        return super.add(cart);
    }

    public ShoppingCart getTheMoney(Long id) {
        ShoppingCart shoppingCart = getNotNull(id);
        shoppingCart.getTable().setBusy(false);

        RestaurantTable table = restaurantTableService.update(shoppingCart.getTable());
        shoppingCart.setTable(table);

        shoppingCart.setPayd(true);
        return super.update(shoppingCart);

    }

}
