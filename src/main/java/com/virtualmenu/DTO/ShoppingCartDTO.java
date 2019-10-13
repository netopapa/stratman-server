package com.virtualmenu.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ShoppingCartDTO {

    private Long id;

    private RestaurantTableDTO table;

    private Boolean closed;

    private BigDecimal total;
}
