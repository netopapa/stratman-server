package com.virtualmenu.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestaurantTableDTO {

    private Long id;

    private Integer number;

    private Boolean busy;
}
