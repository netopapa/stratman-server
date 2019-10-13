package com.virtualmenu.service;

import com.virtualmenu.model.CookingRequest;
import com.virtualmenu.model.ShoppingCart;
import com.virtualmenu.repository.BaseRepository;
import com.virtualmenu.repository.CookingRequestRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookingRequestService extends GenericService<CookingRequest, Long> {

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private ShoppingCartService shoppingCartService;

    private CookingRequestRepository cookingRequestRepository;

    @Autowired
    public CookingRequestService(
            BaseRepository<CookingRequest, Long> repository,
            ShoppingCartService shoppingCartService,
            CookingRequestRepository cookingRequestRepository
    ) {
        super(repository);
        setShoppingCartService(shoppingCartService);
        this.cookingRequestRepository = cookingRequestRepository;
    }

    @Override
    public CookingRequest add(CookingRequest model) {
        ShoppingCart shoppingCart = shoppingCartService.getNotNull(model.getShoppingCart().getId());
        shoppingCart.setTotal(shoppingCart.getTotal().add(model.getProduct().getPrice()));

        model.setShoppingCart(shoppingCartService.update(shoppingCart));
        return super.add(model);
    }

}
